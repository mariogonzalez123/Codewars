import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { KataComponent } from './kata/kata.component';
import { ListadoComponent } from './listado/listado.component';


const routes: Routes = [
  { path: 'listado', component: ListadoComponent },
  { path: 'app', component: AppComponent },
  { path: 'kata/:id', component: KataComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
