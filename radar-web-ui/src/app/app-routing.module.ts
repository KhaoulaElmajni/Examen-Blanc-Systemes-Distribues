import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {RadarsComponent} from "./radars/radars.component";
import {OwnsersComponent} from "./ownsers/ownsers.component";
import {VehiclesComponent} from "./vehicles/vehicles.component";
import {EventsComponent} from "./events/events.component";

const routes: Routes = [
  {path: "radars", component: RadarsComponent},
  {path: "ownsers", component: OwnsersComponent},
  {path: "vehicles", component: VehiclesComponent},
 // {path: "**", redirectTo: "radars"},
  {path: "events/:radarId", component: EventsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
