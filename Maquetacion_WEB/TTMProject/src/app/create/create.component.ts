import { Component, OnInit } from '@angular/core';
import { AnimationOptions } from 'ngx-lottie';
import { Alarma } from '../modelos/alarma';
import { interval, Subscription } from 'rxjs';
import {Router} from '@angular/router';


@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.scss']
})
export class CreateComponent implements OnInit {

  //alarmType: string = '';
  lottieConfig: Object;
  anim: any;
  alarmType: string = '';
  sonido: string = '';
  isVoiceRecognition: boolean = false;
  alarmas: Array<Alarma> = [];
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

  changeAlarmType(alarmType_: string) {
    this.alarmType = alarmType_;
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
      console.log("addAlarma")
      this.addAlarma();
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
    this.alarmas.push(new Alarma(this.alarmas.length, "Alarma " + this.alarmas.length, this.alarmType, "2023-03-18", "12:12 PM", "Diaria", this.sonido));
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


}
