import { Component, OnInit } from '@angular/core';
import { NgForm, FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { TokenStorageService } from '../shared/services/token-storage.service';
import { UserService } from '../shared/services/user.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss']
})
export class LoginPageComponent implements OnInit {

  form: any ={
    username: null,
    password: null
  };
  isLoggedIn = false;
  isSuccessful = false;
  roles: string[] = [];
  showErrorMessage = false;
  isLoginFailed = false;

  constructor(private _route: Router, private _service: UserService, private tokenStorage: TokenStorageService) { }

  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getUser().roles;
    }
  }

  signIn(): void  {
    //authenticate username and hashkey 
    const { username, password } = this.form;
    // console.log(this.form);
    this._service.getUserByUsername(username, password).subscribe(
      data=>{
        if (data) {
          // console.log(data.token)
          if (data.token) {
            this.tokenStorage.saveToken(data.accessToken);
            this.tokenStorage.saveUser(data);
            this.isLoggedIn = true;
            this.roles = this.tokenStorage.getUser().roles;

            console.log("Successfully logged in");
            this._route.navigateByUrl('/mynest');
          } else {
            console.log("No Token");
          }
        }
      },
      (error) => {
        this.showErrorMessage = true;
      }
    )

  }

  // unableToSignIn(): void {
  //   const {username} = this.form;
  //   this._service.getUsername(username).subscribe(
  //     data =>{
  //       if (this.isLoggedIn == false) {
  //         this._route.navigateByUrl('/signup');
  //       }

  //     }
  //   )
  // }
}
