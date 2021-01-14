package com.cucumber.TestNG.stepDef;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.cucumber.TestNG.helper.UtilClass;
import com.cucumber.TestNG.helper.WebDriverManager;
import com.cucumber.TestNG.pages.HomePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageSteps extends UtilClass {
	public WebDriver driver;
	public static Logger log = Logger.getLogger(HomePageSteps.class);

	public HomePageSteps() {
		try {
			driver = WebDriverManager.getInstance().getWebDriver();
		} catch (Exception e) {
			log.info(e.toString());
		}

	}

	@Then("^User should validate gmail HomePage$")
	public void user_should_validate_gmail_HomePage() {
		HomePage hp = new HomePage(driver);
		hp.verifyHomePage();
	}

	@When("^User clicks on compose button on HomePage$")
	public void user_clicks_on_compose_button_on_HomePage() {
		HomePage hp = new HomePage(driver);
		hp.clickComposeBtn();
	}

	@Then("^User validates New Message Window on HomePage$")
	public void user_validates_New_Message_Window_on_HomePage() {
		HomePage hp = new HomePage(driver);
		hp.verifyNewMessageWindow();
	}

	@When("^User enters \"([^\"]*)\" To email on HomePage$")
	public void user_enters_To_email_on_HomePage(String email) throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.enterToEmail(email);
	}

	@When("^User enters \"([^\"]*)\" CC email on HomePage$")
	public void user_enters_CC_email_on_HomePage(String email) throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.enterCcEmail(email);
	}

	@When("^User enters \"([^\"]*)\" BCC email on HomePage$")
	public void user_enters_BCC_email_on_HomePage(String email) throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.enterBccEmail(email);
	}

	@When("^User enters Subject as \"([^\"]*)\" on HomePage$")
	public void user_enters_Subject_as_on_HomePage(String subject) throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.enterSubject(subject);
	}

	@Then("^User enters body as \"([^\"]*)\" on HomePage$")
	public void user_enters_body_as_on_HomePage(String body) throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.enterBody(body);
	}

	@Then("^User adds attachment on HomePage$")
	public void user_adds_attachment_on_HomePage() throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.addAttachment();
	}

	@Then("^User clicks on Send button on HomePage$")
	public void user_clicks_on_send_button() {
		HomePage hp = new HomePage(driver);
		hp.clickSendBtn();
	}
	@Then("^User velidates error for To email on HomePage$")
	public void user_velidates_email_error() {
		HomePage hp = new HomePage(driver);
		hp.velidateEmailError();
	}
	
	@Then("^User velidates error for empty Subject on HomePage$")
	public void user_velidate_subject_error() {
		HomePage hp = new HomePage(driver);
		hp.velidateSubectError();
	}
}
