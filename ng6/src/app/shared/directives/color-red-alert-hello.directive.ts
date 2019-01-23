import {Directive, HostBinding, HostListener} from '@angular/core';

@Directive({
  selector: '[appColorRedAlertHello]'
})
export class ColorRedAlertHelloDirective {

  @HostBinding('style.color')
  color = 'red';

  @HostListener('click', ['$event.target'])
  onClick(elem: HTMLElement) {
    alert('hello, ' + elem.innerText);
  }

  constructor() { }

}
