import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BestDNoticiasComponent } from './best-d-noticias.component';

describe('BestDNoticiasComponent', () => {
  let component: BestDNoticiasComponent;
  let fixture: ComponentFixture<BestDNoticiasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BestDNoticiasComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BestDNoticiasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
