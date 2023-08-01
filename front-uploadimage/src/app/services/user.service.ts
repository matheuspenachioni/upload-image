import { Injectable } from '@angular/core';
import { User } from '../models/user';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private apiUrl = 'http://localhost:8089/user';

  constructor(private http: HttpClient) { }

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.apiUrl);
  }

  createUser(user: User, file: File): Observable<User> {
    const formData: FormData = new FormData();

    formData.append('file', file);
    formData.append('username', user.username);
    formData.append('email', user.email);

    return this.http.post<User>(this.apiUrl, formData);
  }
}
