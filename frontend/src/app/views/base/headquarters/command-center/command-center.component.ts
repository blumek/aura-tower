import { Component, EventEmitter, Input, Output } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { ConfirmationDialogComponent } from '../../../../shared/components/dialogs/confirmation-dialog/confirmation-dialog.component';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { CommandCenter, ConfigModeTypes } from '../../models/comand-center';
import { CommandCenterService } from '../../services/command-center.service';
import { SnackbarService } from '../../../../shared/services/snackbar.service';
import { CommandCenterForm } from '../../models/forms';

@Component({
  selector: 'at-command-center',
  templateUrl: './command-center.component.html',
  styleUrl: './command-center.component.scss',
})
export class CommandCenterComponent {
  @Input() centerData!: CommandCenter;
  @Input() configModeType!: ConfigModeTypes;
  @Output() saveAction = new EventEmitter<any>();
  @Output() refreshAction = new EventEmitter<any>();

  iconsCatalog = new Map<string, string>([
    ['HOME', 'home'],
    ['OFFICE', 'apartment'],
    ['GARAGE', 'garage_home'],
    ['OTHER', 'other_houses'],
  ]);
  configModeTypes = ConfigModeTypes;
  centerDataPre: CommandCenter = {
    name: '',
    icon: '',
  };

  commandCenterForm: FormGroup<CommandCenterForm> = this.fb.group({
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
    return this.commandCenterForm.get('centerIcon') as FormControl<string>;
  }

  get centerNameControl(): FormControl<string> {
    return this.commandCenterForm.get('centerName') as FormControl<string>;
  }

  goToTowerDashboard(e: any): void {
    const { action } = e.target.dataset;

    if (!action) this.router.navigate(['main/dashboard/', this.centerData.id]);
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
      if (result) {
        this.commandCenterService
          .deleteCommandCenter(this.centerData.id!)
          .subscribe({
            next: () => {
              this.refreshAction.emit();
              this.snackbarService.openSnackBar(
                'Management center deleted',
                false
              );
            },
            error: (err) => {
              this.snackbarService.openSnackBar(err.error.message, true);
            },
          });
      }
    });
  }

  setIcon(iconData: any): void {
    this.centerIconControl.setValue(iconData[0]);
    this.centerData.icon = iconData[1];
  }

  add(): void {
    this.centerData = {
      name: '',
      icon: 'question_mark',
    };

    this.edit();
  }

  edit(): void {
    this.centerDataPre = { ...this.centerData };
    this.configModeType = ConfigModeTypes.config;

    this.commandCenterForm.patchValue({
      centerIcon: this.centerData.icon,
      centerName: this.centerData.name,
    });
  }

  cancel(): void {
    if (this.centerData.id) {
      this.centerData = this.centerDataPre;
      this.configModeType = ConfigModeTypes.normal;
    } else {
      this.configModeType = ConfigModeTypes.add;
    }
  }

  save(): void {
    if (this.commandCenterForm.valid) {
      if (this.centerData.id) {
        this.centerData = {
          name: this.centerNameControl.value,
          icon: this.centerIconControl.value,
        };
        this.configModeType = ConfigModeTypes.normal;
      } else {
        this.saveAction.emit({
          addingMode: true,
          centerName: this.centerNameControl.value,
          centerIcon: this.centerIconControl.value,
        });
      }
    }
  }
}
