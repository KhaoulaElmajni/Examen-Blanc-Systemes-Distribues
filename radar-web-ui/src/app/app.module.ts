import {APP_INITIALIZER, NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { RadarsComponent } from './radars/radars.component';
import { VehiclesComponent } from './vehicles/vehicles.component';
import { OwnsersComponent } from './ownsers/ownsers.component';
import {KeycloakSecurityService} from "./services/keycloak-security.service";
import {HttpClientModule} from "@angular/common/http";
import { EventsComponent } from './events/events.component';

export function kcFactory(kcSecurity: KeycloakSecurityService) {
  return () => kcSecurity.init();
}

@NgModule({
  declarations: [
    AppComponent,
    RadarsComponent,
    VehiclesComponent,
    OwnsersComponent,
    EventsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FontAwesomeModule
  ],
  providers: [
    {provide: APP_INITIALIZER, deps: [KeycloakSecurityService], useFactory:kcFactory, multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
