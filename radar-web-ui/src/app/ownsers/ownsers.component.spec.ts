import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OwnsersComponent } from './ownsers.component';

describe('OwnsersComponent', () => {
  let component: OwnsersComponent;
  let fixture: ComponentFixture<OwnsersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OwnsersComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OwnsersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
