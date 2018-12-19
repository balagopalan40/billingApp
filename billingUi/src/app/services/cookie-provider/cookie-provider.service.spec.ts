import { TestBed } from '@angular/core/testing';

import { CookieProviderService } from './cookie-provider.service';

describe('CookieProviderService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CookieProviderService = TestBed.get(CookieProviderService);
    expect(service).toBeTruthy();
  });
});
