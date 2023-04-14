import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InvoicegeneratorComponent } from './invoicegenerator.component';

describe('InvoicegeneratorComponent', () => {
  let component: InvoicegeneratorComponent;
  let fixture: ComponentFixture<InvoicegeneratorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InvoicegeneratorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InvoicegeneratorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
