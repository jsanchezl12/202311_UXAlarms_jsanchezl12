import { Component, OnInit } from '@angular/core';
import { AnimationOptions } from 'ngx-lottie';
import { Alarma } from '../modelos/alarma';
import { interval, Subscription } from 'rxjs';
import {Router} from '@angular/router';

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.scss']
})
export class EventsComponent implements OnInit {

  //alarmType: string = '';
  lottieConfig: Object;
  anim: any;
  eventType: string = 'Lista';
  sonido: string = '';
  isVoiceRecognition: boolean = false;
  alarmas: Array<Alarma> = [];
  alarmasFecha: Array<Alarma> = [];
  options: AnimationOptions = {
    path: '/assets/sound-voice-waves.json',
    autoplay: false
  };
  subscription: Subscription = new Subscription();
  dateInputId: string = "";
  repetirInputId: string = "";
  descripcionInputId: string = "";
  nvInputId: string = "";

  constructor(private router: Router) {
    this.lottieConfig = {
      path: '../assets/sound-voice-waves.json',
      background: 'transparent',
      speed: 1,
      renderer: 'canvas',
      autoplay: true,
      loop: true
    };
    this.alarmas.push(new Alarma(this.alarmas.length, "Alarma " + this.alarmas.length, 'Clásica', "2023-03-01", "11:11 AM", "Diaria", 'Sonido 1'));
    this.alarmas.push(new Alarma(this.alarmas.length, "Alarma " + this.alarmas.length, 'Nota de Voz', "2023-03-02", "11:12 AM", "Diaria", 'Sonido 3'));
    this.alarmas.push(new Alarma(this.alarmas.length, "Alarma " + this.alarmas.length, 'Nota de Voz', "2023-03-03", "11:14 AM", "Diaria", 'Sonido 2'));
    this.alarmas.push(new Alarma(this.alarmas.length, "Alarma " + this.alarmas.length, 'Clásica', "2023-03-04", "11:15 AM", "Diaria", 'Sonido 5'));

    this.alarmasFecha.push(new Alarma(this.alarmas.length, "Alarma " + this.alarmas.length, 'Clásica', "2023-03-05", "11:16 AM", "Diaria", 'Sonido 4'));
  }

  ngOnInit() {
  }

  onAnimate(animationItem: Animation): void {
    console.log(animationItem);
    this.anim = animationItem;
  }
  stop() {
    this.anim.stop();
  }

  play() {
    this.anim.play();
  }

  pause() {
    this.anim.pause();
  }

  changeEventType(eventType_: string) {
    this.eventType = eventType_;
    if (this.isVoiceRecognition == true) {
      this.isVoiceRecognition = false;
      this.pause();
      this.subscription.unsubscribe();
    }
  }

  changeSonido(sonido_: string) {
    this.sonido = "Sonido " + sonido_;
  }


  startVoiceRecognition() {
    console.log("startVoiceRecognition")
    this.changeAnimation();
    if (this.isVoiceRecognition == true) {
      this.startCreatingAlarm();
    } else {
      this.stopCreatingAlarm();
    }
  }

  startCreatingAlarm() {
    console.log("startCreatingAlarm")
    this.subscription = interval(3000).subscribe(x => {
      console.log("alterAlarma")
      //this.addAlarma();
      this.alterAlarmas();
    });
  }

  stopCreatingAlarm() {
    console.log("stopCreatingAlarm")
    this.subscription.unsubscribe();
  }

  changeAnimation() {
    console.log("changeAnimation")
    if (this.isVoiceRecognition == false) {
      this.play();
      this.isVoiceRecognition = true;
    } else {
      this.pause();
      this.isVoiceRecognition = false;
    }
  }
  addAlarma() {
    this.alarmas.push(new Alarma(this.alarmas.length, "Alarma " + this.alarmas.length, 'Clásica', "2023-03-18", "12:12 PM", "Diaria", 'Sonido 1'));
  }

  changeDateInputId(id: string) {
    this.dateInputId = id;
  }

  saveDate() {
    const dateIn = document.getElementById(this.dateInputId) as HTMLInputElement;
    dateIn.value = "2023-03-18";
  }

  changeRepetirInputId(id: string) {
    this.repetirInputId = id;
  }

  saveRepetir() {
    const repetirIn = document.getElementById(this.repetirInputId) as HTMLInputElement;
    repetirIn.value = "Diaria";
  }

  changeDescripcionInputId(id: string) {
    this.descripcionInputId = id;
  }

  saveDescripcion() {
    const descripcionIn = document.getElementById(this.descripcionInputId) as HTMLInputElement;
    const descTextModal = document.getElementById("descTextModal") as HTMLInputElement;
    descripcionIn.value = descTextModal.value;
    descTextModal.value = "";

  }

  changeNVInputId(id: string) {
    this.nvInputId = id;
  }

  saveNV() {
    const nvIn = document.getElementById(this.nvInputId) as HTMLInputElement;
    nvIn.value = "grab_1";
  }

  irEditar(alarmty: string) {
    if (this.isVoiceRecognition == true) {
      this.isVoiceRecognition = false;
      this.pause();
      this.subscription.unsubscribe();
    }
    this.router.navigate(['/edit'], { queryParams: { alarmType: alarmty } });
  }

  regresarHome() {
    if (this.isVoiceRecognition == true) {
      this.isVoiceRecognition = false;
      this.pause();
      this.subscription.unsubscribe();
    }
    this.router.navigate(['/home']);
  }

  irEventos() {
    if (this.isVoiceRecognition == true) {
      this.isVoiceRecognition = false;
      this.pause();
      this.subscription.unsubscribe();
    }
    this.router.navigate(['/events']);
  }

  alterAlarmas() {
    this.alarmas = [];
    let qty = this.getRandomInt(10);
    for (let i = 0; i < qty; i++) {
      this.alarmas.push(new Alarma(this.alarmas.length, "Alarma " + this.alarmas.length, 'Clásica', "2023-03-18", "12:12 PM", "Diaria", 'Sonido 1'));
    }
  }
  alterAlarmasFecha() {
    this.alarmasFecha = [];
    let qty = this.getRandomInt(5);
    for (let i = 0; i < qty; i++) {
      this.alarmasFecha.push(new Alarma(this.alarmasFecha.length, "Alarma " + this.alarmasFecha.length, 'Clásica', "2023-03-18", "12:12 PM", "Diaria", 'Sonido 1'));
    }
  }

  getRandomInt(max: number): number {
    return Math.floor(Math.random() * max);
  }

}
