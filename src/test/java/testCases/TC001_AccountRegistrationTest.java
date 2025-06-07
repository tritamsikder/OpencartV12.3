package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	@Test (groups = {"Regression","Master"})
	public void verify_account_registration() {
		
		logger.info("***** Starting TC001_AccountRegistrationTest  ****");
		logger.debug("This is a debug log message");
		
		try {
		HomePage home = new HomePage(driver);
		
		home.clickMyAccount();
		logger.info("Clicked on MyAccount Link.. ");
		
		home.clickRegister();
		logger.info("Clicked on Register Link.. ");
		
		AccountRegistrationPage accountRegistration = new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details...");
		accountRegistration.setFirstname(randomString().toUpperCase());
		accountRegistration.setLastname(randomString().toUpperCase());
		accountRegistration.setEmail(randomString() + "@test.com");
		accountRegistration.setTelephone(randomNumber());
		
		String password = randomAlphanumeric();
		
		accountRegistration.setPassword(password);
		accountRegistration.setConfirmPassword(password);
		accountRegistration.checkPrivacyPolicy();
		accountRegistration.clickContinue();
		logger.info("Validating expected message..");
		
		String confirmMsg = accountRegistration.getConfirmationMsg();
		
		Assert.assertEquals(confirmMsg, "Your Account Has Been Created!");
		
		logger.info("Test passed");
		}
		catch(Exception e) {
			
			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		}
		finally {
			logger.info("***** Finished TC001_AccountRegistrationTest *****");
		}
		
	}

}
