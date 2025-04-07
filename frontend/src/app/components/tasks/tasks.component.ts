import { HttpClient } from '@angular/common/http';
import { Component, inject, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Itask } from '../../model/class/interface/task';
import { CommonModule } from '@angular/common';
import { NewTask } from '../../model/class/newTask';

@Component({
  selector: 'app-tasks',
  imports: [FormsModule, CommonModule],
  templateUrl: './tasks.component.html',
  styleUrl: './tasks.component.css'
})
export class TasksComponent implements OnInit{


  
  title: string = '';
  description: string = '';
  status: string = "";
  taskId: number | null = null; // ---------------1
  isUpdating: boolean = false;
 

  taskList: Itask [] = [];
  http = inject(HttpClient);


  ngOnInit(): void {
    this.getAllTasks();
  }

  getAllTasks()
  {

    this.http.get("http://localhost:8081/api/tasks").subscribe((res:any)=> {

      this.taskList = res;

    }) 

  }

  addTask()
  {
    const newTask  = new NewTask();
    newTask.title = this.title
    newTask.description = this.description;
    newTask.status = this.status;
    newTask.createdAt = new Date();

    const payload = {
      ...newTask,
      createdAt: newTask.createdAt.toISOString().slice(0,19)
    }

    this.http.post("http://localhost:8081/api/task", payload).subscribe((res)=>{
      this.clearForm();
      this.getAllTasks();
      alert("successful");
    })


  }

  updateTask() {
    if (this.taskId === null) return;
  
    const updatedTask = {
      id: this.taskId,
      title: this.title,
      description: this.description,
      status: this.status,
      createdAt: new Date().toISOString().slice(0, 19) 
    };
  
    this.http.put('http://localhost:8081/api/task', updatedTask).subscribe((res) => {
      this.clearForm();
      this.getAllTasks(); 
      this.isUpdating = false;
      alert('Task updated successfully!');
    });
  }

  editTask(task: Itask) { 
    this.title = task.title;
    this.description = task.description;
    this.status = task.status;
    this.taskId = task.id;
    this.isUpdating = true;
  }

 

  clearForm()
  {
    this.title = '';
    this.description = '';
    this.status = '';
    this.taskId = null; 
    this.isUpdating = false;
    
  }

  removeTask(id: number)
  {

    this.http.delete(`http://localhost:8081/api/task/${id}`).subscribe(
      (res) => {
        this.getAllTasks();
        alert("successful");
      },
      (error)=>{
        console.log("Error occured", error);
        alert("Failed");
      }
    )

  }

}
