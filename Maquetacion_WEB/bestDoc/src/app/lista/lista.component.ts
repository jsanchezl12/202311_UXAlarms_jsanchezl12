import { Component, OnInit } from '@angular/core';
import listaDocumentos from '../../assets/json/documentos.json';
import { MatIconModule } from '@angular/material/icon';
import {Router} from '@angular/router';
@Component({
  selector: 'app-lista',
  templateUrl: './lista.component.html',
  styleUrls: ['./lista.component.scss']
})
export class ListaComponent implements OnInit {

  documentos: any = listaDocumentos;

  statusItem = "inactivo";


  constructor(private router: Router) { }

  goPropietario(propietarioName: string){
    this.router.navigate(['/documentos/propietario'], { queryParams: { name: propietarioName } });

  }

  ngOnInit(): void {
  }

}
