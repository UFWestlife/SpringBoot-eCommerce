import { CustomStyleModule } from './custom-style.module';

describe('CustomStyleModule', () => {
  let customStyleModule: CustomStyleModule;

  beforeEach(() => {
    customStyleModule = new CustomStyleModule();
  });

  it('should create an instance', () => {
    expect(customStyleModule).toBeTruthy();
  });
});
