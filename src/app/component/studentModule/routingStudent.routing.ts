import { Routes, RouterModule } from '@angular/router';
import { AddlistComponent } from './addlist/addlist.component';
import { StudentModuleComponent } from './studentModule.component';

const routes: Routes = [
  { path: '', component: StudentModuleComponent },
  { path: 'addlist', component: AddlistComponent },
  { path: 'edit/:id', component: AddlistComponent },
];

export const RoutingStudentRoutes = RouterModule.forChild(routes);
