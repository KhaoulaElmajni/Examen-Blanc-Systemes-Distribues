import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-radars',
  templateUrl: './radars.component.html',
  styleUrls: ['./radars.component.css']
})
export class RadarsComponent implements OnInit {

  radars:any;
  events:any;

  constructor(private http: HttpClient,
              private router:Router) { }

  ngOnInit(): void {
    /*this.radars=[
      {id:1,name:"Galle",longitude:100,latitude:100,maxSpeed:100,road:"Galle Road",status:"Active",overSpeedCount:100},
      {id:2,name:"Matara",longitude:100,latitude:100,maxSpeed:100,road:"Matara Road",status:"Active",overSpeedCount:100},
      {id:3,name:"Colombo",longitude:100,latitude:100,maxSpeed:100,road:"Colombo Road",status:"Active",overSpeedCount:100},
      {id:4,name:"Kandy",longitude:100,latitude:100,maxSpeed:100,road:"Kandy Road",status:"Active",overSpeedCount:100},
      {id:5,name:"Jaffna",longitude:100,latitude:100,maxSpeed:100,road:"Jaffna Road",status:"Active",overSpeedDetections:100},
      {id:6,name:"Kurunegala",longitude:100,latitude:100,maxSpeed:100,road:"Kurunegala Road",status:"Active",overSpeedDetections:100}
      ];*/

    this.http.get("http://localhost:8883/query/radars/all").subscribe({
      next : (data)=>{
        this.radars = data;
      },
      error : (err)=>{

      }
    })
  }


  editRadar(radarId: any) {

  }

  deleteRadar(radarId: any) {

  }

  getEventStore(radarId: any) {
    this.router.navigateByUrl("/events/"+radarId);
  }
}
