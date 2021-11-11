import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { View } from '../viewModel/view';
import { lastValueFrom } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class GetdataService {
  constructor(private http: HttpClient) {}
  getAll() {
    return lastValueFrom(
      this.http.get<Array<View>>(`${environment.api_url}/get-all`)
    );
  }
  getOne(id: string) {
    return lastValueFrom(
      this.http.get<View>(`${environment.api_url}/get-one/${id}`)
    );
  }
  submitData(data: View) {
    return lastValueFrom(
      this.http.post(`${environment.api_url}/post-student`, data)
    );
  }
  updateData(updateData: View) {
    return lastValueFrom(
      this.http.put(`${environment.api_url}/put-student`, updateData)
    );
  }
  deleteData(id: String) {
    return lastValueFrom(
      this.http.delete(`${environment.api_url}/delete-student/${id}`)
    );
  }
}
