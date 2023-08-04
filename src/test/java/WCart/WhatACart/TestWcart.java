package WCart.WhatACart;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.Utilities;

public class TestWcart extends Base{

	@BeforeMethod	
	public void invokeBrowser() throws Exception {
		Base.initializeBrowser();
	}
	

	 @Test (priority=-1, dataProvider="CredentialsSupplier")
	 public void loginToWcart(String Username,String Password) throws InterruptedException { 
      Login l=new Login(driver);
	  l.enterUsername(Username);
	  Thread.sleep(2000);
	  l.enterPassword(Password);
	  Thread.sleep(2000);
	  l.clickLogin();
	  Thread.sleep(2000);
}
	 @DataProvider(name="CredentialsSupplier")
	 public Object[][] supplyTestData(){
		 Object[][] data= Utilities.getTestDataFromExcel("Sheet1");//{{"spaulkar","Research$520"}};
		 return data;
	 }
	 
//	@Test(priority=1)
//	
//	public void selectdesktop() {
//		Wcart w= new Wcart(driver);
//		w.clickDesktops();
//		w.clickOnAddToCart("Apple Cinema 21");
//	}
//	
//	@Test(priority=2)	
//	public void checkSelectedDesktopAddedToWishList() {
//		// To verify that selected desktop added to WishList 
//		Wcart w= new Wcart(driver);
//		w.clickDesktops();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,500)", "");
//		w.selectDesktopForWishList("Apple Cinema 27");
//	}
//	@Test (priority=3)
//	public void checkSelectedDesktopAddedToCompareList() {
//		// To verify that selected desktop added to CompareList 
//		Wcart w= new Wcart(driver);
//		w.clickDesktops();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,500)", "");
//		w.selectDesktopForCompareList("Apple Cinema 25");
//		w.clickOnCompareList();
//		w.validateDesktop();
//	}
//	
//	@Test(priority=4)
//	
//	public void sorteddesktoplist() {
//		Wcart w= new Wcart(driver);
//		w.clickDesktops();
//		w.desktopSortedby();
//	}
//	
//	@Test(priority=5)
//	
//	public void showDesktopList() {
//		Wcart w= new Wcart(driver);
//		w.clickDesktops();
//		w.desktopSortedby();
//		w.desktopShow();
//	}
	 @AfterMethod
	 public void close() {
		 driver.close();
	 }
	 
}
