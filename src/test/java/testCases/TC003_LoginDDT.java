package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{
			
		@Test(dataProvider = "loginData", dataProviderClass = DataProviders.class, groups = "Datadriven")
		public void verify_LoginDDT(String email, String password, String exp) throws InterruptedException {
			
			logger.info("Starting TC003_LoginDDT...");
			
			try {
			
			//Home Page
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			//Login Page
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(password);
			lp.clickLogin();
			
			//My Account Page
			MyAccountPage myacc= new MyAccountPage(driver);
			boolean targetPage = myacc.isMyAccountPageExixts();
			
			if(exp.equalsIgnoreCase("Valid"))
			{
				if(targetPage==true)
				{			
					myacc.clkLogout();
					Assert.assertTrue(true);
					
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(targetPage==true)
				{
					myacc.clkLogout();
					Assert.assertTrue(false);
					
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
			
			} catch (Exception e) {
				Assert.fail();
			}
			
			Thread.sleep(3000);
			logger.info("Finishing TC003_LoginDDT...");
			
		}
}
