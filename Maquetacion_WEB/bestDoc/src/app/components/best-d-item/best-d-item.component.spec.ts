import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BestDItemComponent } from './best-d-item.component';

describe('BestDItemComponent', () => {
  let component: BestDItemComponent;
  let fixture: ComponentFixture<BestDItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BestDItemComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BestDItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
