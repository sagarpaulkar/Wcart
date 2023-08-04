package WCart.WhatACart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Wcart extends Base{

	@FindBy(linkText="Desktops") private WebElement  desktop;
	@FindBy(xpath="//div[@class='caption']/h4") private List<WebElement>desktops;
	@FindBy(id="sortBy") private WebElement sort;
	@FindBy(id="showItemsPerPage") private WebElement show;
	@FindBy(xpath="//button[@data-original-title='Add to Cart']") private List<WebElement>  addToCart;
	@FindBy(xpath="//i[@class='fa fa-heart']") private List<WebElement>  addToWishList;
	@FindBy(xpath="//i[@class='fa fa-exchange']") private List<WebElement>  addToCompareList;
	@FindBy(xpath="//span[text()='Shopping Cart']") private WebElement  shoppingCart;
	@FindBy(id="wishlist-total") private WebElement  wishList;
	@FindBy(linkText="Compare") private WebElement  compareList;
	@FindBy(xpath="//*[starts-with(text(),'Apple Cinema 27')]") private WebElement appleCinema27 ;
	
	public Wcart(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickDesktops() {
		desktop.click();
	}
	
	public void clickOnAddToCart(String name) {// to call this method user should be on home page
		
		WebElement product =driver.findElement(By.xpath("//a[contains(text(),'"+name.trim()+"')]"));
		product.click();
		List<WebElement> options=driver.findElements(By.xpath("//div[@class='checkbox']/label"));
		if(options.size()>0) {
			driver.findElement(By.xpath("//div[@class='checkbox']/label/input")).click();
		}
		driver.findElement(By.id("button-cart")).click();
	}
	
	
	
	public void selectDesktopForWishList(String name) {
		
		WebElement product =driver.findElement(By.xpath("//a[contains(text(),'"+name.trim()+"')]"));
		product.click();
		driver.findElement(By.className("product-wishlist")).click();
	}
	
	public void selectDesktopForCompareList(String desktop) {
		for(int i=0; i<desktops.size();i++) {
			String selectedDesktop = desktops.get(i).getText();
			if(selectedDesktop.contains(desktop)) {
				addToCompareList.get(i).click();
			}
		}
	}
	
	public void desktopSortedby() {
		
		Select s= new Select(sort);
		s.selectByVisibleText("Name(A-Z)");		
		List<String> originalProductList = new ArrayList<>();
        List<String> sortedProductList = new ArrayList<>();        
        for(WebElement desktop:desktops) {
        	originalProductList.add(desktop.getText());
        }        
        sortedProductList.addAll(originalProductList);        
        Collections.sort(sortedProductList);
        boolean isSorted = originalProductList.equals(sortedProductList);        
        Assert.assertTrue(isSorted);
	}
	
	public void desktopShow() {
		String listSize = "9";

		WebElement listSizeDropdown = show;
        Select select = new Select(listSizeDropdown);
        select.selectByVisibleText(listSize);
        
        WebDriverWait wait = new WebDriverWait(driver, 10); // Adjust the timeout as needed
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@class='caption']/h4"), Integer.parseInt(listSize)));
        
        int actualNumberOfProducts=desktops.size();
        
        Assert.assertTrue(actualNumberOfProducts==Integer.parseInt(listSize));
	}
	public void clickShoppingCart() {
		shoppingCart.click();
	}
	
	public void clickOnWishList() {
		wishList.click();
	}
	
	public void clickOnCompareList() {
		compareList.click();
	}
	
	public void validateDesktop() {
		Assert.assertTrue(appleCinema27.isDisplayed()); 
}
}