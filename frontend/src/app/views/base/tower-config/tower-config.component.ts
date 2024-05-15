import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, NonNullableFormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'at-tower-config',
  templateUrl: './tower-config.component.html',
  styleUrl: './tower-config.component.scss'
})
export class TowerConfigComponent {
  @Input() show: boolean = false;
  @Output() close = new EventEmitter<boolean>();

  loadingButton: boolean = false;
  towerConfigForm: FormGroup<any> = this.fb.group({
    name: ['', Validators.required],
    icon: ['', Validators.required],
  })

  constructor(
    private fb: FormBuilder
  ) {}

  get towerNameControl(): FormControl<string> {
    return this.towerConfigForm.get('name') as FormControl<string>
  }

  get towerIconControl(): FormControl<string> {
    return this.towerConfigForm.get('icon') as FormControl<string>
  }

  closeConfigMode(): void {
    this.close.emit(true)
  }
}
