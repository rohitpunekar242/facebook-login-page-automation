package com.loginpage.automation;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Facebook_Login {
	static WebDriver driver;

	public static void setup() throws InterruptedException 
	{
		// Invoke the Browser.
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		// Redirect to Facebook web-site.
		String url = "https://www.facebook.com/";
		driver.get(url);
	}

	// Test case 1 : Sign in with blank username and blank password fields.
	public static void Blank_Login_Test() throws InterruptedException {
		// Click on Login button.
		WebElement loginBtn = driver.findElement(By.name("login"));
		loginBtn.click();
		// Verify error message is displayed.
		try {
			WebElement InvalidCredError = driver.findElement(By.className("_9ay7"));
			InvalidCredError.isDisplayed();
			// Compare actual error message with the expected error message.
			String actualError = InvalidCredError.getText();
			String expectedError = "The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
			assertEquals(actualError, expectedError);
		} catch (Exception e) {
			WebElement wrongCredentials = driver.findElement(By.id("error_box"));
			wrongCredentials.isDisplayed();
			// Compare actual error message with the expected error message.
			String actualError = wrongCredentials.getText().trim().replace("\n", " ").replaceAll("\\s+", " ");
			String expectedError = "Wrong credentials Invalid username or password";
			assertEquals(actualError, expectedError);
		}


		System.out.println("Test case 1 success.");
	}

	// Test case 2 : Sign in with blank email address and invalid password field. 
	public static void Invalid_Password_Test() throws InterruptedException {
		// Clear email field data.
		WebElement emailTextbox = driver.findElement(By.id("email"));
		emailTextbox.sendKeys(Keys.CONTROL + "a");
		emailTextbox.sendKeys(Keys.BACK_SPACE);
		// Enter invalid password.
		WebElement passwordTextbox = driver.findElement(By.xpath("//input[@id='pass']"));
		passwordTextbox.sendKeys("WrongPassword123!");
		//Click on Login button.
		WebElement loginBtn = driver.findElement(By.name("login"));
		loginBtn.click();
		Thread.sleep(2000);
		// Verify error message is displayed.
		try {
			WebElement InvalidCredError = driver.findElement(By.className("_9ay7"));
			InvalidCredError.isDisplayed();
			// Compare actual error message with the expected error message.
			String actualError = InvalidCredError.getText();
			String expectedError = "The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
			assertEquals(actualError, expectedError);
		} catch(Exception e) {
			WebElement wrongCredentials = driver.findElement(By.id("error_box"));
			wrongCredentials.isDisplayed();
			// Compare actual error message with the expected error message.
			String actualError = wrongCredentials.getText().trim().replace("\n", " ").replaceAll("\\s+", " ");
			String expectedError = "Wrong credentials Invalid username or password";
			assertEquals(actualError, expectedError);
		}

		System.out.println("Test case 2 success.");
	}

	// Test case 3 : Sign in with blank email address field and valid password.
	public static void Valid_Password_Test() throws InterruptedException {
		// Enter valid password.
		WebElement passwordTextbox = driver.findElement(By.xpath("//input[@id='pass']"));
		passwordTextbox.sendKeys("test@435");
		// Click on login button.
		WebElement loginBtn = driver.findElement(By.name("login"));
		loginBtn.click();
		Thread.sleep(4000);
		// Verify error message is displayed.
		try {
			WebElement InvalidCredError = driver.findElement(By.className("_9ay7"));
			InvalidCredError.isDisplayed();
			// Compare actual error message with the expected error message.
			String actualError = InvalidCredError.getText();
			String expectedError = "The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
			assertEquals(actualError, expectedError);
		} catch(Exception e) {
			// Close 'Continue as Test?' window if occures.
			try {
				WebElement crossBtn = driver.findElement(By.xpath("//*[@class='_9ai5']"));
				if(crossBtn.isDisplayed())
				{
					crossBtn.click();
				}
			} catch(Exception e1) {

			}
			WebElement wrongCredentials = driver.findElement(By.id("error_box"));
			wrongCredentials.isDisplayed();
			// Compare actual error message with the expected error message.
			String actualError = wrongCredentials.getText().trim().replace("\n", " ").replaceAll("\\s+", " ");
			String expectedError = "Wrong credentials Invalid username or password";
			assertEquals(actualError, expectedError);
		}

		System.out.println("Test case 3 success.");
	}

	// Test case 4 : Sign in with Invalid email address and blank password field. 
	public static void Invalid_Email_Test() throws InterruptedException {
		// Enter Invalid email address
		WebElement emailTextbox = driver.findElement(By.id("email"));
		emailTextbox.sendKeys("invaliduser123@gmail.com");
		// Click on Login button.
		WebElement loginBtn = driver.findElement(By.name("login"));
		loginBtn.click();
		// Verify error message is displayed.
		try {
			WebElement InvalidCredError = driver.findElement(By.className("_9ay7"));
			InvalidCredError.isDisplayed();
			// Compare actual error message with the expected error message.
			String actualError = InvalidCredError.getText();
			String expectedError = "The email address you entered isn't connected to an account. Create a new Facebook account.";
			assertEquals(actualError, expectedError);
		} catch(Exception e) {
			WebElement wrongCredentials = driver.findElement(By.id("error_box"));
			wrongCredentials.isDisplayed();
			// Compare actual error message with the expected error message.
			String actualError = wrongCredentials.getText().trim().replace("\n", " ").replaceAll("\\s+", " ");
			String expectedError = "Wrong credentials Invalid username or password";
			assertEquals(actualError, expectedError);
			// Clear email field data.
			WebElement emailbox = driver.findElement(By.id("email"));
			emailbox.sendKeys(Keys.CONTROL + "a");
			emailbox.sendKeys(Keys.BACK_SPACE);
		}

		System.out.println("Test case 4 success.");
	}

	// Test case 5 : Sign in with valid email address and blank password field.
	public static void Valid_Email_Test() throws InterruptedException {
		// Close 'Continue as Test?' window if occures.
		try {
			WebElement crossBtn = driver.findElement(By.xpath("//*[@class='_9ai5']"));
			if(crossBtn.isDisplayed())
			{
				crossBtn.click();
			}
		} catch(Exception e) {

		}
		// Enter valid email address
		WebElement emailTextbox = driver.findElement(By.id("email"));
		emailTextbox.sendKeys("testalpha9544@gmail.com");
		// Click on Login button.
		WebElement loginBtn = driver.findElement(By.name("login"));
		loginBtn.click();
		// Verify error message is displayed.
		WebElement InvalidPasswordError = driver.findElement(By.className("_9ay7"));
		InvalidPasswordError.isDisplayed();
		// Compare actual error message with the expected error message.
		String actualError = InvalidPasswordError.getText().trim().replace("\n", " ").replaceAll("\\s+", " ");
		String expectedError = "The password that you've entered is incorrect. Forgotten password?";
		assertEquals(actualError, expectedError);

		System.out.println("Test case 5 success.");
	}

	// Test case 6 : Sign in with Invalid email address and valid password. 
	public static void InvalidEmail_ValidPwd_Test() throws InterruptedException {
		// Clear email field data.
		WebElement emailTextbox = driver.findElement(By.id("email"));
		emailTextbox.sendKeys(Keys.CONTROL + "a");
		emailTextbox.sendKeys(Keys.BACK_SPACE);
		// Enter Invalid email address.
		emailTextbox.sendKeys("invaliduser123@gmail.com");
		// Enter valid password.
		WebElement passwordTextbox = driver.findElement(By.xpath("//input[@id='pass']"));
		passwordTextbox.sendKeys("test@435");
		// Click on login button.
		WebElement loginBtn = driver.findElement(By.name("login"));
		loginBtn.click();
		Thread.sleep(2000);
		// Verify error message is displayed.
		try {
			WebElement InvalidCredError = driver.findElement(By.className("_9ay7"));
			InvalidCredError.isDisplayed();
			// Compare actual error message with the expected error message.
			String actualError = InvalidCredError.getText();
			String expectedError = "The email address you entered isn't connected to an account. Create a new Facebook account.";
			assertEquals(actualError, expectedError);
		} catch(Exception e) {
			WebElement wrongCredentials = driver.findElement(By.id("error_box"));
			wrongCredentials.isDisplayed();
			// Compare actual error message with the expected error message.
			String actualError = wrongCredentials.getText().trim().replace("\n", " ").replaceAll("\\s+", " ");
			String expectedError = "Wrong credentials Invalid username or password";
			assertEquals(actualError, expectedError);
			// Clear email field data.
			WebElement emailbox = driver.findElement(By.id("email"));
			emailbox.sendKeys(Keys.CONTROL + "a");
			emailbox.sendKeys(Keys.BACK_SPACE);
		}

		System.out.println("Test case 6 success.");
	}

	// Test case 7 : Sign in with valid email address and Invalid password.
	public static void ValidEmail_InvalidPwd_Test() throws InterruptedException {
		// Enter valid email address.
		WebElement emailTextbox = driver.findElement(By.id("email"));
		emailTextbox.sendKeys("testalpha9544@gmail.com");
		// Enter Invalid password.
		WebElement passwordTextbox = driver.findElement(By.xpath("//input[@id='pass']"));
		passwordTextbox.sendKeys("WrongPassword123!");
		// Click on login button.
		WebElement loginBtn = driver.findElement(By.name("login"));
		loginBtn.click();
		Thread.sleep(2000);
		// Verify error message is displayed.
		WebElement InvalidPasswordError = driver.findElement(By.className("_9ay7"));
		InvalidPasswordError.isDisplayed();
		// Compare actual error message with the expected error message.
		String actualError = InvalidPasswordError.getText().trim().replace("\n", " ").replaceAll("\\s+", " ");
		String expectedError = "The password that you've entered is incorrect. Forgotten password?";
		assertEquals(actualError, expectedError);

		System.out.println("Test case 7 success.");
	}

	// Test case 8 : Sign in with Invalid email address and Invalid password.
	public static void InvalidEmail_InvalidPwd_Test() throws InterruptedException {
		// Clear email field data.
		WebElement emailTextbox = driver.findElement(By.id("email"));
		emailTextbox.sendKeys(Keys.CONTROL + "a");
		emailTextbox.sendKeys(Keys.BACK_SPACE);
		// Enter Invalid email address.
		emailTextbox.sendKeys("invaliduser123@gmail.com");
		// Enter Invalid password.
		WebElement passwordTextbox = driver.findElement(By.xpath("//input[@id='pass']"));
		passwordTextbox.sendKeys("WrongPassword123!");
		// Click on login button.
		WebElement loginBtn = driver.findElement(By.name("login"));
		loginBtn.click();
		Thread.sleep(2000);
		// Verify error message is displayed.
		try {
			WebElement InvalidCredError = driver.findElement(By.className("_9ay7"));
			InvalidCredError.isDisplayed();
			// Compare actual error message with the expected error message.
			String actualError = InvalidCredError.getText();
			String expectedError = "The email address you entered isn't connected to an account. Create a new Facebook account.";
			assertEquals(actualError, expectedError);
		} catch(Exception e) {
			WebElement wrongCredentials = driver.findElement(By.id("error_box"));
			wrongCredentials.isDisplayed();
			// Compare actual error message with the expected error message.
			String actualError = wrongCredentials.getText().trim().replace("\n", " ").replaceAll("\\s+", " ");
			String expectedError = "Wrong credentials Invalid username or password";
			assertEquals(actualError, expectedError);
			// Clear email field data.
			WebElement emailbox = driver.findElement(By.id("email"));
			emailbox.sendKeys(Keys.CONTROL + "a");
			emailbox.sendKeys(Keys.BACK_SPACE);
		}

		System.out.println("Test case 8 success.");
	}

	// Test case 9 : Sign in with valid email address and valid password.
	public static void ValidEmail_ValidPwd_Test() throws InterruptedException {
		// Enter valid email address.
		WebElement emailTextbox = driver.findElement(By.id("email"));
		emailTextbox.sendKeys("testalpha9544@gmail.com");
		// Enter valid password.
		WebElement passwordTextbox = driver.findElement(By.xpath("//input[@id='pass']"));
		passwordTextbox.sendKeys("test@435");
		// Click on login button.
		WebElement loginBtn = driver.findElement(By.name("login"));
		loginBtn.click();
		Thread.sleep(14000);
		// Verify successful login & page is redirected to dashboard.
		WebElement dashboardHeader = driver.findElement(By.cssSelector("[class*='xg87l8a'] span"));
		assertTrue(dashboardHeader.isDisplayed());
		String actualDashboardText = dashboardHeader.getText();
		String expectedDashboardText = "Welcome to Facebook, Test";
		assertEquals(actualDashboardText, expectedDashboardText);

		System.out.println("Test case 9 success.");
	}

	// Test case 10 : Verify logout.
	public static void Logout_Test() throws InterruptedException {

		// Click on profile drop-down.
		WebElement profileDropdown = driver.findElement(By.xpath("//*[@aria-label='Your profile']"));
		profileDropdown.click();
		Thread.sleep(4000);
		// Click on logout button.
		WebElement logoutButton = driver.findElement(By.xpath("//*[text()='Log out']")); 
		logoutButton.click();
		Thread.sleep(5000);
		// Verify redirection to login page.
		String actualLoginTitle = driver.getTitle();
		String expectedLoginTitle = "Facebook – log in or sign up";
		assertEquals(actualLoginTitle, expectedLoginTitle);

		System.out.println("Test case 10 success.");
	}


	public static void teardown()
	{
		driver.quit();
	}


	public static void main(String[] args) throws InterruptedException {
		setup();
		Blank_Login_Test();
		Invalid_Password_Test();
		Valid_Password_Test();
		Invalid_Email_Test();
		Valid_Email_Test();
		InvalidEmail_ValidPwd_Test();
		ValidEmail_InvalidPwd_Test();
		InvalidEmail_InvalidPwd_Test();
		ValidEmail_ValidPwd_Test();
		Logout_Test();
		teardown();

	}

}
