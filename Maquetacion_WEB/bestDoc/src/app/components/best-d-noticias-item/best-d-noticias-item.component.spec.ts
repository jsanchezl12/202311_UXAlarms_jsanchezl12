import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BestDNoticiasItemComponent } from './best-d-noticias-item.component';

describe('BestDNoticiasItemComponent', () => {
  let component: BestDNoticiasItemComponent;
  let fixture: ComponentFixture<BestDNoticiasItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BestDNoticiasItemComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BestDNoticiasItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
