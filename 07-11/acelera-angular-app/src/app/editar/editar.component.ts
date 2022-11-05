import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { PessoaService } from '../core/service/pessoa.service';

@Component({
  selector: 'app-editar',
  templateUrl: './editar.component.html',
  styleUrls: ['./editar.component.css']
})
export class EditarComponent implements OnInit {

  itemId: string | null = null
  form: FormGroup = new FormGroup({
    nome: new FormControl(),
    idade: new FormControl(),
    profissao: new FormControl(),
  });

  constructor(private route: ActivatedRoute, private formBuilder: FormBuilder, private router: Router,
    private pessoaService: PessoaService) { }

  ngOnInit(): void {
    const routeParams = this.route.snapshot.paramMap;
    this.itemId = routeParams.get('id')
    if (this.itemId) {
      this.pessoaService.findPessoaById(this.itemId).subscribe(res => {
        if (res)
          this.form = this.formBuilder.group({
            nome: [res.nome, [Validators.required]],
            idade: [res.idade, [Validators.required]],
            profissao: [res.profissao, [Validators.required]],
          });
        else
          this.form = this.formBuilder.group({
            nome: ['', [Validators.required]],
            idade: ['', [Validators.required]],
            profissao: ['', [Validators.required]],
          });
      })

    }

  }

  atualizar(): void {

    if (this.form.valid) {
      this.pessoaService.save({
        ...this.form.value,
        id: this.itemId
      }).subscribe(() => {
        console.warn('Seu cadastro foi atualizado com sucesso!');
        this.router.navigate([''])
      })

    }
  }

}
