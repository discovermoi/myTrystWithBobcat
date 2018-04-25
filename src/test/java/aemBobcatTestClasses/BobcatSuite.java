package aemBobcatTestClasses;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.cognifide.qa.bb.junit.Modules;
import com.cognifide.qa.bb.junit.concurrent.ConcurrentSuite;

import aemBobcat.GuiceModule;
import aemBobcatTestClasses.feedback.*;
import aemBobcatTestClasses.login.AuthorizationTest;
import aemBobcatTestClasses.summer.ImageComponentTest;
import aemBobcatTestClasses.summer.SectionHeaderComponentTest;

@Modules(GuiceModule.class)
@RunWith(ConcurrentSuite.class)
@Suite.SuiteClasses({ AuthorizationTest.class, ImageComponentTest.class, SectionHeaderComponentTest.class,
		StartFormComponentTest.class })
public class BobcatSuite {

}
