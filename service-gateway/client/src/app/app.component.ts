import { Component } from '@angular/core';
import { HttpClient } from "@angular/common/http";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(private http: HttpClient) {

  }
  shortUrl = '';
  longUrlValue = '';

  doPOST(value: String) {
    this.longUrlValue = '';
    this.http.post("/short", value, {responseType: 'text'}).subscribe(res => this.shortUrl = res.valueOf());
  }

}


