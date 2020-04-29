import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {MainComponent} from './main-component/main.component';
import {RouterModule, Routes} from "@angular/router";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSliderModule } from '@angular/material/slider';
import {MainService} from "./main-component/service/main.service";
import { HttpClientModule } from '@angular/common/http';
import {MatButtonModule} from "@angular/material/button";
import {FormsModule} from "@angular/forms";
import {MatCardModule} from '@angular/material/card';
import {MatDividerModule} from '@angular/material/divider';
import {MatInputModule} from '@angular/material/input';

const routes: Routes = [
  {path: 'main-view', component: MainComponent},
  {path: '', component: AppComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    MainComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    BrowserAnimationsModule,
    MatSliderModule,
    HttpClientModule,
    MatButtonModule,
    FormsModule,
    MatCardModule,
    MatDividerModule,
    MatInputModule,

  ],
  providers: [
    MainService,

  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
