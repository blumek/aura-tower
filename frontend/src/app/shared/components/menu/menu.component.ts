import { NgFor, NgIf } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { DeviceConfigDialogComponent } from '../dialogs/device-config-dialog/device-config-dialog.component';
import { SnackbarService } from '../../services/snackbar.service';

@Component({
  selector: 'app-menu',
  standalone: true,
  imports: [NgFor, NgIf],
  templateUrl: './menu.component.html',
  styleUrl: './menu.component.scss'
})
export class MenuComponent {
  @Input() isAreaChangeMenu: boolean = false;
  @Input() menuItems: any[] = [];
  @Output() menuItemSelected = new EventEmitter();

  constructor (
    private router: Router,
    private dialog: MatDialog,
    private snackBarService: SnackbarService
  ) {}
  
  onMenuIteMSelected(elementId: number) {
    let actionName;

    if (this.isAreaChangeMenu) {
      actionName = this.foundItem(elementId);
    } else {
      actionName = this.foundItem(elementId);
    }
    
    switch (actionName) {
      case 'full-screen':
        document.documentElement.requestFullscreen();
        this.menuItems[0] = {icon: 'fullscreen_exit', name: 'Wyjdź z trybu pełnoekranowego', action: 'full-screen-exit'}
        break;
      case 'full-screen-exit':
        document.exitFullscreen();
        this.menuItems[0] = {icon: 'fullscreen', name: 'Tryb pełnoekranowy', action: 'full-screen'}
        break;
      case 'add-device':
        this.snackBarService.openSnackBar('Komponent w budowie', true);
        break;
      default:
        console.log('navigate')
        const link: string = actionName
        this.router.navigate([link]);
    }

    this.menuItemSelected.emit();
  }

  foundItem(id: number): any {
    const foundItem = this.menuItems.find(item => item.id === id).action;
    return foundItem ? foundItem : id;
  }

  openAddDeviceDialog(): void {
    const dialogRef = this.dialog.open(DeviceConfigDialogComponent);

    dialogRef.afterClosed().subscribe((result) => {
      console.log(`Dialog result: ${result}`);
    });
  }
}
