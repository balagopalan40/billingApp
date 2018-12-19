import {
    Injectable,EventEmitter
} from '@angular/core';
import { CookieService } from 'ngx-cookie-service';


@Injectable() export class CookieProviderService {

    manager : boolean;
    hr: boolean;
    routename : EventEmitter<any> = new EventEmitter<any>();
    constructor(private _cookieService: CookieService) {

    }
    putLoginData(sessionId, role) {
       // role ='hr';
        console.log('the cookie service ');
        this._cookieService.set('B_vat', sessionId);
        console.log('cookie data ...' + role);
        if(role=="emp"){
            this.manager=(false);
            this.hr=(false);
        }else if(role=="r1"||role=="r2"){
            this.manager=(true);
            this.hr=(false);
        }else if(role=="HRA" || role=="HRM"){
            this.manager=(false);
            this.hr=(true);
        }else{

        }
        this._cookieService.set('role', role);
    }

    getSessionId() {
        return this._cookieService.get('B_vat');
    }
    getSessionRole() {
        return this._cookieService.get('role');
    }
    getCookieData(){
        let data = {"sessionId":this._cookieService.get('B_vat'),
                    "role":this._cookieService.get('role')};
            console.log("JSON::"+JSON.stringify(data));
        return data;
    }

    setRole(role){

        if(role=="emp"){
            this.manager=(false);
            this.hr=(false);
        }else if(role=="r1"||role=="r2"){
            this.manager=(true);
            this.hr=(false);
        }else if(role=="HRA" || role=="HRM"){
            this.manager=(false);
            this.hr=(true);
        }
        console.log("Cookie role is......"+ role);
    }

    clearSession() {
        this._cookieService.deleteAll();
       /* this._cookieService.removeAll();*/
    }
    toJsonObj(str) {
        try {
            JSON.parse(str);
        } catch (e) {
            return false;
        }
        return JSON.parse(str);
    }
}
