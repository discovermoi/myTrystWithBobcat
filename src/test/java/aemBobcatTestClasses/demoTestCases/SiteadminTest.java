package aemBobcatTestClasses.demoTestCases;

import aemBobcat.GuiceModule;
import com.cognifide.qa.bb.aem.AemLogin;
import com.cognifide.qa.bb.aem.touch.siteadmin.aem62.SiteadminPage;
import com.cognifide.qa.bb.aem.ui.wcm.SiteAdminPage;
import com.cognifide.qa.bb.aem.ui.wcm.constants.ActivationStatus;
import com.cognifide.qa.bb.aem.ui.wcm.elements.SiteAdminGridRow;
import com.cognifide.qa.bb.junit.Modules;
import com.cognifide.qa.bb.junit.TestRunner;
import com.cognifide.qa.bb.logging.ReportEntryLogger;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.Assert.assertThat;

//...

@RunWith(TestRunner.class)
@Modules(GuiceModule.class)
public class SiteadminTest{
    private static final String CREATE_PAGE_TEMPLATE = "Media Article";

    private static final String BASE_PARENT_URL = "/content/geometrixx-media/en/entertainment";

    private static final String CREATED_PAGE_TITLE = "What is bobcat";


    @Inject
    private AemLogin aemLogin;

    @Inject
    private SiteAdminPage siteAdminPage;

    @Before
    public void openSiteadminPage() {
        aemLogin.authorLogin();
        siteAdminPage.open(BASE_PARENT_URL);
    }
    @Test
    public void shouldWaitForPageCount() {
        siteAdminPage.open("/content/flinders/en");
    }
}