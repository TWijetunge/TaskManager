import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { TasksComponent } from './components/tasks/tasks.component';

export const routes: Routes = [
    { path: '', component: HomeComponent },
  { path: 'tasks', component: TasksComponent }
];
