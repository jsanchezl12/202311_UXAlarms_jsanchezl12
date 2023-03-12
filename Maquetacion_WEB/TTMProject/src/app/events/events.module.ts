import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EventsComponent } from './events.component';
import { LottieModule } from 'ngx-lottie';
@NgModule({
  imports: [
    CommonModule,
    LottieModule.forRoot({ player: () => import('lottie-web') })
  ],
  declarations: [EventsComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class EventsModule { }
