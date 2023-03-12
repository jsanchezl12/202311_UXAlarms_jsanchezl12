import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EditComponent } from './edit.component';
import { LottieModule } from 'ngx-lottie';

@NgModule({
  imports: [
    CommonModule,
    LottieModule.forRoot({ player: () => import('lottie-web') })
  ],
  declarations: [EditComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class EditModule { }
