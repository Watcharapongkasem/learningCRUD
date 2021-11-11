import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GetdataService } from 'src/app/service/getdata.service';
import { View } from 'src/app/viewModel/view';

@Component({
  selector: 'app-studentModule',
  templateUrl: './studentModule.component.html',
  styleUrls: ['./studentModule.component.scss'],
})
export class StudentModuleComponent implements OnInit {
  model?: Array<View>;

  constructor(private getdata: GetdataService, private router: Router) {}

  ngOnInit() {
    this.reloadPage();
  }

  reloadPage() {
    this.getdata.getAll().then((data) => {
      this.model = data;
    });
  }

  onEdit(userId: any) {
    this.router.navigate(['/student', 'edit', userId]);
  }

  onDelete(userId: any) {
    this.getdata.deleteData(userId).then((res)=>{
      if(res){
        this.reloadPage();
      }
    })
    
  }
}
