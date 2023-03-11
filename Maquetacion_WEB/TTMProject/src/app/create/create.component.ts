import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.scss']
})
export class CreateComponent implements OnInit {

  alarmType: string = 'Clásica';
  sonido: string = '';
  constructor() { }

  ngOnInit() {
  }

  changeAlarmType(alarmType_: string) {
    console.log(alarmType_);
    this.alarmType = alarmType_;
  }

  changeSonido(sonido_: string) {
    console.log(sonido_);
    this.sonido = "Sonido " + sonido_;
  }

}
