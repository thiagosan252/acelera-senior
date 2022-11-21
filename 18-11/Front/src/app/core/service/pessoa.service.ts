import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { API_BASE_URL, ENDPOINT } from '../constants';
import { Pessoa } from '../model/Pessoa';

@Injectable({
  providedIn: 'root'
})
export class PessoaService {

  constructor(private http: HttpClient) { }

  save(pessoa: Pessoa): Observable<Pessoa[]> {
    return this.http.post<Pessoa[]>(`${API_BASE_URL}/${ENDPOINT.PESSOA}`, pessoa)
  }

  delete(id: string): Observable<Pessoa> {
    return this.http.delete<Pessoa>(`${API_BASE_URL}/${ENDPOINT.PESSOA}/${id}`)
  }

  findPessoaById(id: string): Observable<Pessoa> {
    return this.http.get<Pessoa>(`${API_BASE_URL}/${ENDPOINT.PESSOA}/${id}`)

  }

  findAll(): Observable<Pessoa[]> {
    return this.http.get<Pessoa[]>(`${API_BASE_URL}/${ENDPOINT.PESSOA}`)
  }
}
