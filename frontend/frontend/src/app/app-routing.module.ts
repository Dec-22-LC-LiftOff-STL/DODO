import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginPageComponent } from '../app/login-page/login-page.component';
import { MainLayoutComponent } from './pages/main-layout/main-layout.component';
import { UserProfileComponent } from '../app/user-profile/user-profile.component';

const routes: Routes = [
  { path: '', component: MainLayoutComponent, children: [
    { path: '', component: LoginPageComponent },
    { path: 'profile', component: UserProfileComponent }
  ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
