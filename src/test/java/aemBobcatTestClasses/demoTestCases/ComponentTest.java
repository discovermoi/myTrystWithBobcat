package aemBobcatTestClasses.demoTestCases;

import aemBobcat.GuiceModule;
import com.cognifide.qa.bb.aem.AemLogin;
import com.cognifide.qa.bb.aem.touch.data.pages.Pages;
import com.cognifide.qa.bb.aem.touch.pageobjects.pages.AuthorPage;
import com.cognifide.qa.bb.aem.touch.pageobjects.pages.AuthorPageFactory;
import com.cognifide.qa.bb.junit.Modules;
import com.cognifide.qa.bb.junit.TestRunner;
import com.google.inject.Inject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(TestRunner.class)
@Modules(GuiceModule.class)
public class ComponentTest {
    @Inject
    private AemLogin aemLogin;

    @Inject
    private AuthorPageFactory authorPageFactory;

    @Inject
    private Pages pages;

    private AuthorPage page;

    @Before
    public void createAuthorPage() {
        aemLogin.authorLogin();
        page = authorPageFactory.create(pages.getPath("Test-Component"));
        page.open();
    }

    @Test
    public void testAuthorPage() {
        // Empty
}   }
