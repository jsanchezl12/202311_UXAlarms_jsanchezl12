import { Component, OnInit } from '@angular/core';
import listaDocumentos from '../../../assets/json/documentos.json';
import {MatIconModule} from '@angular/material/icon';

@Component({
  selector: 'app-best-d-item',
  templateUrl: './best-d-item.component.html',
  styleUrls: ['./best-d-item.component.scss']
})
export class BestDItemComponent implements OnInit {

  documentos: any = listaDocumentos;

  statusItem = "inactivo";

  constructor() { }

  ngOnInit(): void {
  }

}
