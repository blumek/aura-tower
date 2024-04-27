import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-intro',
  templateUrl: './intro.component.html',
  styleUrl: './intro.component.scss',
})
export class IntroComponent {
  @ViewChild('imgElement') imgElement!: ElementRef;

  imgSrc: string = '../../../../assets/images/intro/welcome_to_at.svg';
  title: string = '';
  description: string = 'Przygotowaliśmy dla Ciebie krótkie wprowadzenie do Aura Tower. W kilku krokach pokażemy co umożliwia aplikacja i jak zacząć z niej korzystać. Zaczynamy?';
  step: number = 0;
  allSteps: number = 4;
  visibleConfig = {
    image: true,
    title: true,
    description: true,
    button: true,
  }

  changeStep(step?: number): void {
    this.visibleConfig = {
      image: false,
      title: false,
      description: false,
      button: false,
    }
    this.step = step !== undefined ? step : this.step += 1;

    switch (this.step) {
      case 1:
        this.imgSrc = '../../../../assets/images/intro/welcome_to_at.svg';
        this.title = 'Na co pozwoli ci Aura Tower?';
        this.description = 'Moglibyśmy się rozpisywać ale w skrócie: Dodawaj, zarządzaj, steruj inteligentynymi urządzeniami w Twoim domu, biurze... Z poziomu dowolnego urządzenia przejdź do swojego dashboardu i zobacz soje urządzenia, dziel je na zdefiniowane przez siebie obszary i udostępniaj innym możliwość podglądu i sterowania urządzeniami z wybranych obszarów'
        break;
      case 2:
        this.imgSrc = '../../../../assets/images/intro/welcome_to_at.svg';
        this.title = 'Stwóz własne centum dowodzenia';
        this.description = 'Na początek stwórz własne centrum dowodzenia czyli miejsce w którym będziesz dodawać swoje inteligentne urządzenia. Chcesz podzielić urządzenia na te znajdujące się np. w mieszkaniu i te w biurze? Nie ma problemu - jedno centrum zarządzania jest odpowiednikiem jednego obszaru z Twoimi urządzeniami'
        break;
      case 3:
        this.imgSrc = '../../../../assets/images/intro/welcome_to_at.svg';
        this.title = 'Wypełnij swój dashboard ';
        this.description = 'W kolejnym etapie dodaj swoje urządzenia smart, przechodząd przez krótki proces konfiguratora, wybierając odpowiedni typ urządzenia, jego nazwę i wizualizację danych na ekranie'
        break;
      case 4:
        this.imgSrc = '../../../../assets/images/intro/welcome_to_at.svg';
        this.title = 'Jesteś programistą?';
        this.description = 'Aura Tower to tylko solidna podstawa w świecie IoT, rozwijaj swoje centum zarządzania dodając nowe wtyczki i obsługę nowych urządzeń  i funkcjonalności';
        break;
    }

    setTimeout(() => {
      this.visibleConfig = {
        image: true,
        title: true,
        description: true,
        button: true,
      }
    }, 2000)
  }

  skipIntro(): void {
  
  }
}
