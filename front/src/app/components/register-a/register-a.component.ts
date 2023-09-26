import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Customer } from 'src/app/models/Customer.model';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/examples/service/customer.service';

@Component({
  selector: 'app-register-a',
  templateUrl: './register-a.component.html',
  styleUrls: ['./register-a.component.scss']
})
export class RegisterAComponent {
  selectedDniType: string = 'DNI';
  registrationForm!: FormGroup;
  newCustomer : Customer = {
    id: 0,
    email: '',
    name: '',
    surname: '',    
    dni: '',
    surname2: '',
    street: '',
    number: 0,
    portal: 0,
    floor: 0,
    letter: '',
    postalCode: '',
    municipality: '',
    province: '',
    password: '',
    confirmPassword: ''
  } 

  constructor(
    private formBuilder: FormBuilder,
    private http: HttpClient, 
    private router: Router,
    private customerService: CustomerService
  ) {
    this.registrationForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email, Validators.pattern(/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/)]],
      dniType: ['', Validators.required],
      dni: ['', [Validators.required, Validators.pattern('[0-9]{8}[A-Z]')]],
      name: ['', [Validators.required, Validators.pattern('[A-Za-z]*')]],
      surname: ['', [Validators.required, Validators.pattern('[A-Za-z]*')]],
      surname2: ['', [Validators.required, Validators.pattern('[A-Za-z]*')]],
      street: ['', [Validators.required]],
      number: [''],
      gate: [''],
      stairs: [''],
      floor: [''],
      letter: [''],
      postalCode: [''],
      town: [''],
      province: [''],
      password: ['', [Validators.required, Validators.minLength(6)]],
      confirmPassword: ['', [Validators.required]]
    }, { validators: this.passwordMatchValidator.bind(this) });
  }  
  
}