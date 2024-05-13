import { Component, Input } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { ConfirmationDialogComponent } from '../../../../shared/components/dialogs/confirmation-dialog/confirmation-dialog.component';

@Component({
  selector: 'at-tower-center',
  templateUrl: './tower-center.component.html',
  styleUrl: './tower-center.component.scss'
})
export class TowerCenterComponent {
  @Input() isAAddingComponent: boolean = false;

  constructor(
    private router: Router,
    private dialog: MatDialog
  ){}

  goToTowerDashboard(): void {
    this.router.navigate(['main/dashboard'])
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
  

}
