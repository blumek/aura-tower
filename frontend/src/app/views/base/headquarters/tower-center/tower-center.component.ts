import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { ConfirmationDialogComponent } from '../../../../shared/components/dialogs/confirmation-dialog/confirmation-dialog.component';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'at-tower-center',
  templateUrl: './tower-center.component.html',
  styleUrl: './tower-center.component.scss'
})
export class TowerCenterComponent implements OnInit {
  @Input() isAAddingComponent: boolean = false;
  @Input() centerData: any = {};
  @Output() cancelAction = new EventEmitter<boolean>();
  @Output() saveAction = new EventEmitter<any>();
  configMode: boolean = false;

  managementCenterForm: FormGroup<any> = this.fb.group({
    centerIcon: ['', Validators.required],
    centerName: ['', Validators.required]
  });

  constructor(
    private router: Router,
    private dialog: MatDialog,
    private fb: FormBuilder,
  ){}

  get centerIconControl(): FormControl<string> {
    return this.managementCenterForm.get('centerIcon') as FormControl<string>
  }

  get centerNameControl(): FormControl<string> {
    return this.managementCenterForm.get('centerName') as FormControl<string>
  }

  ngOnInit(): void {
    this.configMode = this.centerData.configMode ? true : false;
  }

  goToTowerDashboard(): void {
    if (!this.configMode && !this.isAAddingComponent) {
      this.router.navigate(['main/dashboard'])
    }
  }

  openDeleteDialog(): void {
    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      data: {
        title: 'Delete the management center',
        content: 'Deletion will permanently disable the dashboard and all devices stored in it. The changes will be irreversible',
        cancelButtonText: 'Cancel',
        acceptButtonText: 'Delete'
      }
    });

    dialogRef.afterClosed().subscribe((result) => {
      console.log(`Dialog result: ${result}`);
    });
  }

  cancel(): void {
    if (this.centerData.id) {
      this.cancelAction.emit(false);
    } else {
      this.cancelAction.emit(true);
    }
  }

  save(): void {
    console.log(this.centerNameControl.value)
  }
  

}
