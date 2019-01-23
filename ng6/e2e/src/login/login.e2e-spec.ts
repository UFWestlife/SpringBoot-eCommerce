import { LoginPage } from './login.po';
import {browser, protractor} from 'protractor';
import {environment} from '../../../src/environments/environment';

describe('login', () => {
  let page: LoginPage;

  beforeEach(() => {
    page = new LoginPage();
    page.navigateTo();
  });

  it('should display login title', () => {
    expect(page.getLoginPageTitle()).toEqual('Login');
  });

  it('should login user with correct credentials and redirect to products page', () => {
    page.login();
    browser.wait(() => {
      return browser.getCurrentUrl()
        .then(currentUrl => {
          expect(currentUrl).toEqual(`${browser.baseUrl}/products`);
          return true;
        });
    });
  });

  it('should not login user with wrong credentials', () => {
    page.loginWithWrongCredentials();
    const until = protractor.ExpectedConditions;
    browser.wait(until.presenceOf(page.getLoginFailureErrorElem()), 5000, 'Login request takes too long to finsih.');
    expect(page.getLoginFailureErrorElem().getText()).toContain('Your username and password does not match records.');
  });
});
