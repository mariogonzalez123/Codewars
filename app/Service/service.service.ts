import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Ejercicio } from '../Modelo/Ejercicio';
import { ejercicio } from '../Modelo/Ejerc';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  constructor(private http: HttpClient) { }
  Url = 'http://localhost:8080/ejercicios';
  UrlTest = 'http://localhost:8080/tests';

  getEjercicios() {
    return this.http.get<Ejercicio[]>(this.Url);
  }

  getEjerciciosById(id: number) {
    return this.http.get<ejercicio>(this.Url + '/' + id);
  }

  enviarDatos(body: string) {
    console.log(body);
    return this.http.post(this.Url + '/sol', body, { responseType: 'text' })
  }
  enviarAttepmt(body: string) {
    console.log(body);
    return this.http.post(this.UrlTest + '/sol', body, { responseType: 'text' })
  }
  }
