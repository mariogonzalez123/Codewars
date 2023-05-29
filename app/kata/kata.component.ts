import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ejercicio } from '../Modelo/Ejerc';
import { objJson } from '../Modelo/ObjJson';
import { ServiceService } from '../Service/service.service';

@Component({
  selector: 'app-kata',
  templateUrl: './kata.component.html',
  styleUrls: ['./kata.component.css']
})
export class KataComponent implements OnInit {
  valor: number = 0;
  ejercicios: ejercicio = {};
  texto?: string;
  jsonObj = '';
  estado?: string;
  objJson: objJson = {};
  
  constructor(private activatedRoute: ActivatedRoute, private service: ServiceService, private ref: ChangeDetectorRef) {
    activatedRoute.params.subscribe(prm => {
      this.valor = prm['id'];
    })
  }

  parseTestSimples(codigo:string, id:number) {

    this.objJson = { codigo, id };
    this.jsonObj = JSON.stringify(this.objJson);
    this.service.enviarDatos(this.jsonObj).subscribe(
      (data) => {
        console.log('success', data)
        this.estado = data;
      },
      (error) => {
        this.estado = error;
        console.log(this.estado);
      });
  }
  parseTestOcultos(codigo: string, id: number) {

    this.objJson = { codigo, id };
    this.jsonObj = JSON.stringify(this.objJson);
    this.service.enviarAttepmt(this.jsonObj).subscribe(
      (data) => {
        console.log('success', data)
        this.estado = data;
      },
      (error) => {
        this.estado = error;
        console.log(this.estado);
      });
  }

  ngOnInit(): void {
    this.service.getEjerciciosById(this.valor)
      .subscribe(data => {
        this.ejercicios = data;
      })
  }
}
