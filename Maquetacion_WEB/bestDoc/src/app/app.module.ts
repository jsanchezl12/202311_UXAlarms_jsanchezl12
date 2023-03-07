import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DashboardComponent } from './dashboard/dashboard.component';
import { BestDGridComponent } from './components/best-d-grid/best-d-grid.component';
import { BestDItemComponent } from './components/best-d-item/best-d-item.component';
import { BestDNoticiasComponent } from './components/best-d-noticias/best-d-noticias.component';
import { BestDNoticiasItemComponent } from './components/best-d-noticias-item/best-d-noticias-item.component';
import { BestDSemaforoComponent } from './components/best-d-semaforo/best-d-semaforo.component';
import { BestDSemaforoItemComponent } from './components/best-d-semaforo-item/best-d-semaforo-item.component';
import { BestDeToggleViewComponent } from './components/bestDControls/best-de-toggle-view/best-de-toggle-view.component';
import { MatIconModule } from '@angular/material/icon';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    BestDGridComponent,
    BestDItemComponent,
    BestDNoticiasComponent,
    BestDNoticiasItemComponent,
    BestDSemaforoComponent,
    BestDSemaforoItemComponent,
    BestDeToggleViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatIconModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
