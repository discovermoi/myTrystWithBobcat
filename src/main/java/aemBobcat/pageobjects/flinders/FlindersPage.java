package aemBobcat.pageobjects.flinders;

import com.cognifide.qa.bb.aem.page.AuthorPage;
import com.cognifide.qa.bb.qualifier.Frame;
import com.cognifide.qa.bb.qualifier.PageObject;
import org.openqa.selenium.support.FindBy;


/**
 * This created a page in Flinders Page to Test. Works with @PageObject Annotation.
 * TODO:: Generating Author pages with entries for the pages to be created in a YAML file is work in progress as it is not working as per instructions of the framework..
 */
@PageObject
@Frame("$cq")
public class FlindersPage extends AuthorPage {

	/**
	 * Replace value of this constant with relative address of your page.
	 */
	private static final String URL = "/editor.html/content/flinders/en/about.html";

	/**
	 * Replace value of this constant with the title of your page.
	 */
	private static final String PAGE_TITLE = "Feedback";

	/**
	 * Create a field for each page component that you want to test. Lookup each component with a FindBy.
	 */
	@FindBy(className = "cq-element-par_470001")
	private AccordionComponent startFormComponent;

	/**
	 * @return Instance of the component embedded in the page.
	 */
	public AccordionComponent getStartFormComponent() {
		return startFormComponent;
	}

	@Override
	public String getContentPath() {
		return URL;
	}

	@Override
	public String getPageTitle() {
		return PAGE_TITLE;
	}
}
