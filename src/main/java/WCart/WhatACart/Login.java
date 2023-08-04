package WCart.WhatACart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends Base {

	@FindBy(id="loginform-username") private WebElement  username;
	@FindBy(id="loginform-password") private WebElement  password;
	@FindBy(id="loginform-rememberme") private WebElement  rememberme;
	@FindBy(id="savebutton") private WebElement  login;
	
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
//	public void enterValidCredentials(String username2, String password2) throws InterruptedException {
//		username.sendKeys("spaulkar");
//		Thread.sleep(2000);
//		password.sendKeys("Research$520");
//		Thread.sleep(2000);
//		rememberme.click();
//		login.click();
//		Thread.sleep(2000);
//	}
	
	public void enterUsername(String username2) {
		username.sendKeys(username2);
	}
	
	public void enterPassword(String password2) {
		password.sendKeys(password2);
	}
	
	public void clickLogin() {
		login.click();
	}
}
