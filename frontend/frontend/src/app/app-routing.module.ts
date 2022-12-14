import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginPageComponent} from '../app/login-page/login-page.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { MainLayoutComponent } from './pages/main-layout/main-layout.component';
import { BuildProfileComponent } from './pages/build-profile/build-profile.component';
import { SignUpComponent } from './pages/sign-up/sign-up.component';
import { WelcomePageComponent } from './pages/welcome-page/welcome-page.component';
import { UserProfileComponent } from './pages/user-profile/user-profile.component';

const routes: Routes = [
  { path: '', component: MainLayoutComponent, children: [
    { path: '', component: WelcomePageComponent },
    { path: 'login', component: LoginPageComponent }, //add 'login' path after building the welcome page
    { path: 'buildnest', component: BuildProfileComponent },
    { path: 'home', component: HomePageComponent },
    { path: 'signup', component: SignUpComponent },
    { path: 'mynest', component: UserProfileComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
