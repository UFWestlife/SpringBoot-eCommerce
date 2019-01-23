import { browser, by, element } from 'protractor';

export class AppPage {
  navigateTo() {
    return browser.get('/');
  }

  getHomePageTitle() {
    return element.all(by.css('app-root h5')).first().getText();
  }
}
