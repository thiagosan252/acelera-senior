import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdicionarComponent } from './adicionar/adicionar.component';
import { EditarComponent } from './editar/editar.component';
import { HomeComponent } from './home/home.component';
import { ListarComponent } from './listar/listar.component';

const routes: Routes = [
  { path: '', component: HomeComponent, title: 'Início' },
  { path: 'adicionar', component: AdicionarComponent, title: 'Adicionar' },
  { path: 'editar/:id', component: EditarComponent, title: 'Editar' },
  { path: 'listar', component: ListarComponent, title: 'Listar' },
  { path: '**', redirectTo: '' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
