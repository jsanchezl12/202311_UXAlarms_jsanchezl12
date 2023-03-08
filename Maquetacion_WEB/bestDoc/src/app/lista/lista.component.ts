import { Component, OnInit } from '@angular/core';
import listaDocumentos from '../../../assets/json/documentos.json';
@Component({
  selector: 'app-lista',
  templateUrl: './lista.component.html',
  styleUrls: ['./lista.component.scss']
})
export class ListaComponent implements OnInit{

    documentos: any = listaDocumentos;
    
    constructor() { }

    ngOnInit(): void {
    }

}
