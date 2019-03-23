import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from './../auth/auth.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

 /*form: FormGroup;                    
    private formSubmitAttempt: boolean; 
    error : any;
    constructor(public router: Router,private cookie: CookieProviderService,private authService: AuthService,private fb: FormBuilder) { 
        this.cookie.clearSession();

        this.authService.errorLogin.subscribe(res=>{
            console.log("inside login component ts "+res);
            this.error = res;

        })
    }
*/
	constructor(public router: Router, private authService: AuthService){

	}

    ngOnInit() {
 //       this.error="";
    	console.log("login page called");
        /*this.form = this.fb.group({ 
            emailid: ['', Validators.required],
            password: ['', Validators.required]
        });*/
    }
/*
    isFieldInvalid(field: string) { 
        return ((!this.form.get(field).valid && this.form.get(field).touched) || (this.form.get(field).untouched && this.formSubmitAttempt));
    }

    onLoginClick(role){
        
    	console.log("Button was clicked.."+role);
    }*/

    onSubmit() {
        console.log("login clicked submit");
        this.authService.getLogin();
        this.router.navigate(['dashboard']);
       /* if (this.form.status == "VALID") {
            //this.authService.login("manager");
            this.authService.authUser(this.form.value); 
            this.error="";
        } else {        
            this.error = "Please enter the Intranet Username and Password !!";
            console.log("Please enter the intranet username and password !!");
        }
        this.formSubmitAttempt = true; */            
    }


}
