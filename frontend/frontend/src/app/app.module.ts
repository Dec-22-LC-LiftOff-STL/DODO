import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterOutlet } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { MainLayoutComponent } from './pages/main-layout/main-layout.component';
import { BuildProfileComponent } from './pages/build-profile/build-profile.component';
import { FormsModule } from '@angular/forms';
import { SignUpComponent } from './pages/sign-up/sign-up.component';
import { WelcomePageComponent } from './pages/welcome-page/welcome-page.component';
import { HttpClientModule } from '@angular/common/http';
import { UserProfileComponent } from './pages/user-profile/user-profile.component';
import { GenerateDodoComponent } from './pages/generate-dodo/generate-dodo.component';
import { ItinerariesComponent } from './pages/itineraries/itineraries.component';
import { SubmitpoiComponent } from './pages/submitpoi/submitpoi.component';
import { ItineraryCardComponent } from './itinerary-card/itinerary-card.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    MainLayoutComponent,
    SignUpComponent,
    BuildProfileComponent,
    WelcomePageComponent,
    UserProfileComponent,
    GenerateDodoComponent,
    ItinerariesComponent,
    SubmitpoiComponent,
    ItineraryCardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
