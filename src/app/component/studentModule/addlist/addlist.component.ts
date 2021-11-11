import { flatten } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { GetdataService } from 'src/app/service/getdata.service';
import { View } from 'src/app/viewModel/view';

@Component({
  selector: 'app-addlist',
  templateUrl: './addlist.component.html',
  styleUrls: ['./addlist.component.scss'],
})
export class AddlistComponent implements OnInit {
  studentForm!: FormGroup;
  edit!: any;
  isInvaild = false;
  constructor(
    private formbuilder: FormBuilder,
    private editdata: GetdataService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.edit = this.route.snapshot.paramMap.get('id');
    this.studentForm = this.formbuilder.group({
      student: ['', Validators.required],
      class: ['', Validators.required],
      teacher: ['', Validators.required],
    });

    if (this.edit) {
      this.editdata.getOne(this.edit).then((data: View) => {
        this.studentForm.get('student')?.setValue(data.studentName);
        this.studentForm.get('class')?.setValue(data.classname);
        this.studentForm.get('teacher')?.setValue(data.teacherName);
      });
    }
  }
  onSubmit() {
    let viewModel = new View();
    viewModel.userId = this.edit;
    viewModel.studentName = this.studentForm.value.student;
    viewModel.classname = this.studentForm.value.class;
    viewModel.teacherName = this.studentForm.value.teacher;

    let checkinput = this.studentForm.invalid
    
    if(checkinput){
      this.isInvaild=true;
    }
    if (!this.edit && !checkinput) {      
      this.editdata
        .submitData(viewModel)
        .then((res) => console.log(res))
        .finally(() => {
          this.onCancel();
          
        });
    } else if (this.edit&& !checkinput) {      
      this.editdata.updateData(viewModel).then((res) => {        
        this.onCancel();
      });
    }
  }
  onCancel() {
    this.router.navigate(['/student']);
  }

  
}
