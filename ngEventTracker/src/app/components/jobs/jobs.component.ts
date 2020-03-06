import { Component, OnInit } from '@angular/core';
import { Jobs } from 'src/app/models/jobs';
import { JobsService } from 'src/app/services/jobs.service';

@Component({
  selector: 'app-jobs',
  templateUrl: './jobs.component.html',
  styleUrls: ['./jobs.component.css']
})
export class JobsComponent implements OnInit {

  //FIELDS

  jobs: Jobs[] = [];
  selected: Jobs = null;
  editJob: Jobs = new Jobs();
  newJob: Jobs = new Jobs();
  addJobBool = false

  //CONSTRUCTORS

  constructor(private jobsSvc: JobsService) { }

  //METHODS

  addJobButton(){
    this.addJobBool = true;
  }

  getNumberOfJobs(){
    return this.jobs.length;
  }

  displayJob (jobs: Jobs){
    console.log(jobs)
    this.selected = jobs;
  }

  goBack(){
    this.selected = null;
  }
  destroyJob(id: number){
    return this.jobs = null;
  }

  setEditTodo(){
    this.editJob = Object.assign({}, this.selected);
  }
  generateId() {
    return this.jobs[this.jobs.length - 1].id + 1;
  }
  onSubmit(){
    this.getNumberOfJobs();
    this.addJobBool = false;
  }

  addJob(){
    this.newJob.id = this.generateId();
    this.newJob.company = null;
    this.newJob.dateApplied = null;
    this.newJob.position = null;
    this.newJob.firstInterview = null;
    this.newJob.interviewer = null;
    this.newJob.dateFollowup = null;
    this.newJob.dateNext = null;
    this.newJob.positionOffered = false;
    this.newJob.salary = null;

  // ________________________________

    this.jobs.push(this.newJob);
    this.newJob = new Jobs();
  }

  ngOnInit(){
    this.jobs = this.jobsSvc.index();
  }

}
