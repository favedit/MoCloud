package org.mo.content.service.mobile;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.mo.content.service.mobile.account.TestFLoginService;

@RunWith(Suite.class)
@SuiteClasses({TestFLoginService.class, TestFVersionService.class})
public class FeatureTestSuite
{

}
