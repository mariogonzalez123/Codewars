import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Ejercicio } from '../Modelo/Ejercicio';

import { ServiceService } from '../Service/service.service';


@Component({
  selector: 'listado',
  templateUrl: './listado.component.html',
  styleUrls: ['./listado.component.css']
})
export class ListadoComponent implements OnInit {
  ejercicios: Ejercicio[] = [];

  constructor(private service: ServiceService) { }


  ngOnInit(): void {
    this.service.getEjercicios()
      .subscribe(data => {
        this.ejercicios = data;

        console.log(this.ejercicios);
      })
  }

}
