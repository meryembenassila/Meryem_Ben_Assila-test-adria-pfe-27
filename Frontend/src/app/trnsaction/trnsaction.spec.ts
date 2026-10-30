import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Trnsaction } from './trnsaction';

describe('Trnsaction', () => {
  let component: Trnsaction;
  let fixture: ComponentFixture<Trnsaction>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Trnsaction],
    }).compileComponents();

    fixture = TestBed.createComponent(Trnsaction);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
