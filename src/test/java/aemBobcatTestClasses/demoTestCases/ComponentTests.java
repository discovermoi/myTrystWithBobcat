package aemBobcatTestClasses.demoTestCases;

import aemBobcat.GuiceModule;
import com.cognifide.qa.bb.aem.AemLogin;
import com.cognifide.qa.bb.aem.touch.data.pages.Pages;
import com.cognifide.qa.bb.aem.touch.pageobjects.pages.AuthorPage;
import com.cognifide.qa.bb.aem.touch.pageobjects.pages.AuthorPageFactory;
import com.cognifide.qa.bb.junit.Modules;
import com.cognifide.qa.bb.junit.TestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import javax.inject.Inject;

@RunWith(TestRunner.class)
@Modules(GuiceModule.class)
public class ComponentTests {
    @Inject
    private AemLogin aemLogin;

    @Inject
    private Pages pages;

    @Inject
    private AuthorPageFactory authorPageFactory;

    private AuthorPage page;

    @Before
    public void before() {
        aemLogin.authorLogin();
        page = authorPageFactory.create(pages.getPath("Image-Update"));
        page.open();
    }

    @Test
    public void testAuthorPage() {
        page.isLoaded();
    }

}
