import { Injectable } from '@angular/core';
import { Jobs } from '../models/jobs';


@Injectable({
  providedIn: 'root'
})
export class JobsService {

  //FIELDS

  private jobs: Jobs[] =
  [
    new Jobs(1, 'Skill Distillery', 'March 04, 2020', "person", 'March 10, 2020', "Briana Young", null, null, false, null)
  ];

  //CONSTRUCTORS

  constructor() { }

  //METHODS

  index(): Jobs[] {
    return [...this.jobs];
  }

  create(jobsItem: Jobs){
    this.jobs.push(jobsItem);
  }



}
