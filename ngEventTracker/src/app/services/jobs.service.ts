import { Injectable } from '@angular/core';
import { Jobs } from '../models/jobs';
import { HttpClient } from '@angular/common/http'


@Injectable({
  providedIn: 'root'
})
export class JobsService {

  //FIELDS
  url = "http://localhost:5050/api/jobs"

  private jobs: Jobs[] =
  [
    new Jobs(1, 'Skill Distillery', 'March 04, 2020', "person", 'March 10, 2020', "Briana Young", null, null, false, null)
  ];

  //CONSTRUCTORS

  constructor(private http: HttpClient) { }

  //METHODS

  index() {
    return this.http.get(this.url).pipe()
  }

  create(jobsItem: Jobs){
    return this.http.post(this.url, jobsItem).pipe();
  }

  put(jobsItem: Jobs, id: number) {
    return this.http.put<Jobs>(this.url + "/" + id, jobsItem).pipe();
  }

  delete(id: number) {
    return this.http.delete(this.url + "/" + id).pipe();
  }
}
