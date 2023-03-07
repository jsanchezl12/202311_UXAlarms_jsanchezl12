import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BestDSemaforoComponent } from './best-d-semaforo.component';

describe('BestDSemaforoComponent', () => {
  let component: BestDSemaforoComponent;
  let fixture: ComponentFixture<BestDSemaforoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BestDSemaforoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BestDSemaforoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
