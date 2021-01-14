package com.cucumber.TestNG.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.cucumber.TestNG.helper.UtilClass;

public class HomePage extends UtilClass {
	private static Logger log = Logger.getLogger(HomePage.class);
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//div[text()='Compose']")
	private WebElement composeButton;
	
	@FindBy(xpath = "//textarea[@name='to']")
	private WebElement toemail;
	
	@FindBy(xpath = "//textarea[@name='cc']")
	private WebElement ccemail;
	
	@FindBy(xpath = "//textarea[@name='bcc']")
	private WebElement bccemail;
	
	@FindBy(xpath = "//span[text()='Cc']")
	private WebElement ccemailbtn;
	
	@FindBy(xpath = "//span[text()='Bcc']")
	private WebElement bccemailbtn;
	
	@FindBy(xpath = "//input[@name='subjectbox']")
	private WebElement subjectTextArea;
	
	@FindBy(xpath = "//div[@aria-label='Message Body']")
	private WebElement emailBody;
	
	@FindBy(xpath = "//input[@name='Filedata']")
	private WebElement attachment;
	
	@FindBy(xpath = "//div[text()='Send']")
	private WebElement sendBtn;
	
	@FindBy(xpath = "//div[contains(text(),'The address')]")
	private WebElement emailErrorText;
	 
	public HomePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 60);
		PageFactory.initElements(driver, this);
	}

	public void verifyHomePage() {
		wait.until(ExpectedConditions.elementToBeClickable(composeButton));
		assertTrue(isElementPresent(driver, composeButton), "Problem in loading HomePage");
		screenShot(driver);
		log.info("HomePage verfied successfully");
	}

	public void clickComposeBtn() {
		clickElement(driver, composeButton);
		screenShot(driver);
		log.info("Clicked on Compose button");	
	}

	public void verifyNewMessageWindow() {
		waitForLoad(driver);
		assertTrue(isElementPresent(driver, toemail), "New Message window not visible");
		screenShot(driver);
		log.info("HomePage verfied successfully");
	}

	public void enterToEmail(String email) {
		setText(driver,toemail,email);
		screenShot(driver);
		log.info("Email entered for To is : "+email);
	}

	public void enterCcEmail(String email) {
		clickElement(driver,ccemailbtn);
		setText(driver,ccemail,email);
		screenShot(driver);
		log.info("Email entered for CC is : "+email);
	}

	public void enterSubject(String subject) {
		setText(driver,subjectTextArea,subject);
		screenShot(driver);
		log.info("Subject entered as : "+subject);
	}

	public void enterBody(String body) {
		setText(driver,emailBody,body);
		screenShot(driver);
		log.info("Email Body entered as : "+body);
	}

	public void addAttachment() {
		attachment.sendKeys("E:\\workspace\\Testing\\attachment.txt");
		screenShot(driver);
		log.info("Attachment added successfully");
	}

	public void clickSendBtn() {
		clickElement(driver, sendBtn);
		//screenShot(driver);
		log.info("Clicked on Send button");
	}

	public void enterBccEmail(String email) {
		clickElement(driver,bccemailbtn);
		setText(driver,bccemail,email);
		screenShot(driver);
		log.info("Email entered for BCC is : "+email);
	}

	public void velidateEmailError() {
		assertTrue(isElementPresent(driver, composeButton), "No Error Found");
		screenShot(driver);
		log.info("Email address validation success");
	}

	public void velidateSubectError() {
		String errorText=driver.switchTo().alert().getText();
		assertEquals(errorText, "Send this message without a subject or text in the body?");
		driver.switchTo().alert().accept();
		screenShot(driver);
		log.info("Subject validation success");
	}
}
