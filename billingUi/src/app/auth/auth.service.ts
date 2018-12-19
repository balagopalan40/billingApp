import { Injectable, EventEmitter } from '@angular/core';
import { CookieProviderService } from './../services/cookie-provider/cookie-provider.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Headers, Http, RequestOptions, Response } from "@angular/http";
import { environment } from './../../environments/environment';
import { Observable } from "rxjs";

import 'rxjs/add/operator/map'

import {
  Subscription,
  BehaviorSubject

} from 'rxjs';



@Injectable()
export class AuthService {

	headers: any;
	public cookieData:any;
	public isLoggedin; //:Observable<any>
	returnUrl: string;
	private login_api = environment.API_URL + '/login_verification.php';
	private login_authentication_api = environment.API_URL + '/login_authentication.php';
	errorLogin : EventEmitter<any> = new EventEmitter<any>();


	get loggin() {
    	return this.isLoggedin.asObservable();


  	}
	constructor(public router: Router,private cookie: CookieProviderService,private route: ActivatedRoute,private http: Http) {
		console.log("constructor of auth service");
		 const data = this.cookie.getSessionId();
		this.cookieData = this.cookie.getCookieData();
		console.log("cookie::"+data);

		if(this.cookieData.sessionId != undefined && this.cookieData.role != undefined &&
			this.cookieData.role !=="" && this.cookieData.sessionId !== ""){
			this.isLoggedin = new BehaviorSubject<boolean>(true);
			const postParams = {
	            sessionid: this.cookieData.sessionId,
	        };
			this.authentication(postParams);
			//



		}
		else{
			console.log("coookie not found");
			this.isLoggedin = new BehaviorSubject<boolean>(false);
			this.cookie.clearSession();
			console.log("Session is expired");
			this.router.navigate(['/login']);
		}
		//this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/home';
	}



  private jwt() {
    // create authorization header with jwt token
    this.headers = new Headers({ 'Content-Type': 'application/x-www-form-urlencoded'});
    return new RequestOptions({ headers: this.headers });
  }
 authentication(data){
		this.http.post(this.login_authentication_api, data, this.jwt())
        .subscribe(
	        res => {
	        	let resData = res.json();
	        	console.log("authentication successfully"+ JSON.stringify(resData));
	            if(resData.code == 1){
						console.log("hello::"+this.cookieData.sessionId+"...let see "+this.cookieData.role);
						this.cookie.setRole(this.cookieData.role);
						console.log("Session is There in auth service");
						//this.isLoggedin = new BehaviorSubject<boolean>(true);
						this.router.navigate(['/dashboard']);
	            }else{
	            	console.log("session expire");
	            	 this.isLoggedin.next(false);
					this.cookie.clearSession();
					console.log("Session is expired");
					this.router.navigate(['/login']);
	            }
	        },
	        err => {
	            console.log('ERROR!: ', err);
	            this.isLoggedin.next(false);
	            this.router.navigate(['/login']);

	        }
        );
	}
	authUser(data){
		this.http.post(this.login_api, data, this.jwt())
        .subscribe(
	        res => {
	        	console.log(res);
	        	let resData = res.json();

	        	console.log("logged successfully"+ resData.code);
	            if(resData.code == 1){
	            	this.isLoggedin.next(true);
	            	console.log("putLoginData:::::::::::::::"+resData.sessionid);
	            	this.cookie.putLoginData(resData.sessionid,resData.role);
	            	this.router.navigate(['/dashboard']);
	            	/*this.cookieData = this.cookie.getCookieData();
	            	if(this.cookieData.sessionId != undefined && this.cookieData.role != undefined &&
						this.cookieData.role !=="" && this.cookieData.sessionId !== ""){
						this.authentication(this.cookieData.sessionId);
					}
					else{
						console.log("coookie not found");
						this.isLoggedin = new BehaviorSubject<boolean>(false);
						this.cookie.clearSession();
						console.log("Session is expired");
						this.router.navigate(['/login']);
					}*/
	            }else{

	            	if(resData.code == -1){

	            	this.errorLogin.emit(resData.Status);
	            	}

	            }
	        },
	        err => {
	            console.log('ERROR!: ', err);
	            this.isLoggedin.next(true);
	            this.router.navigate(['/login']);

	        }
        );
	}

	checkSession(){
		return this.isLoggedin;
	}

	login(role){
		this.cookie.putLoginData("X23ADSFSS",role);
    	this.isLoggedin.next(true);
    	this.router.navigate(['dashboard']);
    	//this.router.navigateByUrl(this.returnUrl);
	}

	logout(){
        this.cookie.clearSession();
        this.isLoggedin.next(false);
		console.log("logout::"+this.isLoggedin);
        this.router.navigate(['/login']);
    }

    loadDetails(){


    	var data = "";
    	return this.http.post(this.login_api, data, this.jwt()).map((response: Response) => response.json());


    }

}
