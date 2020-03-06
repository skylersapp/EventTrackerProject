import { ComponentFactory } from '@angular/core';

export class Jobs {

  //FIELDS

  id: number;
  company: string;
  dateApplied: string;
  position: string;
  firstInterview: string;
  interviewer: string;
  dateFollowup: string;
  dateNext: string;
  positionOffered: boolean;
  salary: number;

  constructor(id?: number, company?: string,  dateApplied?: string, position?: string, firstInterview?: string, interviewer?: string,
    dateFollowup?: string, dateNext?: string, positionOffered: boolean = false,  salary?: number){

      this.id = id;
      this.company = company;
      this.dateApplied = dateApplied;
      this.position = position;
      this.firstInterview = firstInterview;
      this.interviewer = interviewer;
      this.dateFollowup = dateFollowup;
      this.dateNext = dateNext;
      this.positionOffered = positionOffered;
      this.salary = salary;
  }

  //METHODS







}
