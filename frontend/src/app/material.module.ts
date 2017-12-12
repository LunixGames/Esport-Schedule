import { NgModule } from '@angular/core';
import { MatSidenavModule, MatToolbarModule } from '@angular/material';

@NgModule({
  imports: [
    MatSidenavModule,
    MatToolbarModule,
  ],
  exports: [
    MatSidenavModule,
    MatToolbarModule
  ]
})
export class MaterialModule { }
