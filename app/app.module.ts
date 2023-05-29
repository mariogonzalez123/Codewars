import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListadoComponent } from './listado/listado.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ServiceService } from '../app/Service/service.service';
import { HttpClientModule } from '@angular/common/http';
import { KataComponent } from './kata/kata.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { SwaggerComponent } from './swagger/swagger.component';

@NgModule({
  declarations: [
    AppComponent,
    ListadoComponent,
    KataComponent,
    SwaggerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    CommonModule,
    FormsModule

  ],
  providers: [ServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
