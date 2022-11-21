import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { PessoaService } from '../core/service/pessoa.service';

@Component({
  selector: 'app-adicionar',
  templateUrl: './adicionar.component.html',
  styleUrls: ['./adicionar.component.css']
})
export class AdicionarComponent implements OnInit {

  form: FormGroup = new FormGroup({});

  constructor(private formBuilder: FormBuilder, private router: Router, private pessoaService: PessoaService) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      nome: ['', [Validators.required]],
      idade: ['', Validators.required],
      profissao: ['', Validators.required],
    });
  }

  novo(): void {

    if (this.form.valid) {
      this.pessoaService.save(this.form.value)
        .subscribe(() => {
          console.warn('Seu cadastro foi realizado com sucesso!');
          this.router.navigate([''])
        })

    }
  }

}
