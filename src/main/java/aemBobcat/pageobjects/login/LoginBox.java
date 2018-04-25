package aemBobcat.pageobjects.login;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cognifide.qa.bb.qualifier.PageObject;

/**
 * This component represents login box on the authorization page.
 * <p/>
 * You can leave it as it is in your test project.
 */
@PageObject
public class LoginBox {
	/**
	 * Input field for user name.
	 */
	@FindBy(id = "username")
	private WebElement usernameField;

	/**
	 * Input field for password.
	 */
	@FindBy(id = "password")
	private WebElement passwordField;

	/**
	 * Login button.
	 */
	@FindBy(css = "button[type=submit]")
	private WebElement loginButton;

	/**
	 * This is the element that appears if login operation failed. It contains validation message.
	 */
	@FindBy(id = "error")
	private WebElement error;

	/**
	 * Types the login into the login field.
	 */
	public LoginBox enterLogin(String login) {
		usernameField.sendKeys(login);
		return this;
	}

	/**
	 * Types the password into the password field.
	 */
	public LoginBox enterPassword(String password) {
		passwordField.sendKeys(password);
		return this;
	}

	/**
	 * Clicks the login button.
	 */
	public LoginBox clickSignIn() {
		loginButton.click();
		return this;
	}

	/**
	 * @return True if the error message is visible. False otherwise.
	 */
	public boolean isErrorMessageVisible() {
		try {
			return error.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
