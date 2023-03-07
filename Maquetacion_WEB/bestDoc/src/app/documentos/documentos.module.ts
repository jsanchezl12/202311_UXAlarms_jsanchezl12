import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NewDocumentComponent } from '../new-document/new-document.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { ListaComponent } from '../lista/lista.component';

@NgModule({
  declarations: [
    NewDocumentComponent,
    ListaComponent
  ],
  imports: [
    CommonModule,
    MatFormFieldModule,
    MatInputModule
  ]
})
export class DocumentosModule { }
