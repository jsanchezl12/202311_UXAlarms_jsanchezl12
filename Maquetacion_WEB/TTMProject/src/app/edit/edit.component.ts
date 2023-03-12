import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.scss']
})
export class EditComponent implements OnInit {
  alarmType: string = 'Clásica';
  sonido: string = '';
  dateInputId: string = "";
  repetirInputId: string = "";
  descripcionInputId: string = "";
  nvInputId: string = "";
  constructor(private activate_router: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.activate_router.queryParams.subscribe(params => {
      this.alarmType = params['alarmType']  ? params['alarmType'] : 'Clásica';
    });
  }

  changeAlarmType(alarmType_: string) {
    this.alarmType = alarmType_;
  }

  changeSonido(sonido_: string) {
    this.sonido = "Sonido " + sonido_;
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
    this.router.navigate(['/home']);
  }

  irEventos() {
    this.router.navigate(['/events']);
  }

}
