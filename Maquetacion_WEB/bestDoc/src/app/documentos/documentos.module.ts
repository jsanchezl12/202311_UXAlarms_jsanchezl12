import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NewDocumentComponent } from '../new-document/new-document.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { BestDPropietarioComponent } from './best-d-propietario/best-d-propietario.component';
import { AppRoutingModule } from '../app-routing.module';
import { DocumentosComponent } from './documentos.component';
import {MatIconModule} from '@angular/material/icon';
import { ListaComponent } from '../lista/lista.component';
@NgModule({
  declarations: [
    DocumentosComponent,
    NewDocumentComponent,
    BestDPropietarioComponent,
  ],
  imports: [
    CommonModule,
    AppRoutingModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    
  ],
  bootstrap: [DocumentosComponent]
})
export class DocumentosModule { }
