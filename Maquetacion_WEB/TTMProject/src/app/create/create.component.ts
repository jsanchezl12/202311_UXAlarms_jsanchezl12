import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.scss']
})
export class CreateComponent implements OnInit {

  alarmType: string = '';
  sonido: string = '';
  constructor() { }

  ngOnInit() {
  }

  changeAlarmType(alarmType_: string) {
    this.alarmType = alarmType_;
  }

  changeSonido(sonido_: string) {
    this.sonido = "Sonido " + sonido_;
  }

}
