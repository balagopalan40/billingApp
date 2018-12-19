import {
    Injectable,
    OnInit
} from '@angular/core';
import {
    CanActivate,
    ActivatedRouteSnapshot,
    RouterStateSnapshot,
    Router
} from '@angular/router';
import {
    Observable
} from 'rxjs/Observable';

import 'rxjs/add/observable/of';

import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private authService: AuthService, private router: Router) {}

  canActivate( next: ActivatedRouteSnapshot,state: RouterStateSnapshot): Observable < boolean > {
  		console.log("Auth gurd log"+this.authService.isLoggedin.value);
  		if(this.authService.isLoggedin.value){

        return Observable.of(true);

  		}
      else{
  		  return Observable.of(false);
      }
        /*return this.authService.loggin.take(1).map((isLoggedIn: boolean) => {
                if (isLoggedIn) {
                    console.log('login' + isLoggedIn);
                    return true;
                }

                this.router.navigate(['/login']);
                return false;
            });*/
    }
}
