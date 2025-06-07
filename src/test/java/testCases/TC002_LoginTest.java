package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test (groups = {"Sanity","Master"})
	public void verifyLogin() {
		logger.info("Starting TC002_LoginTest...");
		
		try {
			
		//Home Page
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//Login Page
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//My Account Page
		MyAccountPage myacc= new MyAccountPage(driver);
		boolean targetPage = myacc.isMyAccountPageExixts();
		
//		Assert.assertEquals(targetPage, true, "Login Failed");
		
		Assert.assertTrue(targetPage);
		
		} catch (Exception e) {
			Assert.fail();
		}
		
		logger.info("TC002_LoginTest finished....");
	}

}
