import { Component, OnInit } from '@angular/core';
import { StepData, VisibleConfig } from '../models/intro';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { ConfirmationDialogComponent } from '../../../shared/components/dialogs/confirmation-dialog/confirmation-dialog.component';

@Component({
  selector: 'at-intro',
  templateUrl: './intro.component.html',
  styleUrl: './intro.component.scss',
})
export class IntroComponent implements OnInit {
  imgSrc: string = '../../../../assets/images/intro/welcome_to_at.svg';
  title: string = '';
  description: string = 'Przygotowaliśmy dla Ciebie krótkie wprowadzenie do Aura Tower. W kilku krokach pokażemy co umożliwia aplikacja i jak zacząć z niej korzystać. Zaczynamy?';
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
      title: 'Na co pozwoli ci Aura Tower?',
      description: 'Dodawaj, zarządzaj, steruj inteligentynymi urządzeniami w Twoim domu, biurze... Z poziomu dowolnego urządzenia przejdź do dashboardu i zobacz swoje urządzenia, dziel je na zdefiniowane obszary i udostępniaj innym użytkownikom z Twojego centrum zarządzania',
    },
    {
      imgSrc: '../../../../assets/images/intro/create_center.svg',
      title: 'Stwórz własne centrum dowodzenia',
      description: 'Na początek stwórz własne centrum dowodzenia czyli miejsce w którym będziesz dodawać swoje inteligentne urządzenia. Chcesz podzielić urządzenia na te znajdujące się np. w mieszkaniu i te w biurze? Nie ma problemu - jedno centrum zarządzania jest odpowiednikiem jednego obszaru',
    },
    {
      imgSrc: '../../../../assets/images/intro/welcome_to_at.svg',
      title: 'Wypełnij swój dashboard',
      description: 'W kolejnym etapie dodaj swoje urządzenia smart, przechodząc przez krótki proces konfiguratora, wybieraj odpowiedni typ urządzenia, jego nazwę i wizualizację danych na ekranie',
    },
    {
      imgSrc: '../../../../assets/images/intro/welcome_to_at.svg',
      title: 'Jesteś programistą?',
      description: 'Aura Tower to tylko solidna podstawa w świecie IoT, rozwijaj swoje centum zarządzania dodając nowe wtyczki, obsługę nowych urządzeń i funkcjonalności',
    },
  ];

  constructor(
    private dialog: MatDialog,
    private router: Router,
  ) {}

  ngOnInit(): void {
    this.showElements();
  }

  hideAllElements(): void {
    this.visibleConfig = {
      image: false,
      title: false,
      description: false,
      button: false,
    }
  }

  showElements(): void {
    setTimeout(() => this.visibleConfig.image = true, 500);
    setTimeout(() => this.visibleConfig.title = true, 2000);
    setTimeout(() => this.visibleConfig.description = true, 3000);
    setTimeout(() => this.visibleConfig.button = true, 5000);
  }

  changeStep(step?: number): void {
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

  goToBaseCenter(): void {
  
  }

  skipIntro(): void {
    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      data: {
        title: 'Pominąć wprowadzenie?',
        content: 'Jeśli pominiesz to wprowadzenie, nie będziesz mógł do niego wrócić w przyszłości',
        cancelButtonText: 'Anuluj',
        acceptButtonText: 'Pomiń'
      }
    });

    dialogRef.afterClosed().subscribe((result) => {
      console.log(`Dialog result: ${result}`);
    });
  }
}
