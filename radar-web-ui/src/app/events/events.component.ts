import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.css']
})
export class EventsComponent implements OnInit {

  events : any;
  radarId!:number;

  constructor(private http: HttpClient,
              private router:Router,
              private route: ActivatedRoute) {
    this.radarId = route.snapshot.params['radarId'];
  }

  ngOnInit(): void {
    this.http.get("http://localhost:8181/commands/eventStore/"+this.radarId)
      .subscribe({
        next : (data)=>{
          this.events = data;
        },
        error : (err)=>{

        }
      })
  }

  getEventDetails(event: any) {

  }
}
