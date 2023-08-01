import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-user-save',
  templateUrl: './user-save.component.html',
  styleUrls: ['./user-save.component.css']
})
export class UserSaveComponent implements OnInit {

  user: User = { 
    id: '', username: '', email: '', photo: null 
  }

  selectedFile: File;
  imagePreview: any;

  constructor(private userService: UserService, 
    private router: Router) { }

  ngOnInit() {
  }

  onFileChanged(event) {
    this.selectedFile = event.target.files[0];

    // Image preview
    const reader = new FileReader();
    reader.onload = () => {
      this.imagePreview = reader.result;
    };
    reader.readAsDataURL(this.selectedFile);
  }

  onSubmit() {
    this.userService.createUser(this.user, this.selectedFile).subscribe(() => this.user = { id: null, username: '', email: '', photo: '' });
    this.router.navigate(['user']);
  }
}