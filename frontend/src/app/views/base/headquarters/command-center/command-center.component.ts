import {
  Component,
  EventEmitter,
  Input,
  OnChanges,
  OnInit,
  Output,
} from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { ConfirmationDialogComponent } from '../../../../shared/components/dialogs/confirmation-dialog/confirmation-dialog.component';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { managementCetersIcons } from '../../../../shared/mocks/management-centers';
import { ConfigModeTypes } from '../../models/comand-center';
import { CommandCenterService } from '../../services/command-center.service';
import { SnackbarService } from '../../../../shared/services/snackbar.service';

@Component({
  selector: 'at-command-center',
  templateUrl: './command-center.component.html',
  styleUrl: './command-center.component.scss',
})
export class CommandCenterComponent implements OnInit, OnChanges {
  @Input() centerData: any = {};
  @Input() configModeType!: ConfigModeTypes;
  @Output() cancelAction = new EventEmitter<boolean>();
  @Output() saveAction = new EventEmitter<any>();
  @Output() addAction = new EventEmitter<any>();
  @Output() refreshAction = new EventEmitter<any>();

  iconsCatalog = managementCetersIcons;
  configModeTypes = ConfigModeTypes;
  centerDataPre = {}

  managementCenterForm: FormGroup<any> = this.fb.group({
    centerIcon: ['', Validators.required],
    centerName: ['', Validators.required],
  });

  constructor(
    private commandCenterService: CommandCenterService,
    private snackbarService: SnackbarService,
    private router: Router,
    private dialog: MatDialog,
    private fb: FormBuilder
  ) {}

  get centerIconControl(): FormControl<string> {
    return this.managementCenterForm.get('centerIcon') as FormControl<string>;
  }

  get centerNameControl(): FormControl<string> {
    return this.managementCenterForm.get('centerName') as FormControl<string>;
  }

  ngOnInit(): void {
    this.checkConfigModeType();
  }

  ngOnChanges(): void {
    this.checkConfigModeType();
  }

  checkConfigModeType(): void {
    if (this.configModeType !== ConfigModeTypes.add) {
      this.configModeType = this.centerData.configModeType
        ? this.centerData.configModeType
        : this.configModeTypes.normal;
    }
  }

  goToTowerDashboard(e: any): void {
    const {action} = e.target.dataset

    if(!action) this.router.navigate(['main/dashboard']);
  }

  openDeleteDialog(): void {
    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      data: {
        title: 'Delete the management center',
        content:
          'Deletion will permanently disable the dashboard and all devices stored in it. The changes will be irreversible',
        cancelButtonText: 'Cancel',
        acceptButtonText: 'Delete',
      },
    });

    dialogRef.afterClosed().subscribe((result) => {
      if(result) {
        this.commandCenterService.deleteCommandCenter(this.centerData.id).subscribe({
          next: () => {
            this.refreshAction.emit();
            this.snackbarService.openSnackBar('Management center deleted', false);
          },
          error: (err) => {
            this.snackbarService.openSnackBar(err.error.message, true);
          }
        })
      }
    });
  }

  setIcon(iconData: any): void {
    this.centerIconControl.setValue(iconData.icon);
    this.centerData.icon = iconData.icon;
  }

  add(): void {
    this.addAction.emit(true);
  }

  editComandCenter(): void{
    this.centerDataPre = {...this.centerData}
    this.configModeType = ConfigModeTypes.config

    this.managementCenterForm.patchValue({
      centerIcon: this.centerData.icon,
      centerName: this.centerData.name,
    })
  }

  cancel(): void {
    if (this.centerData.id) {
      this.centerData = this.centerDataPre
      this.configModeType = ConfigModeTypes.normal
    } else {
      this.cancelAction.emit(true);
    }
  }

  save(): void {
    if (this.managementCenterForm.valid) {
      setTimeout(() => {
        if (this.centerData.id) {
          this.centerData = {
            name: this.centerNameControl.value,
            icon: this.centerIconControl.value,
          }
          this.configModeType = ConfigModeTypes.normal
          
        } else {
          this.saveAction.emit({
            addingMode: true,
            centerName: this.centerNameControl.value,
            centerIcon: this.centerIconControl.value,
          });
        }
      }, 0);
    }
  }
}
