import { browser, by, element } from 'protractor';

export class LoginPage {
  navigateTo() {
    return browser.get('/users/login');
  }

  getLoginPageTitle() {
    return element(by.css('.mat-card-title')).getText();
  }

  login() {
    element(by.css('[name="username"]')).sendKeys('admin');
    element(by.css('[name="password"]')).sendKeys('adminpass');
    element(by.css('button[type="submit"]')).click();
  }

  loginWithWrongCredentials() {
    element(by.css('[name="username"]')).sendKeys('admin');
    element(by.css('[name="password"]')).sendKeys('adminpass1');
    element(by.css('button[type="submit"]')).click();
  }

  getLoginFailureErrorElem() {
    return element(by.css('mat-error'));
  }
}
