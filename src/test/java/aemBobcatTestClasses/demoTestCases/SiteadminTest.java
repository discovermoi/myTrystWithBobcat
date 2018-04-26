package aemBobcatTestClasses.demoTestCases;

import aemBobcat.GuiceModule;
import com.cognifide.qa.bb.aem.AemLogin;
import com.cognifide.qa.bb.aem.touch.siteadmin.aem62.SiteadminPage;
import com.cognifide.qa.bb.aem.ui.wcm.SiteAdminPage;
import com.cognifide.qa.bb.aem.ui.wcm.constants.ActivationStatus;
import com.cognifide.qa.bb.aem.ui.wcm.constants.PageStatus;
import com.cognifide.qa.bb.aem.ui.wcm.elements.SiteAdminGridRow;
import com.cognifide.qa.bb.junit.Modules;
import com.cognifide.qa.bb.junit.TestRunner;
import com.cognifide.qa.bb.logging.ReportEntryLogger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

//...

@RunWith(TestRunner.class)
@Modules(GuiceModule.class)
public class SiteadminTest{
    private static final String CREATE_PAGE_TEMPLATE = "Flinders Course Page";

    private static final String BASE_PARENT_URL = "/content/flinders/en/about";

    private static final String CREATED_PAGE_TITLE = "Sample Flinders Test Page created from bobcat";


    @Inject
    private AemLogin aemLogin;

    @Inject
    private SiteAdminPage siteAdminPage;

    @Inject
    private ReportEntryLogger reportEntryLogger;

    @Before
    public void openSiteadminPage() {
        aemLogin.authorLogin();
        siteAdminPage.open(BASE_PARENT_URL);
    }

    @Test
    public void shouldActivateAndDeactivatePageProperly() {
        SiteAdminGridRow createdPageGridRow;
        createPage();

        siteAdminPage.activatePage(CREATED_PAGE_TITLE);
        createdPageGridRow = siteAdminPage.getGrid().selectPageByTitle(CREATED_PAGE_TITLE);
        assertThat(createdPageGridRow.getActivationStatus(), is(ActivationStatus.ACTIVATED));

        siteAdminPage.deactivatePage(CREATED_PAGE_TITLE);
        createdPageGridRow = siteAdminPage.getGrid().selectPageByTitle(CREATED_PAGE_TITLE);
        assertThat(createdPageGridRow.getActivationStatus(), is(ActivationStatus.DEACTIVATED));
    }

    @Test
    public void shouldActivatePageLater() {
        createPage();
        siteAdminPage.activatePageLater(CREATED_PAGE_TITLE, "25/04/18", "11:00 AM");
        SiteAdminGridRow createdPageGridRow = siteAdminPage.getGrid().selectPageByTitle(CREATED_PAGE_TITLE);
        assertThat(createdPageGridRow.getPageStatusToolTip(),
                containsString(PageStatus.SCHEDULED_ACTIVATION.getStatusCss()));
    }

    @Test
    public void shouldDeactivatePageLater() {
        createPage();
        siteAdminPage.deactivatePageLater(CREATED_PAGE_TITLE, "25/04/18", "11:00 AM");
        SiteAdminGridRow createdPageGridRow = siteAdminPage.getGrid().selectPageByTitle(CREATED_PAGE_TITLE);
        assertThat(createdPageGridRow.getPageStatusToolTip(),
                containsString(PageStatus.SCHEDULED_DEACTIVATION.getStatusCss()));
    }

    private void removePage(String parentPath, String pageTitle) {
        siteAdminPage.open(parentPath);
        if (siteAdminPage.isPagePresent(pageTitle)) {
            siteAdminPage.deletePage(pageTitle);
        }
    }

    private void createPage() {
        if (!siteAdminPage.isPagePresent(CREATED_PAGE_TITLE)) {
            siteAdminPage.createNewPage(CREATED_PAGE_TITLE, CREATE_PAGE_TEMPLATE);
        }
        assertTrue(siteAdminPage.isPagePresent(CREATED_PAGE_TITLE));
        assertTrue(siteAdminPage.isTemplateOnTheList(CREATED_PAGE_TITLE, CREATE_PAGE_TEMPLATE));
        reportEntryLogger.info("test page created");
    }

    @After
    public void cleanUp() {
        removePage(BASE_PARENT_URL, CREATED_PAGE_TITLE);
    }
}