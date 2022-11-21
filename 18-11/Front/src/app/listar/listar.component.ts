import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Pessoa } from '../core/model/Pessoa';
import { PessoaService } from '../core/service/pessoa.service';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit {

  headers: string[] = ['Nome', 'Idade', 'Profissao', 'Opções'];
  data: Pessoa[] = []

  constructor(private router: Router, private pessoaService: PessoaService) { }

  ngOnInit(): void {
    this.buscar()
  }

  editar(id?: string): void {
    this.router.navigate(['editar', id]);
  }

  remover(id?: string): void {
    this.pessoaService.delete(id || '').subscribe((res) => {
      this.buscar()
     })
  }

  buscar(): void {
    this.pessoaService.findAll().subscribe(res => {
      this.data = res
    })
  }

}
