import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient, HttpParams} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class MainService {

  constructor(private httpClient: HttpClient) {
  }

  public downloadFields(message: string): Observable<any> {

    let httpParams = new HttpParams()
      .set('message', message);

    return this.httpClient.get("http://localhost:8080/parse-message", {params: httpParams});
  }

}
