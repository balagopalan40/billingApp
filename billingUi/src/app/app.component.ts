import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthService } from './auth/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
	
  title = 'billingUi';
  isLoggedIn : Boolean = false;
  
 constructor(private router: Router, private authService: AuthService) {

 	this.authService.loggedIn.subscribe(res => {
            console.log(res);
            this.isLoggedIn = res;
        });
 }

  ngOnInit() {
        console.log("ngoninit called");
        this.router.navigate(['login']);
    }

  createNewPurchaseOrder(){
  	console.log("create new purchase order");
        this.router.navigate(['purchase-order']);
  }  
}
