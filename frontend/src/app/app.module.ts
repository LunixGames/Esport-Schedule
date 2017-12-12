import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import {NoopAnimationsModule} from '@angular/platform-browser/animations';

import { StoreModule } from '@ngrx/store';
import { reducers } from '../reducers';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { MaterialModule } from './material.module';
import { EventsComponent } from './events/events.component';


@NgModule({
  declarations: [
    AppComponent,
    EventsComponent
  ],
  imports: [
    BrowserModule,
    NoopAnimationsModule,
    StoreModule.forRoot(reducers),
    AppRoutingModule,
    MaterialModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
