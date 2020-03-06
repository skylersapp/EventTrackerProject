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

  jobs;
  selected = null;
  editJob: Jobs = new Jobs();
  newJob: Jobs = new Jobs();
  addJobBool = false;
  editJobBool = false;

  //CONSTRUCTORS

  constructor(private jobsSvc: JobsService) { }

  //METHODS

  addJobButton(){
    this.addJobBool = true;
  }

  updateJobButton(){
    this.editJobBool = true;
    this.editJob = Object.assign({}, this.selected)
  }

  getNumberOfJobs(){
    console.log(this.jobs)
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
    this.jobsSvc.delete(id).subscribe(
       job => {
         this.jobs = this.jobs.filter( x => { return x.id !== id})
       }
    )
  }

  onSubmit(){
    this.getNumberOfJobs();
    this.addJobBool = false;
  }

  onSubmitUpdate(){
    this.getNumberOfJobs();
    this.editJobBool = false;
  }

  addJob(){
    this.jobsSvc.create(this.newJob).subscribe(
      job => {
        this.jobs.push(job)
      },
      error => {
        console.log(error)
      }
    )
  }

  updateJob(){
    this.jobsSvc.put(this.editJob, this.selected.id).subscribe(
      job => {
        this.jobs = this.jobs.map( x => {
          if(x.id === job.id) {
            this.selected = job;
            return this.editJob;
          }
          return x;
        })
      }
    )
  }

  ngOnInit(){
    this.jobsSvc.index().subscribe(
      jobs => {
        console.log(jobs)
        this.jobs = jobs;
      },
      error => console.log(error)
    );
  }

}
