import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { BestDPropietarioComponent } from './documentos/best-d-propietario/best-d-propietario.component';
import { DocumentosComponent } from './documentos/documentos.component';
import { NewDocumentComponent } from './new-document/new-document.component';



const routes: Routes = [
  {
    path: 'documentos/propietario',
    component: BestDPropietarioComponent
  },
  {
    path: 'documentos/nuevo',
    component: NewDocumentComponent
  },
  {
    path: 'documentos',
    component: DocumentosComponent
  },
  {
    path: '',
    component: DashboardComponent
  },
  {
    path: '**',
    component: DashboardComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
