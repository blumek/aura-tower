import { Component, OnInit } from '@angular/core';
import { StepData, VisibleConfig } from '../models/intro';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { ConfirmationDialogComponent } from '../../../shared/components/dialogs/confirmation-dialog/confirmation-dialog.component';
import { NgClass, NgIf, NgOptimizedImage } from '@angular/common';
import { SliderStepperComponent } from '../../../shared/components/slider-stepper/slider-stepper.component';

@Component({
  selector: 'at-intro',
  templateUrl: './intro.component.html',
  styleUrl: './intro.component.scss',
  standalone: true,
  imports: [NgClass, NgIf, SliderStepperComponent, NgOptimizedImage],
})
export class IntroComponent implements OnInit {
  imgSrc: string = '../../../../assets/images/intro/welcome_to_at.svg';
  title: string = '';
  description: string =
    'We have prepared for you a short introduction to Aura Tower. In a few steps we will show you what the application enables and how to start using it. Getting started?';
  step: number = 0;
  allSteps: number = 4;
  visibleConfig: VisibleConfig = {
    image: false,
    title: false,
    description: false,
    button: false,
  };
  stepsData: StepData[] = [
    {
      imgSrc: '../../../../assets/images/intro/what_at_can_give_you.svg',
      title: 'What will Aura Tower allow you to do?',
      description:
        'Add, manage, control smart devices in your home, office.... From any device, go to the dashboard and see your devices, divide them into defined areas and share them with other users from your management center',
    },
    {
      imgSrc: '../../../../assets/images/intro/create_center.svg',
      title: 'Create your own command center',
      description:
        'For begining, create your own command center, that is, a place where you can add your smart devices and control them. Want to divide your devices into specific area? No problem - one command center is the equivalent of one area',
    },
    {
      imgSrc: '../../../../assets/images/intro/fill_dashboard.svg',
      title: 'Fill out your dashboard',
      description:
        'In the next step, add your smart devices by going through a short configurator process, choose the appropriate type of device, its name and data visualization on the screen',
    },
    {
      imgSrc: '../../../../assets/images/intro/programmer.svg',
      title: 'Are you a programmer?',
      description:
        'Aura Tower is just a solid foundation in the world of IoT, expand your management center by adding new plugins, support for new devices and functionality',
    },
  ];

  constructor(private dialog: MatDialog, private router: Router) {}

  ngOnInit(): void {
    this.showElements();
  }

  hideAllElements(): void {
    this.visibleConfig = {
      image: false,
      title: false,
      description: false,
      button: false,
    };
  }

  showElements(): void {
    setTimeout(() => (this.visibleConfig.image = true), 500);
    setTimeout(() => (this.visibleConfig.title = true), 2000);
    setTimeout(() => (this.visibleConfig.description = true), 3000);
    setTimeout(() => (this.visibleConfig.button = true), 5000);
  }

  changeStep(step?: number): void {
    if (this.visibleConfig.button) {
      this.step = step !== undefined ? step : this.step + 1;

      if (this.step <= this.allSteps) {
        const stepData = this.stepsData[this.step - 1];
        this.imgSrc = stepData.imgSrc;
        this.title = stepData.title;
        this.description = stepData.description;
      }

      this.hideAllElements();
      this.showElements();
    }
  }

  goToBaseHeadquarters(): void {
    if (this.visibleConfig.button) this.router.navigate(['/base/headquarters']);
  }

  skipIntro(): void {
    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      data: {
        title: 'Skip the introduction?',
        content:
          'If you skip this introduction, you will not be able to return to it in the future',
        cancelButtonText: 'Cancel',
        acceptButtonText: 'Confirm',
      },
      autoFocus: false
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        this.goToBaseHeadquarters();
      }
    });
  }
}
