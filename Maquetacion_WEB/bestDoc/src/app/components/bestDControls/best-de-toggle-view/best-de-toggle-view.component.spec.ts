import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BestDeToggleViewComponent } from './best-de-toggle-view.component';

describe('BestDeToggleViewComponent', () => {
  let component: BestDeToggleViewComponent;
  let fixture: ComponentFixture<BestDeToggleViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BestDeToggleViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BestDeToggleViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
