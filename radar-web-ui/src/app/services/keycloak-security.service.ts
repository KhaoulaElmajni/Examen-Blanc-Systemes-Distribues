import { Injectable } from '@angular/core';
import {KeycloakInstance} from "keycloak-js";
//import {any} from "../../../node_modules/codelyzer/util/function";

declare  var Keycloak: any;
@Injectable({
  providedIn: 'root'
})
export class KeycloakSecurityService {

  public  kc : KeycloakInstance | undefined;
  constructor() { }

  async init() {
    console.log("Security Service Init...");
    this.kc = Keycloak({
      url: 'http://localhost:8080',
      realm: 'radar-realm',
      clientId: 'radar-app'
    });

    // @ts-ignore
    await this.kc.init({
      onLoad: 'login-required',
      //promiseType: 'native'
      //onLoad: 'check-sso'
    });

    console.log(this.kc?.token);
  }
}
