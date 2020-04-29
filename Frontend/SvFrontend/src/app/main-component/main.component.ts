import {ChangeDetectionStrategy, ChangeDetectorRef, Component} from '@angular/core';
import {MainService} from "./service/main.service";

@Component({
  selector: 'app-main-component',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class MainComponent {

  constructor(private service: MainService,
              private cdr: ChangeDetectorRef) {
  }

  public fieldsMap: Map<string, string>;
  public message: string = '08002220010000800000900000070610203400000180100010001123456789012345';

  public parseClick(event: Event): void {
    this.fieldsMap = null;
    this.cdr.detectChanges();
    this.service.downloadFields(this.message).subscribe(map => {
      this.fieldsMap = map;
      this.cdr.detectChanges();
    })
  }

}
