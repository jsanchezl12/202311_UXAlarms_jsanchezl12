import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BestDGridComponent } from './best-d-grid.component';

describe('BestDGridComponent', () => {
  let component: BestDGridComponent;
  let fixture: ComponentFixture<BestDGridComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BestDGridComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BestDGridComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
