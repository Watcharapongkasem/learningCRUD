import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { StudentModuleComponent } from './studentModule.component';
import { RoutingStudentRoutes } from './routingStudent.routing';
import { AddlistComponent } from './addlist/addlist.component';


@NgModule({
  imports: [
    CommonModule,
    RoutingStudentRoutes,
    FormsModule,
    ReactiveFormsModule,
  ],
  declarations: [StudentModuleComponent,AddlistComponent],
})
export class StudentModuleModule {}
