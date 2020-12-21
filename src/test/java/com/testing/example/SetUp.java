package com.jazz.JazzWorld.JazzWorldTests;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

//public class AppTest extends ExtentReportDemo {
	public class AppTest{




	String destDir;
	DateFormat dateFormat;
	private AndroidDriver<MobileElement> driver;
	private TouchAction touchAction;
	WebDriver driverwait;
	String loginnumber = "03058653178";// 03058652178//03012620019//03059175170//03058651178//03058653278
	String CustName = "ikramaa";// Testing123//MOBILINK FCRM123//Rsredo
	String newvouchercard = "";
	String insufficient_message = "You don't have enough balance to subscribe to this package.";
	String back_button = "com.jazz.jazzworld:id/back_img";
	String toolbar_title = "com.jazz.jazzworld:id/toolbar_title";
	String complaint_successid = "com.jazz.jazzworld:id/compalint_message";
	String complaint_successtext = "Dear Customer, your complaint has been successfully lodged, you will be contacted soon. Thank You.";
	String maintab = "androidx.appcompat.app.ActionBar$Tab";

	@BeforeTest
	public void setUp() throws MalformedURLException {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("udid", "emulator-5554"); //QS3110C1621D020032025 //R58M701JJ5T //238c0617 //emulator-5554
		desiredCapabilities.setCapability("platformName", "android");
		desiredCapabilities.setCapability("autoLaunch", false);
		desiredCapabilities.setCapability("skipDeviceInitialization", true);
		desiredCapabilities.setCapability("autoGrantPermissions", true);
		desiredCapabilities.setCapability("disableAndroidWatchers", true);
		desiredCapabilities.setCapability("deviceName", "A20");
		desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
		desiredCapabilities.setCapability("noReset", true);
		URL remoteUrl = new URL("http://localhost:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
		touchAction = new TouchAction(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);



	}



	@Test(priority = 1, description = "Login") public void login() throws InterruptedException {

		//driver.findElementByAccessibilityId("Jazz World, 1 notification");
				driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Jazz World\"]").click();
				Thread.sleep(7000);
				driver.findElementById("com.jazz.jazzworld:id/login_connect").click();
				Thread.sleep(3000);
				driver.findElement(By.id("com.jazz.jazzworld:id/phoneNumber")).sendKeys("03058653178"); 
				Thread.sleep(3000); 
				driver.findElementById("com.jazz.jazzworld:id/fab").click();
				Thread.sleep(5000);
				driver.findElementById("com.jazz.jazzworld:id/pin1").sendKeys("1");
				driver.findElementById("com.jazz.jazzworld:id/pin2").sendKeys("1");
				driver.findElementById("com.jazz.jazzworld:id/pin3").sendKeys("1");
				driver.findElementById("com.jazz.jazzworld:id/pin4").sendKeys("1");
				Thread.sleep(3000); 
				driver.findElementById("com.jazz.jazzworld:id/fab_verify_pin").click();
				Thread.sleep(10000);
				
				//driver.findElementsById("com.jazz.jazzworld:id/container_tiles").get(7).click();
				//driver.findElementsByClassName("android.widget.FrameLayout").get(2).click();

				MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ImageView");
				el1.click();
				
				Thread.sleep(3000); 
				String usernumber = driver.findElement(By.id("com.jazz.jazzworld:id/lblMsisdn")).getText();
				System.out.println("Login User Number :" + usernumber);
				String expectedText = "03058653178"; 
				String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/lblMsisdn")).getText();
				Assert.assertEquals(actualText, expectedText);
			
	}	

	
	/******************************************DASHBOARD***********************************************/

	@Test (priority = 2, description = "Prepaid_Balance") // Verify and Print user balance
	private void Prepaid_Balance() throws InterruptedException {
		Thread.sleep(3000);
		try {
			if(driver.findElement(By.id("com.jazz.jazzworld:id/happyImageView")).isDisplayed())
			{
				
		        driver.findElement(By.id("com.jazz.jazzworld:id/happyImageView")).click();
				String expectedText = "Remind Later";
				String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/happyImageView")).getText().toString();
				Assert.assertEquals(actualText, expectedText);
				takeScreenShot();
			}
			else
			{
				String balance = driver.findElementsByClassName("android.widget.LinearLayout").get(1).getText().toString();
				System.out.println("User Balance :" + balance);
			}
		} catch (Exception e) 
		{
			String balance = driver.findElementsByClassName("android.widget.LinearLayout").get(1).getText().toString();
			System.out.println("User Balance :" + balance);
		}
	}
	
	/*******************************************Relead Dashboard Data******************************************/
	
	@Test (priority = 3, description = "Reload_Dashboard")
	private void Reload_Dashboard() throws InterruptedException
	{
		try {
			if(driver.findElement(By.id("com.jazz.jazzworld:id/happyImageView")).isDisplayed())
			{
				
		        driver.findElement(By.id("com.jazz.jazzworld:id/happyImageView")).click();
				String expectedText = "Remind Later";
				String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/happyImageView")).getText();
				Assert.assertEquals(actualText, expectedText);
				takeScreenShot();
			}
			else
			{
				driver.findElement(By.id("com.jazz.jazzworld:id/refreshDashboard")).click();
				Thread.sleep(3000);
				String expectedText = "03058653178";
		        String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/lblMsisdn")).getText();
		        Assert.assertEquals(actualText, expectedText);
			}
		} catch (Exception e) {
			driver.findElement(By.id("com.jazz.jazzworld:id/refreshDashboard")).click();
			Thread.sleep(3000);
			String expectedText = "03058653178";
	        String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/lblMsisdn")).getText();
	        Assert.assertEquals(actualText, expectedText);
		}
	}
	
	/*******************************************Relead Dashboard Data End*****************************************/
	
	/*******************************************Search Dashboard Data*****************************************/
	
	@Test (priority = 4, description = "Search_Dashboard")
	private void Search_Dashboard() throws InterruptedException
	{
		driver.findElement(By.id("com.jazz.jazzworld:id/search")).click();
		driver.findElement(By.id("com.jazz.jazzworld:id/searchBox")).sendKeys("what");
		List<MobileElement> buttons = driver.findElements(By.id("com.jazz.jazzworld:id/contentView"));
		buttons.get(0).click();
		Thread.sleep(2000);
		String expectedText = "What's New";
		String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/toolbar_title")).getText();
        Assert.assertEquals(actualText, expectedText);
        driver.findElement(By.id("com.jazz.jazzworld:id/back_img")).click();
	}
	
	@Test (priority = 5, description = "Discounts") // Discounts View Page
	private void Discounts() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElementsByClassName("android.widget.LinearLayout").get(31).click();
		Thread.sleep(5000);
		try {

			if(IsElementPresent(By.id("com.jazz.jazzworld:id/toolbar_title")) == true)
			{
				String expectedText = "Discounts";
				String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/toolbar_title")).getText();
				Assert.assertEquals(actualText, expectedText);
				takeScreenShot();
				driver.findElementsById("com.jazz.jazzworld:id/container_tiles").get(8).click();
			}
			else if(IsElementPresent(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")) == true)
			{
				driver.findElementById("com.android.permissioncontroller:id/permission_allow_foreground_only_button").click();
				Thread.sleep(3000);
				String expectedText = "Discounts";
				String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/toolbar_title")).getText();
				Assert.assertEquals(actualText, expectedText);
				takeScreenShot();
				driver.findElementsById("com.jazz.jazzworld:id/container_tiles").get(1).click();
			}
		}

		catch (Exception e) {
			String expectedText = "Discounts";
			String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/toolbar_title")).getText();
			Assert.assertEquals(actualText, expectedText);
			takeScreenShot();
			driver.findElementsById("com.jazz.jazzworld:id/container_tiles").get(1).click();

		}
	}

	/*******************************************Search Dashboard Data End*****************************************/
	
	/****************************************VIEW HISTORY Start***********************************************/
	
	@Test (priority =9, description = "Viewhistory") // View History all
	private void Viewhistory() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElementsByClassName("android.widget.FrameLayout").get(22).click();
		Thread.sleep(3000);
		driver.findElement(By.id("com.jazz.jazzworld:id/yes")).click();
		Thread.sleep(3000);
		driver.findElementById("com.jazz.jazzworld:id/pin1").sendKeys("1");

		driver.findElementById("com.jazz.jazzworld:id/pin2").sendKeys("1");

		driver.findElementById("com.jazz.jazzworld:id/pin3").sendKeys("1");

		driver.findElementById("com.jazz.jazzworld:id/pin4").sendKeys("1");
		driver.findElement(By.id("com.jazz.jazzworld:id/fab_verify_pin")).click();
		Thread.sleep(10000);
		takeScreenShot();
		String expectedText = "All History";
        String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/toolbar_title")).getText();
        Assert.assertEquals(actualText, expectedText);
		}
	
	
	
	@Test (priority =11, description = "Download_History") // Download History
	private void Download_History() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.id("com.jazz.jazzworld:id/history_wrapper")).click();
		Thread.sleep(3000);
		takeScreenShot();
		driver.findElement(By.id("com.google.android.apps.docs:id/action_add_to_drive")).click();
		String pdfnumber = driver.findElement(By.id("com.google.android.apps.docs:id/upload_edittext_document_title"))
				.getText().toString();
		System.out.println(pdfnumber);
		String expectedText = "Save to Drive";
		String actualText = driver.findElement(By.id("com.google.android.apps.docs:id/title")).getText();
		Assert.assertEquals(actualText, expectedText);
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
     
		}
	@Test (priority =12, description = "Calls_History") // View History call
	private void Calls_History() throws InterruptedException {
		Thread.sleep(3000);
		List<MobileElement> buttons = driver.findElements(By.className(maintab));
		buttons.get(1).click();
		Thread.sleep(2000);
		takeScreenShot();
		System.out.println("Calls History details are below");
		String Balanceused = driver.findElement(By.id("com.jazz.jazzworld:id/total_recharge_value")).getText().toString();
		System.out.println(Balanceused);
		String Calls = driver.findElement(By.id("com.jazz.jazzworld:id/total_balance_value")).getText().toString();
		System.out.println(Calls+" Second");
		String expectedText = "Call History";
        String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/toolbar_title")).getText();
        Assert.assertEquals(actualText, expectedText);
		}
	@Test (priority =13, description = "SMS_History") // View History SMS
	private void SMS_History() throws InterruptedException {
		List<MobileElement> buttons = driver.findElements(By.className(maintab));
		buttons.get(2).click();
		//Thread.sleep(2000);
		takeScreenShot();
		System.out.println("SMS History details are below");
		String Balanceused = driver.findElement(By.id("com.jazz.jazzworld:id/total_recharge_value")).getText().toString();
		System.out.println(Balanceused);
		String sms = driver.findElement(By.id("com.jazz.jazzworld:id/total_balance_value")).getText().toString();
		System.out.println(sms+" sms");
		String expectedText = "SMS History";
        String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/toolbar_title")).getText();
        Assert.assertEquals(actualText, expectedText);
		}
	@Test (priority =14, description = "Data_History") // View History SMS
	private void Data_History() throws InterruptedException {
		List<MobileElement> buttons = driver.findElements(By.className(maintab));
		buttons.get(3).click();
		Thread.sleep(2000);
		takeScreenShot();
		System.out.println("Data History details are below");
		String Balanceused = driver.findElement(By.id("com.jazz.jazzworld:id/total_recharge_value")).getText().toString();
		System.out.println(Balanceused);
		String data = driver.findElement(By.id("com.jazz.jazzworld:id/total_balance_value")).getText().toString();
		System.out.println(data+" MB");
		String expectedText = "Data History";
        String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/toolbar_title")).getText();
        Assert.assertEquals(actualText, expectedText);
		}
		
	  
	  //Below cases are only for prepaid
	  @Test (priority =15, description = "Offers_History") // View History Offers for Prepaid
		private void Offers_History() throws InterruptedException 
	  {
			List<MobileElement> buttons = driver.findElements(By.className(maintab));
			buttons.get(3).click();
			Thread.sleep(2000);
			takeScreenShot();
			System.out.println("Prepaid Offer History are below");
			String offersamount = driver.findElement(By.id("com.jazz.jazzworld:id/total_recharge_value")).getText().toString();
			System.out.println(offersamount);
			String expectedText = "Offers History";
	        String actualText = driver.findElement(By.id(toolbar_title)).getText();
	        Assert.assertEquals(actualText, expectedText);
	  }
	  
	  @Test (priority =16, description = "Recharge_History") // View recharge history for Prepaid
		private void Recharge_History() throws InterruptedException 
	  {
			List<MobileElement> buttons = driver.findElements(By.className(maintab));
			buttons.get(3).click();
			Thread.sleep(2000);
			takeScreenShot();
			System.out.println("Total Recharge value is below");
			String offersamount = driver.findElement(By.id("com.jazz.jazzworld:id/total_recharge_value")).getText().toString();
			System.out.println(offersamount);
			String expectedText = "Recharge History";
	        String actualText = driver.findElement(By.id(toolbar_title)).getText();
	        Assert.assertEquals(actualText, expectedText);
	        driver.findElement(By.id("com.jazz.jazzworld:id/back_img")).click();
	  }
	  /****************************************VIEW HISTORY End***********************************************/
	
		@Test(priority = 17, description = "Favorite_Offers") // Favorite Package View
private void Favorite_Offers() throws InterruptedException {
Thread.sleep(3000);
driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout[3]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout").click();
Thread.sleep(3000);
takeScreenShot();
String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/toolbar_title")).getText();
System.out.println(actualText);
String expectedText = "Favorite Packages";
String actualText2 = driver.findElement(By.id("com.jazz.jazzworld:id/toolbar_title")).getText();
Assert.assertEquals(actualText2, expectedText);

}

		@Test(priority = 18, description = "Sign In") // Favorite Package Subscription
		private void Favorite_OfferSubscription() throws InterruptedException {

			Thread.sleep(3000);
			List<MobileElement> buttons = driver.findElements(By.className("android.widget.Button"));
			buttons.get(0).click();
			Thread.sleep(3000);
			takeScreenShot();
			driver.findElement(By.id("com.jazz.jazzworld:id/subscribe")).click();
			takeScreenShot();
			try {
				if (IsElementPresent(By.id("com.jazz.jazzworld:id/failure_title")) == true) {
					String expectedText = insufficient_message;
					String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/message")).getText();
					takeScreenShot();
					Assert.assertEquals(actualText, expectedText);
					System.out.println(actualText + "favorite offer");
					driver.findElement(By.id("com.jazz.jazzworld:id/ok_wrapper")).click();
					// driver.findElement(By.id("com.jazz.jazzworld:id/back_img")).click();
				} else if (IsElementPresent(By.id("com.jazz.jazzworld:id/cross")) == true) {
					System.out.println("I AM IN CROSSSS");
					String expectedText = insufficient_message;
					String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/user_name")).getText();
					System.out.println("Just clicked cross button against my offer subscription");
					// driver.findElement(By.id(back_button)).click();
					Assert.assertEquals(actualText, expectedText);
				} else if (IsElementPresent(By.id("com.jazz.jazzworld:id/main_container")) == true) {
					System.out.println("Success");
					String expectedText = "Your request has been successfully received";
					String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/message")).getText();
					takeScreenShot();
					Assert.assertEquals(actualText, expectedText);
					driver.findElement(By.id("com.jazz.jazzworld:id/ok_wrapper_main")).click();
					driver.findElementByXPath(
							"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout[3]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout")
					.click();
				} else {
					System.out.println("why i am in else of package favorite subscription");
				}
			} catch (Exception e) {
				String expectedText = "Your request has been successfully received";
				String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/message")).getText();
				Assert.assertEquals(actualText, expectedText);
				driver.findElement(By.id("com.jazz.jazzworld:id/ok_wrapper_main")).click();
				driver.findElementByXPath(
						"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout[3]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout")
				.click();
			} /// new try catch end here

		}


		@Test (priority =19, description = "Hybrid_Packages") // Hybrid Package View
		private void Hybrid_Packages() throws InterruptedException {
			//Thread.sleep(10000);
			//driver.findElement(By.id("com.jazz.jazzworld:id/back_img")).click();

			List<MobileElement> buttons = driver.findElements(By.className("androidx.appcompat.app.ActionBar$Tab"));//android.support.v7.app.ActionBar$Tab
			buttons.get(2).click();

			//driver.findElementByXPath("//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"HYBRID\"]/android.widget.LinearLayout/android.widget.TextView").click();
			Thread.sleep(2000);
			takeScreenShot();
			String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/toolbar_title")).getText();
			System.out.println(actualText);
			String expectedText = "Hybrid Packages";
			String actualText2 = driver.findElement(By.id("com.jazz.jazzworld:id/toolbar_title")).getText();
			Assert.assertEquals(actualText2, expectedText);
		}//hybrid package view end here

		@Test (priority =20, description = "Hybrid_PackageSubscription") // Hybrid Package Subscription
		private void Hybrid_PackageSubscription() throws InterruptedException {
			Thread.sleep(2000);
			List<MobileElement> buttons = driver.findElements(By.className("android.widget.Button"));
			buttons.get(0).click();

			//driver.findElementByXPath("//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"HYBRID\"]/android.widget.LinearLayout/android.widget.TextView").click();
			takeScreenShot();
			driver.findElement(By.id("com.jazz.jazzworld:id/subscribe")).click();
			takeScreenShot();
			//new try catch start hers
			try {
				if(IsElementPresent(By.id("com.jazz.jazzworld:id/failure_title")) == true)
				{
					String expectedText = insufficient_message;
					String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/message")).getText();
					takeScreenShot();
					Assert.assertEquals(actualText, expectedText);
					System.out.println(actualText+"hybrid offer");
					driver.findElement(By.id("com.jazz.jazzworld:id/ok_wrapper")).click();
					//driver.findElement(By.id("com.jazz.jazzworld:id/back_img")).click();
				}
				else if (IsElementPresent(By.id("com.jazz.jazzworld:id/cross")) == true) {
					System.out.println("I AM IN CROSSSS");
					String expectedText = insufficient_message;
					String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/user_name")).getText();
					System.out.println("Just clicked cross button against hybrid subscription");
					//driver.findElement(By.id(back_button)).click();
					Assert.assertEquals(actualText, expectedText);
				}
				else if (IsElementPresent(By.id("com.jazz.jazzworld:id/main_wrapper")) == true) {
					System.out.println("Success");
					String expectedText = "Your request has been successfully received";
					String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/message_tv")).getText();
					takeScreenShot();
					Assert.assertEquals(actualText, expectedText);
					driver.findElement(By.id("com.jazz.jazzworld:id/ok_wrapper_main")).click();
					driver.findElementByXPath(
							"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout[3]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout")
					.click();
				}
				else
				{
					System.out.println("why i am in else of package hybrid subscription");
				}
			} catch (Exception e) {
				String expectedText = "Your request has been successfully received";
				String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/message")).getText();
				Assert.assertEquals(actualText, expectedText);
				driver.findElement(By.id("com.jazz.jazzworld:id/ok_wrapper_main")).click();
				driver.findElementByXPath(
						"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout[3]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout")
				.click();
			}///new try catch end here


		}//hybrid package subscription end here

		@Test (priority =21, description = "Data_Package") // Packages Data View
		private void Data_Package() throws InterruptedException {
			Thread.sleep(3000);
			List<MobileElement> buttons = driver.findElements(By.className("androidx.appcompat.app.ActionBar$Tab"));
			buttons.get(2).click();
			Thread.sleep(2000);
			takeScreenShot();
			String expectedText = "Data Packages";
			String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/toolbar_title")).getText();
			Assert.assertEquals(actualText, expectedText);
		}//data package view end here

		@Test (priority =22, description = "Data_OfferSubscription") // Data Package Subscription
		private void Data_OfferSubscription() throws InterruptedException {
			Thread.sleep(2000);
			List<MobileElement> buttons = driver.findElements(By.className("android.widget.Button"));
			buttons.get(0).click();
			Thread.sleep(3000);
			takeScreenShot();
			driver.findElement(By.id("com.jazz.jazzworld:id/subscribe")).click();
			takeScreenShot();
			//new try catch start hers
			try {
				if(IsElementPresent(By.id("com.jazz.jazzworld:id/failure_title")) == true)
				{
					String expectedText = insufficient_message;
					String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/message")).getText();
					takeScreenShot();
					Assert.assertEquals(actualText, expectedText);
					System.out.println(actualText+"data offer");
					driver.findElement(By.id("com.jazz.jazzworld:id/ok_wrapper")).click();
				}
				else if (IsElementPresent(By.id("com.jazz.jazzworld:id/cross")) == true) {
					System.out.println("I AM IN CROSSSS");
					String expectedText = insufficient_message;
					String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/user_name")).getText();
					System.out.println("Just clicked cross button against data subscription");
					Assert.assertEquals(actualText, expectedText);
				}
				else if (IsElementPresent(By.id("com.jazz.jazzworld:id/main_wrapper")) == true) {
					System.out.println("Success");
					String expectedText = "Your request has been successfully received";
					String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/message_tv")).getText();
					takeScreenShot();
					Assert.assertEquals(actualText, expectedText);
					driver.findElement(By.id("com.jazz.jazzworld:id/ok_wrapper_main")).click();
					driver.findElementByXPath(
							"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout[3]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout")
					.click();
				}
				else
				{
					System.out.println("why i am in else of package data subscription");
				}
			} catch (Exception e) {
				String expectedText = "Your request has been successfully received";
				String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/message")).getText();
				Assert.assertEquals(actualText, expectedText);
				driver.findElement(By.id("com.jazz.jazzworld:id/ok_wrapper_main")).click();
				driver.findElementByXPath(
						"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout[3]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout")
				.click();
			}///new try catch end here



		}//data package subscription end here

		@Test (priority =23, description = "Call_Packages") // Packages Calls View
		private void Call_Packages() throws InterruptedException {
			Thread.sleep(3000);
					List<MobileElement> buttons = driver.findElements(By.className("androidx.appcompat.app.ActionBar$Tab"));
					buttons.get(3).click();

			Thread.sleep(2000);
			takeScreenShot();
			String expectedText = "Call Packages";
			String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/toolbar_title")).getText();
			Assert.assertEquals(actualText, expectedText);
		}//call package view end here

		@Test (priority =24, description = "Call_PackageSubscription") // Calls Package Subscription
		private void Call_PackageSubscription() throws InterruptedException {

			Thread.sleep(2000);
			List<MobileElement> buttons = driver.findElements(By.className("android.widget.Button"));
			buttons.get(0).click();

			takeScreenShot();
			Thread.sleep(2000);
			driver.findElement(By.id("com.jazz.jazzworld:id/subscribe")).click();
			takeScreenShot();
			//new try catch start hers
			try {
				if(IsElementPresent(By.id("com.jazz.jazzworld:id/failure_title")) == true)
				{
					String expectedText = insufficient_message;
					String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/message")).getText();
					takeScreenShot();
					Assert.assertEquals(actualText, expectedText);
					System.out.println(actualText +"call offer");
					driver.findElement(By.id("com.jazz.jazzworld:id/ok_wrapper")).click();
				}
				else if (IsElementPresent(By.id("com.jazz.jazzworld:id/cross")) == true) {
					System.out.println("I AM IN CROSSSS");
					String expectedText = insufficient_message;
					String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/user_name")).getText();
					System.out.println("Just clicked cross button against call subscription");
					Assert.assertEquals(actualText, expectedText);
				}
				else if (IsElementPresent(By.id("com.jazz.jazzworld:id/main_wrapper")) == true) {
					System.out.println("Success");
					String expectedText = "Your request has been successfully received";
					String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/message_tv")).getText();
					takeScreenShot();
					Assert.assertEquals(actualText, expectedText);
					driver.findElement(By.id("com.jazz.jazzworld:id/ok_wrapper_main")).click();
					driver.findElementByXPath(
							"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout[3]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout")
					.click();			}
				else
				{
					System.out.println("why i am in else of package call subscription");
				}
			} catch (Exception e) {
				String expectedText = "Your request has been successfully received";
				String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/message")).getText();
				Assert.assertEquals(actualText, expectedText);
				driver.findElement(By.id("com.jazz.jazzworld:id/ok_wrapper_main")).click();
				driver.findElementByXPath(
						"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout[3]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout")
				.click();		}///new try catch end here

		}//Call package subscription end here


		@Test (priority =25, description = "SMS_Packages") // Packages SMS View
		private void SMS_Packages() throws InterruptedException {
			Thread.sleep(5000);
					 List<MobileElement> buttons =
					 driver.findElements(By.className("androidx.appcompat.app.ActionBar$Tab"));
					 buttons.get(4).click();

			Thread.sleep(2000);
			takeScreenShot();
			String expectedText = "SMS Packages";
			String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/toolbar_title")).getText();
			Assert.assertEquals(actualText, expectedText);
		}//sms package view end here



		@Test (priority =26, description = "SMS_PackageSubscription") // SMS Package Subscription
		private void SMS_PackageSubscription() throws InterruptedException {
			Thread.sleep(2000);

					List<MobileElement> buttons = driver.findElements(By.className("android.widget.Button"));
		buttons.get(0).click();
			takeScreenShot();
			driver.findElement(By.id("com.jazz.jazzworld:id/subscribe")).click();
			takeScreenShot();

			//new try catch start hers
			try {
				if(IsElementPresent(By.id("com.jazz.jazzworld:id/failure_title")) == true)
				{
					String expectedText = insufficient_message;
					String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/message")).getText();
					takeScreenShot();
					Assert.assertEquals(actualText, expectedText);
					System.out.println(actualText +"sms offer");
					driver.findElement(By.id("com.jazz.jazzworld:id/ok_wrapper")).click();
					driver.findElement(By.id("com.jazz.jazzworld:id/back_img")).click();
				}
				else if (IsElementPresent(By.id("com.jazz.jazzworld:id/cross")) == true) {
					System.out.println("I AM IN CROSSSS");
					String expectedText = insufficient_message;
					String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/user_name")).getText();
					System.out.println("Just clicked cross button against sms subscription");
					driver.findElement(By.id(back_button)).click();
					Assert.assertEquals(actualText, expectedText);
				}
				else if (IsElementPresent(By.id("com.jazz.jazzworld:id/main_wrapper")) == true) {
					System.out.println("Success");
					String expectedText = "Your request has been successfully received";
					String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/message_tv")).getText();
					takeScreenShot();
					Assert.assertEquals(actualText, expectedText);
					driver.findElement(By.id("com.jazz.jazzworld:id/ok_wrapper_main")).click();
				}
				else
				{
					System.out.println("why i am in else of package sms subscription");
				}
			} catch (Exception e) {
				String expectedText = "Your request has been successfully received";
				String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/message")).getText();
				Assert.assertEquals(actualText, expectedText);
				driver.findElement(By.id("com.jazz.jazzworld:id/ok_wrapper_main")).click();
			}///new try catch end here

		}//sms package subscription end here
		  
		  
		  @Test (priority=27, description = "Side_Menu") // open side menu
		  private void Side_Menu()
		  {
			  driver.findElement(By.id("com.jazz.jazzworld:id/hamburger_icon")).click();
			  String actualText =  driver.findElementsById("com.jazz.jazzworld:id/carbon_groupText").get(5).getText();
			  System.out.println(actualText);
			  String expectedText = "Settings";
			  Assert.assertEquals(actualText, expectedText);
		  }
		  
		  @Test (priority=28, description = "Privacy_Policy") // privacy policy
		  private void Privacy_Policy() throws Exception
		  {
			  driver.findElementsById("com.jazz.jazzworld:id/carbon_groupText").get(5).click();
			  Thread.sleep(3000);
			  driver.findElement(By.id("com.jazz.jazzworld:id/viewPrivacyPolicy")).click();
			  String expectedText = "Privacy Policy";
			  Thread.sleep(3000);
			  String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/toolbar_title")).getText();
			  Assert.assertEquals(actualText, expectedText);
			  driver.navigate().back();
			  
		  }
		  
		  @Test (priority=29, description = "Licenses") // licenses
		  private void Licenses() throws InterruptedException
		  {
			  Thread.sleep(3000);
			  driver.findElement(By.id("com.jazz.jazzworld:id/viewLicenses")).click();
			  Thread.sleep(7000);
			  String expectedText = "Licenses";
			  Thread.sleep(3000);
			  String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/toolbar_title")).getText();
			  Assert.assertEquals(actualText, expectedText);
			  driver.navigate().back();
		  }
		  
		  @Test (priority=30, description = "AboutUs") // about us
		  private void AboutUs() throws InterruptedException
		  {
			  Thread.sleep(3000);
			  driver.findElement(By.id("com.jazz.jazzworld:id/viewAboutUs")).click();
			  String expectedText = "About Us";
			  Thread.sleep(3000);
			  String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/toolbar_title")).getText();
			  Assert.assertEquals(actualText, expectedText);
			  driver.navigate().back();
			  
		  }
		  
		  @Test (priority=31, description = "Term_Condition")  // Term and Conditions
		  private void Term_Condition() throws InterruptedException
		  {
			  Thread.sleep(3000);
			  driver.findElement(By.id("com.jazz.jazzworld:id/viewTermsCondition")).click();
			  String expectedText = "Terms & Conditions";
			  Thread.sleep(3000);
			  String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/toolbar_title")).getText();
			  Assert.assertEquals(actualText, expectedText);
			  driver.navigate().back();
			  
		  }
		  
			  @Test(priority = 32, description = "My_Account") // my account
			  public void My_Account() throws InterruptedException 
			  {

				  Thread.sleep(3000);
				  driver.findElement(By.id("com.jazz.jazzworld:id/viewMyProfile")).click();
				  String expectedText = loginnumber;
				  String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/mobile_number")).getText();
				  Assert.assertEquals(actualText, expectedText);
			  }
			  
			  @Test (priority = 33, description = "Update_Account")
			  public void Update_Account() throws InterruptedException //update username
			  {
				  Thread.sleep(3000);
				  String name = driver.findElement(By.id("com.jazz.jazzworld:id/full_name")).getText();
					driver.findElement(By.id("com.jazz.jazzworld:id/full_name")).clear();
					driver.findElement(By.id("com.jazz.jazzworld:id/full_name")).sendKeys(name+"a");
				  String usernamee = driver.findElement(By.id("com.jazz.jazzworld:id/full_name")).getText();
				  System.out.println(usernamee);
				  driver.findElement(By.id("com.jazz.jazzworld:id/update_button")).click();
				  Thread.sleep(5000);
				  driver.findElement(By.id("com.jazz.jazzworld:id/continues")).click();
				  String expectedText = usernamee;
				  String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/username")).getText();
				  Assert.assertEquals(actualText, expectedText);
			  }
			  
			  
			  @Test (priority=34, description = "Support") // support
			  private void Support() throws InterruptedException
			  {
				  driver.findElement(By.id("com.jazz.jazzworld:id/hamburger_icon")).click();
				  driver.findElementsById("com.jazz.jazzworld:id/carbon_groupText").get(3).click();
				  Thread.sleep(2000);
				   String expectedText = "Support";
				  String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/toolbar_title")).getText();
				  Assert.assertEquals(actualText, expectedText);
			  }
			  
			  @Test (priority=35, description = "FAQs") // Faqs
			  private void FAQs() throws InterruptedException
			  {
				  driver.findElement(By.id("com.jazz.jazzworld:id/faqs_card_view")).click();
				  List<MobileElement> buttons2 = driver.findElements(By.id("com.jazz.jazzworld:id/faqs_main_layout"));
				  buttons2.get(0).click();
				  String expectedText = "FAQs";
				  Thread.sleep(3000);
				  String actualText = driver.findElement(By.id(toolbar_title)).getText();
				  Assert.assertEquals(actualText, expectedText);
				  driver.findElement(By.id(back_button)).click();
				  Thread.sleep(2000);
				  driver.findElement(By.id(back_button)).click();
			  }

			  @Test (priority=36, description = "Submit_Complaint") // Submit complaint
			  private void Submit_Complaint() throws InterruptedException
			  {
				  Thread.sleep(3000);
				  driver.findElement(By.id("com.jazz.jazzworld:id/submit_complaint_card_view")).click();
				  Thread.sleep(3000);
				  List<MobileElement> buttons = driver.findElements(By.id("com.jazz.jazzworld:id/parentWrapper"));
				  buttons.get(0).click();
				  Thread.sleep(3000);
				  List<MobileElement> buttons1 = driver.findElements(By.id("com.jazz.jazzworld:id/parentWrapper"));
				  buttons1.get(0).click();
				  Thread.sleep(3000);
				  List<MobileElement> buttons2 = driver.findElements(By.id("com.jazz.jazzworld:id/parentWrapper"));
				  buttons2.get(0).click();
				  Thread.sleep(3000);
				  driver.findElement(By.id("com.jazz.jazzworld:id/complaintEditText")).sendKeys("Test Complaint");
				  Thread.sleep(3000);
				  driver.findElement(By.id("com.jazz.jazzworld:id/complaint_submit_button")).click();
				  Thread.sleep(3000);
				  driver.findElement(By.id("com.jazz.jazzworld:id/yes")).click();
				  Thread.sleep(3000);
				  
				  try {
						if(driver.findElement(By.id("com.jazz.jazzworld:id/user_name")).isDisplayed())
						{
							
					        String result = driver.findElement(By.id("com.jazz.jazzworld:id/user_name")).getText();
					        System.out.println(result);
							String expectedText = result;
							String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/user_name")).getText();
							Assert.assertEquals(actualText, expectedText);
							takeScreenShot();
							driver.findElement(By.id("com.jazz.jazzworld:id/cross")).click();
							driver.findElement(By.id(back_button)).click();
							Thread.sleep(3000);
							driver.findElement(By.id(back_button)).click();
							Thread.sleep(3000);
							driver.findElement(By.id(back_button)).click();
							Thread.sleep(3000);
							driver.findElement(By.id(back_button)).click();
						}
						else
						{
							System.out.println(complaint_successtext);
							String expectedText = complaint_successtext;
							String actualText = driver.findElement(By.id(complaint_successid)).getText();
							Assert.assertEquals(actualText, expectedText);
							driver.findElement(By.id("com.jazz.jazzworld:id/continue_complaint")).click();
						}
					} catch (Exception e) 
					{
							String expectedText = complaint_successtext;
							String actualText = driver.findElement(By.id(complaint_successid)).getText();
							Assert.assertEquals(actualText, expectedText);
							driver.findElement(By.id("com.jazz.jazzworld:id/continue_complaint")).click();
					}
			  }
			 
			  @Test (priority=37, description = "View_Complaint") // View submitted complaint
			  private void View_Complaint() throws InterruptedException
			  {
				  Thread.sleep(3000);
				  driver.findElement(By.id("com.jazz.jazzworld:id/view_all_complaints")).click();
				  Thread.sleep(3000);
				  try {
						if(driver.findElement(By.id("com.jazz.jazzworld:id/no_data_found")).isDisplayed())
						{
							List<MobileElement> buttons = driver.findElements(By.className("androidx.appcompat.app.ActionBar$Tab"));
							buttons.get(1).click();
							String ticketstatus = driver.findElement(By.id("com.jazz.jazzworld:id/status")).getText();
							String expectedText = ticketstatus;
							String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/status")).getText();
							Assert.assertEquals(actualText, expectedText);
							Thread.sleep(3000);
							System.out.println(".........................................");
							driver.findElement(By.id(back_button)).click();
							System.out.println(".........................................");
						}
				  
						else
						{
							String Ticketnumber = driver.findElement(By.id("com.jazz.jazzworld:id/ticket_no_value")).getText();
							System.out.println("Ticket Number :"+Ticketnumber);
							String expectedText = "Open";
							String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/status")).getText();
							Assert.assertEquals(actualText, expectedText);
						}
				  }
				  catch (Exception e) 
					{
					  String Ticketnumber = driver.findElement(By.id("com.jazz.jazzworld:id/ticket_no_value")).getText();
						System.out.println("Ticket Number :"+Ticketnumber);
						String expectedText = "Open";
						String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/status")).getText();
						Assert.assertEquals(actualText, expectedText);
						driver.findElement(By.id(back_button)).click();
					}
			  }

			  @Test (priority=38, description = "Tax_Certificate") // View tax_certificate
			  private void Tax_Certificate() throws InterruptedException
			  {
				  
				  Thread.sleep(3000);
				  driver.findElement(By.id("com.jazz.jazzworld:id/tax_certificate_cardView")).click();
				  driver.findElement(By.id("com.jazz.jazzworld:id/subscribe_button")).click();
				  Thread.sleep(6000);
				  
				  try {
						if(driver.findElement(By.id("com.jazz.jazzworld:id/failure_title")).isDisplayed())
						{
							String expectedText = insufficient_message;
							String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/user_name")).getText();
							System.out.println("shamoo");
							driver.findElement(By.id(back_button)).click();
							driver.findElement(By.id(back_button)).click();
						}
				  
						else
						{
							driver.findElement(By.id("com.google.android.apps.docs:id/action_add_to_drive")).click();
							Thread.sleep(3000);
							  String expectedText = "Save to Drive";
							  String actualText = driver.findElement(By.id("com.google.android.apps.docs:id/title")).getText();
							  Assert.assertEquals(actualText, expectedText);
							  driver.findElement(By.id("android:id/button2")).click();
							  Thread.sleep(3000);
							  driver.navigate().back();
							  driver.findElement(By.id(back_button)).click();
							  driver.findElement(By.id(back_button)).click();
							  driver.findElement(By.id(back_button)).click();
						}
				  }
				  catch (Exception e) 
					{
					  driver.findElement(By.id("com.google.android.apps.docs:id/action_add_to_drive")).click();
					  Thread.sleep(3000);
					  String expectedText = "Save to Drive";
					  String actualText = driver.findElement(By.id("com.google.android.apps.docs:id/title")).getText();
					  Assert.assertEquals(actualText, expectedText);
					  driver.findElement(By.id("android:id/button2")).click();
					  Thread.sleep(3000);
					  driver.navigate().back();
					  driver.findElement(By.id(back_button)).click();
					  driver.findElement(By.id(back_button)).click();
					  driver.findElement(By.id(back_button)).click();
					}
			
			  }
			  
			  /**********************************************Side Menu Cases End**************************************************/
			  
			  /**********************************************Add Number**************************************************/
			  
			  @Test(priority = 39, description = "Add_Number")
			  public void Add_Number() throws InterruptedException {
				  System.out.println("TEST CASE UNDERDEVELOPMENT");
//				  driver.findElement(By.id("com.jazz.jazzworld:id/add_icon")).click();
//				  driver.findElement(By.id("com.jazz.jazzworld:id/add_number_text")).click();
//				  driver.findElement(By.id("com.jazz.jazzworld:id/phoneNumber")).sendKeys("03012580013");
//				  driver.findElement(By.id("com.jazz.jazzworld:id/fab")).click();
//				  Thread.sleep(4000);
//				  String expectedText = "Continue";
//			      String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/continues")).getText();
//			      Assert.assertEquals(actualText, expectedText);
//			      driver.findElement(By.id("com.jazz.jazzworld:id/continue__wrapper")).click();
			}
			  
			  //CAN BE MANAGE NUMBER
			  
			  /**********************************************Add Number End**************************************************/

			  /*******************************************Switch Number Start*****************************************/
				
				@Test(priority = 40, description = "Switch_Number")
				  public void Switch_Number() throws InterruptedException {
					System.out.println("TEST CASE UNDERDEVELOPMENT");
//					  List<MobileElement> buttons = driver.findElements(By.className("android.view.View"));
//				  buttons.get(2).click();
//				  Thread.sleep(5000);
//				//  driver.findElement(By.id("com.jazz.jazzworld:id/lblMsisdn")).getText();
//				  String expectedText = "03012580013"; //03012620019//03058652178//03058653178//03335459822//03227644119
//			      String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/lblMsisdn")).getText();
//			      Assert.assertEquals(actualText, expectedText);
//			      driver.findElement(By.id("com.jazz.jazzworld:id/add_icon")).click();
//			      List<MobileElement> buttons2 = driver.findElements(By.className("android.view.View"));
//				  buttons2.get(1).click();
						
				}
				  /*******************************************Switch Number End*****************************************/
				  
				/*******************************************Delete Number Start*****************************************/
				 
				@Test(priority = 41, description = "Remove_Number")
				public void Remove_Number(){
					System.out.println("TEST CASE UNDERDEVELOPMENT");
//					driver.findElement(By.id("com.jazz.jazzworld:id/add_icon")).click();
//					driver.findElement(By.id("com.jazz.jazzworld:id/manage_number_text")).click();
//					driver.findElement(By.id("com.jazz.jazzworld:id/delete_icon")).click();
//					driver.findElement(By.id("com.jazz.jazzworld:id/delete")).click();
//					String expectedText = "Successful";
//				      String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/success_title")).getText();
//				      Assert.assertEquals(actualText, expectedText);
//				      driver.findElement(By.id("com.jazz.jazzworld:id/continue__wrapper")).click();
//				      driver.findElement(By.id(back_button)).click();
				      
				}
			  
				  /*******************************************Delete Number End*****************************************/ 
				  
				  
				  /*******************************************Notifications
				 * @throws InterruptedException *****************************************/ 
				  
				  @Test (priority = 42, description = "Notifications")
				  public void Notifications() throws InterruptedException //notifications
				  {  
					 // driver.findElement(By.id(back_button)).click();
					 // driver.navigate().back();
					  driver.findElement(By.id("com.jazz.jazzworld:id/notification_icon")).click();
					  String expectedText = "Notifications";
					  Thread.sleep(3000);
					  String actualText = driver.findElement(By.id(toolbar_title)).getText();
					  Assert.assertEquals(actualText, expectedText);
					  driver.findElement(By.id(back_button)).click();
					  
				  }
				  
				  
				  /*******************************************Notifications End*****************************************/ 
				  
			  
			  /********************************************Scratch Card recharge
			 * @throws InterruptedException *****************************************/
			  
			  @Test (priority = 43, description = "Voucher_Recharge")
			  private void Voucher_Recharge() throws InterruptedException 
			  {
				  Thread.sleep(3000);
				  driver.findElement(By.id("com.jazz.jazzworld:id/dashboard_recharge_button")).click();
				  Thread.sleep(3000);
				  driver.findElement(By.id("com.jazz.jazzworld:id/scratch_card_cardView")).click();
				  Thread.sleep(3000);
				  driver.findElement(By.id("com.jazz.jazzworld:id/scratch_number_et")).sendKeys("67926454660271");
				  Thread.sleep(3000);
				 
				//new try catch start hers
					try {
						
						driver.findElement(By.id("com.jazz.jazzworld:id/action_button")).click();
						if(IsElementPresent(By.id("com.jazz.jazzworld:id/cross")) == true)
						{
							System.out.println("i am in cross");
							String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/user_name")).getText();
							String expected = "The scratch card number you have entered is incorrect, Please try again.";
							  System.out.println(actualText);
							  if(actualText.equalsIgnoreCase(expected))
							  {
								  System.out.println("i am in cross if");
								  Thread.sleep(3000);
								  String expectedText = "The scratch card number you have entered is incorrect, Please try again.";
								  String actualTexts = driver.findElement(By.id("com.jazz.jazzworld:id/user_name")).getText();
								  Assert.assertEquals(actualText, expectedText);
								  driver.findElement(By.id("com.jazz.jazzworld:id/back_img")).click();
								  driver.findElement(By.id("com.jazz.jazzworld:id/back_img")).click();
							  }
							  else
							  {
								  System.out.println("i am in cross else");
								  String expectedText = "help";
								  Thread.sleep(3000);
								  String actualTexts = driver.findElement(By.id("com.jazz.jazzworld:id/user_name")).getText();
								  driver.findElement(By.id("com.jazz.jazzworld:id/back_img")).click();
								  Assert.assertEquals(actualText, expectedText);
							  }
						}
						else
						{
							System.out.println("i am in cross else");
							  String expectedText = "help";
							  Thread.sleep(3000);
							  String actualTexts = driver.findElement(By.id("com.jazz.jazzworld:id/user_name")).getText();
							  driver.findElement(By.id("com.jazz.jazzworld:id/back_img")).click();
							  Assert.assertEquals(actualTexts, expectedText);
						} 
					} catch (Exception e) {
						String expectedText = "Scratch card loaded successfully";
						Thread.sleep(3000);
				        String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/message")).getText();
				        Assert.assertEquals(actualText, expectedText);
				        driver.findElement(By.id("com.jazz.jazzworld:id/continue__wrapper")).click();
				        //driver.findElement(By.id("com.jazz.jazzworld:id/menu_ic_packages")).click();
					}///new try catch end here
			  
			  }  
			  
			  /*******************************************Scratch Card recharge End*****************************************/
			
			  /********************************************Recharge Jazz Cash******************************************/
			  


			  
			  /********************************************Recharge Jazz Cash End*****************************************/

			
			  

				 /************************************************More Service ***************************************************/
				  
				
				@Test (priority =44, description = "MoreServices_Apps") // More Services - Apps Veiw
				private void MoreServices_Apps() throws Exception {
					System.out.println("TEST CASE UNDERDEVELOPMENT");
//					System.out.println("More Service - Secvive Section");
//					driver.findElement(By.id("com.jazz.jazzworld:id/back_img")).click();
//					Thread.sleep(2000);
//					driver.findElement(By.id("com.jazz.jazzworld:id/hamburger_icon")).click();
//					//List<MobileElement> buttons = driver.findElements(By.className("android.widget.CheckedTextView"));
//					//buttons.get(7).click();
//					//servicesScroll();
//					Thread.sleep(2000);
//					driver.findElementsById("com.jazz.jazzworld:id/carbon_groupText").get(4).click();
//					takeScreenShot();
//					String expectedText = "More Services";
//					Thread.sleep(3000);
//			       String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/toolbar_title")).getText();
//			       Assert.assertEquals(actualText, expectedText);
					}
				
				@Test (priority =45, description = "MoreServices_Services" ) // More Services - Services View 
				private void MoreServices_Services() throws InterruptedException {
					System.out.println("TEST CASE UNDERDEVELOPMENT");
//					System.out.println("More Service - Section");
//					//driver.findElement(By.id("com.jazz.jazzworld:id/back_img")).click();
//					//Thread.sleep(2000);
//					List<MobileElement> buttons = driver.findElements(By.id("com.jazz.jazzworld:id/group_imageView_expend"));
//					buttons.get(0).click();
//					Thread.sleep(2000);
//					takeScreenShot();
//					String expectedText = "Auto Reply";
//					List<MobileElement> title = driver.findElements(By.id("com.jazz.jazzworld:id/vas_offer_name"));
//			       String actualText = title.get(0).getText();
//			       Assert.assertEquals(actualText, expectedText);
					}
				
				@Test (priority =46, description = "Service_Subsciption") // More Services - Call Management subscription
				private void Service_Subsciption(){
					System.out.println("TEST CASE UNDERDEVELOPMENT");
//					List<MobileElement> detailbutton = driver.findElements(By.id("com.jazz.jazzworld:id/view_details_label"));
//					detailbutton.get(1).click();
//					System.out.println(toolbar_title);
//					//driver.findElement(By.linkText("Call Management")).click();
//					//List<MobileElement> buttons = driver.findElements(By.className("android.widget.Button"));
//					///buttons.get(0).click();
//					//takeScreenShot();
//					//driver.findElement(By.id("com.jazz.jazzworld:id/subscribe_button")).click();
//					//takeScreenShot();
//					
//					//new try catch start hers
//					try {
//						
//						if(driver.findElement(By.id("com.jazz.jazzworld:id/subscribe_button")).isDisplayed())
//						{
//							driver.findElement(By.id("com.jazz.jazzworld:id/subscribe_button")).click();
//							driver.findElement(By.id("com.jazz.jazzworld:id/subscribe")).click();
//						
//						if(IsElementPresent(By.id("com.jazz.jazzworld:id/failure_title")) == true)
//						{
//					        String expectedText = insufficient_message;
//					        String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/message")).getText();
//					        takeScreenShot();
//					        Assert.assertEquals(actualText, expectedText);
//					        System.out.println(actualText +" more service ");
//					        driver.findElement(By.id("com.jazz.jazzworld:id/ok_wrapper")).click();
//					        driver.findElement(By.id("com.jazz.jazzworld:id/back_img")).click();
//					        Thread.sleep(2000);
//					        driver.findElement(By.id("com.jazz.jazzworld:id/back_img")).click();
//						}
//						else if (IsElementPresent(By.id("com.jazz.jazzworld:id/cross")) == true) {
//							System.out.println("I AM IN CROSSSS");
//							String expectedText = insufficient_message;
//							String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/user_name")).getText();
//							System.out.println("Just clicked cross button against service subscription");
//							driver.findElement(By.id(back_button)).click();
//							Thread.sleep(2000);
//							driver.findElement(By.id(back_button)).click();
//							Assert.assertEquals(actualText, expectedText);
//						}
//						else if (IsElementPresent(By.id("com.jazz.jazzworld:id/message_tv")) == true) {
//							System.out.println("Success");
//							String expectedText = "Your request has been successfully received";
//							String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/message_tv")).getText();
//							takeScreenShot();
//							Assert.assertEquals(actualText, expectedText);
//							driver.findElement(By.id("com.jazz.jazzworld:id/ok_wrapper_main")).click();
//							//driver.findElement(By.id("com.jazz.jazzworld:id/menu_ic_packages")).click();
//						}
//						else
//						{
//							System.out.println("why i am in else of package service subscription");
//						}
//								}
//						else{
//							System.out.println("i am in else of 1st else");
//							String expected =driver.findElement(By.id("com.jazz.jazzworld:id/offer_status")).getText();
//							String actual = "Auto Renewed";
//							Assert.assertEquals(actual, expected);
//							driver.navigate().back();
//							driver.findElement(By.id(back_button)).click();
//							
//						}
//						}catch (Exception e) {
//							System.out.println("i am catch");
//							String expected =driver.findElement(By.id("com.jazz.jazzworld:id/offer_status")).getText();
//							String actual = "Auto Renewed";
//							Assert.assertEquals(actual, expected);
//							driver.navigate().back();
//							driver.findElement(By.id(back_button)).click();
//				        //driver.findElement(By.id("com.jazz.jazzworld:id/menu_ic_packages")).click();
//					}///new try catch end here
					
				}
				
				  /************************************************More Service End***************************************************/
				
				/******************************************UnSubscribe Offer*****************************************/
				
				@Test (priority =47, description = "Unsubsribe_Package") // Un-Subscribe data package Data
				
				private void Unsubsribe_Package() throws Exception {
					System.out.println("TEST CASE UNDERDEVELOPMENT");
//					driver.findElement(By.id("com.jazz.jazzworld:id/dashboard_view_more")).click();
//					
//					//List<MobileElement> buttons = driver.findElements(By.id("com.jazz.jazzworld:id/unsubscribe_button"));
//					//buttons.get(0).click(); //for first offer
//					takeScreenShot();
//					Thread.sleep(2000);
//					
//					try {
//						unsubcribeScroll();
//						System.out.println("I am in 1st if of package unsubscription");
//						
//						if (driver.findElement(By.id("com.jazz.jazzworld:id/deactivate")).isDisplayed())
//						{
//						driver.findElement(By.id("com.jazz.jazzworld:id/deactivate")).click(); 
//						
//						if (IsElementPresent(By.id("com.jazz.jazzworld:id/cross")) == true) {
//							System.out.println("I AM IN CROSSSS");
//							String expectedText = "Error found in pane";
//							String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/user_name")).getText();
//							System.out.println("shamoo");
//							driver.findElement(By.id(back_button)).click();
//							Assert.assertEquals(actualText, expectedText);
//						}
//						else
//						{
//							//System.out.println("Why i  am in else");
//							String expectedText = "Request to unsubscribe successfully received";
//					        String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/message_tv")).getText();
//					        Assert.assertEquals(actualText, expectedText);
//					        driver.findElement(By.id("com.jazz.jazzworld:id/ok_wrapper_main")).click();
//						}
//						}
//						else {
//							System.out.println("Unsubscribe button not found");
//							
//							}
//						
//					} catch (Exception e) {
//						System.out.println("Unsubscribe button not found");
//						driver.findElement(By.id(back_button)).click();
//						/*String expectedText = "Request to unsubscribe successfully received";
//				        String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/message_tv")).getText();
//				        Assert.assertEquals(actualText, expectedText);
//				        driver.findElement(By.id("com.jazz.jazzworld:id/ok_wrapper_main")).click();*/
//					}
			}
				
				/******************************************UnSubscribe Offer End*****************************************/
				
				  /******************************************ReSubscribe Offer *****************************************/

					@Test (priority =48, description = "Resubscribe_Package") // Re-Subscribe data package Data
					private void Resubscribe_Package() throws Exception {
						System.out.println("TEST CASE UNDERDEVELOPMENT");
//						driver.findElement(By.id("com.jazz.jazzworld:id/dashboard_view_more")).click();
//						Thread.sleep(2000);
//						resubcribeScroll();
//						try {
//							
//							if (driver.findElement(By.id("com.jazz.jazzworld:id/subscribe")).isDisplayed()){
//							//List<MobileElement> buttons = driver.findElements(By.id("com.jazz.jazzworld:id/renew_button"));
//							//buttons.get(0).click(); //for first offer
//							takeScreenShot();
//							Thread.sleep(2000);
//							driver.findElement(By.id("com.jazz.jazzworld:id/subscribe")).click(); 
//							
//							if(IsElementPresent(By.id("com.jazz.jazzworld:id/failure_title")) == true)
//							{
//						        String expectedText = insufficient_message;
//						        String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/message")).getText();
//						        takeScreenShot();
//						        Assert.assertEquals(actualText, expectedText);
//						        System.out.println(actualText +" to resubscribe offer ");
//						        driver.findElement(By.id("com.jazz.jazzworld:id/ok_wrapper")).click();
//						        driver.findElement(By.id("com.jazz.jazzworld:id/back_img")).click();
//						        Thread.sleep(2000);
//						        driver.findElement(By.id("com.jazz.jazzworld:id/back_img")).click();
//							}
//							
//							else if (IsElementPresent(By.id("com.jazz.jazzworld:id/cross")) == true) {
//								System.out.println("I AM IN CROSSSS");
//								String expectedText = insufficient_message;
//								String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/user_name")).getText();
//								System.out.println("shamoo");
//								driver.findElement(By.id(back_button)).click();
//								Assert.assertEquals(actualText, expectedText);
//							}
//							else if (IsElementPresent(By.id("com.jazz.jazzworld:id/message_tv")) == true) {
//								System.out.println("Success");
//								String expectedText = "Your request has been successfully received";
//								String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/message_tv")).getText();
//								takeScreenShot();
//								Assert.assertEquals(actualText, expectedText);
//								driver.findElement(By.id("com.jazz.jazzworld:id/ok_wrapper_main")).click();
//								//driver.findElement(By.id("com.jazz.jazzworld:id/menu_ic_packages")).click();
//							}
//							else
//							{
//								System.out.println("Why i am in else");
//								/*String expectedText = "Request to unsubscribe successfully received";
//						        String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/message_tv")).getText();
//						        Assert.assertEquals(actualText, expectedText);
//						        driver.findElement(By.id("com.jazz.jazzworld:id/ok_wrapper_main")).click();*/
//							}}
//
//							else{
//								System.out.println("No offer available for resubscription");
//							}
//							
//						} catch (Exception e) 
//						{
//							System.out.println("No offer available for resubscription");}
//							/*String expectedText = "Your request has been successfully received";
//					        String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/message_tv")).getText();
//					        Assert.assertEquals(actualText, expectedText);
//					        driver.findElement(By.id("com.jazz.jazzworld:id/ok_wrapper_main")).click();*/
//						//}
//			//
			}
					
					/******************************************ReSubscribe Offer End*****************************************/
			
			  /**********************************************************Logout***************************************************/
			
			@Test (priority =49, description = "Logout")
			
			private void Logout() throws Exception {
				System.out.println("TEST CASE UNDERDEVELOPMENT");
//				//driver.findElement(By.id("com.jazz.jazzworld:id/back_img")).click();
//				driver.findElement(By.id("com.jazz.jazzworld:id/hamburger_icon")).click();
//				logoutScroll();
//				driver.findElement(By.id("com.jazz.jazzworld:id/viewLogout")).click();
//				driver.findElement(By.id("com.jazz.jazzworld:id/yes")).click();
//				String expectedText = "Fast Login";
//				String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/login_connect")).getText();
//		        Assert.assertEquals(actualText, expectedText);
				}
			
			/**********************************************************Logout***************************************************/

			 
			
			
			@Test (priority = 3, description = "prepaiddashboard_verifyuser") // Verify Login User
			private void prepaiddashboard_verifyuser() {
				System.out.println("TEST CASE UNDERDEVELOPMENT");
//				String usernumber = driver.findElement(By.id("com.jazz.jazzworld:id/lblMsisdn")).getText();
//				System.out.println("Login User Number :" + usernumber);
//				takeScreenShot();
//				String expectedText = "03058653178";
//		        String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/lblMsisdn")).getText();
//		        Assert.assertEquals(actualText, expectedText);
				}
			
			@Test (priority = 4, description = "prepaiddashboard_usagesection") // Dash board Usage Section
			private void prepaiddashboard_usagesection() {
				System.out.println("TEST CASE UNDERDEVELOPMENT");
//				System.out.println("Usage Section detail is as per below");
//				String userdata = driver.findElement(By.id("com.jazz.jazzworld:id/usage_first_section_remaining_payg")).getText();
//				System.out.println("Remaining Data :" + userdata);
//				String usercalls = driver.findElement(By.id("com.jazz.jazzworld:id/usage_second_section_remaining_payg")).getText();
//				System.out.println("Remaining Calls:" + usercalls);
//				String usersms = driver.findElement(By.id("com.jazz.jazzworld:id/usage_third_section_remaining_payg")).getText();
//				System.out.println("Remaining SMS :" + usersms );
//				String expectedText = driver.findElement(By.id("com.jazz.jazzworld:id/usage_first_section_remaining_payg")).getText();
//		        String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/usage_first_section_remaining_payg")).getText();
//		        Assert.assertEquals(actualText, expectedText);
				}
	  
	public void takeScreenShot() {
		// Set folder name to store screenshots.
		destDir = "screenshots";
		// Capture screenshot.
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Set date format to set It as screenshot file name.
		dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		// Create folder under project with name "screenshots" provided to destDir.
		new File(destDir).mkdirs();
		// Set file name using current date time.
		String destFile = dateFormat.format(new Date()) + ".png";

		try {
			// Copy paste file at destination folder location
			FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private boolean Ispresent(By by) {
		System.out.println("xxxxxxxxxxxxxxxxxxxHUZAIMxxxxxxxxxxxxxxxxxxx");
		try {
			String actualText = driver.findElement(By.id("com.jazz.jazzworld:id/toolbar_title")).getText();
			actualText.equals("Package");
			return true;
		}
		catch (NoSuchElementException e) {

			return false;
		}

	}
	
    private boolean IsElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
    
    public void logoutScroll()throws Exception
    {
        //driver.findElementByAccessibilityId("Views").click();
        AndroidElement list = (AndroidElement) driver.findElement(By.id("com.jazz.jazzworld:id/design_navigation_view"));
        MobileElement listGroup = list
                .findElement(MobileBy
                        .AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                                + "new UiSelector().text(\"Settings\"));"));
     //   assertNotNull(listGroup.getLocation());
        listGroup.click();
    }
    
    public void settingScroll()throws Exception
    {
        //driver.findElementByAccessibilityId("Views").click();
        AndroidElement list = (AndroidElement) driver.findElement(By.id("com.jazz.jazzworld:id/design_navigation_view"));
        MobileElement listGroup = list
                .findElement(MobileBy
                        .AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                                + "new UiSelector().text(\"Settings\"));"));
     //   assertNotNull(listGroup.getLocation());
        listGroup.click();
    }
    
    public void servicesScroll()throws Exception
    {
        //driver.findElementByAccessibilityId("Views").click();
        AndroidElement list = (AndroidElement) driver.findElement(By.id("com.jazz.jazzworld:id/design_navigation_view"));
        MobileElement listGroup = list
                .findElement(MobileBy
                        .AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                                + "new UiSelector().text(\"More Services\"));"));
     //   assertNotNull(listGroup.getLocation());
        listGroup.click();
    }
    
    public void resubcribeScroll()throws Exception
    {
        //driver.findElementByAccessibilityId("Views").click();
        AndroidElement list = (AndroidElement) driver.findElement(By.id("com.jazz.jazzworld:id/usagedetails_recyclerview"));
        MobileElement listGroup = list
                .findElement(MobileBy
                        .AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                                + "new UiSelector().text(\"Re-Subscribe\"));"));
     //   assertNotNull(listGroup.getLocation());
        listGroup.click();
    }
    
	public void unsubcribeScroll()throws Exception
    {
        //driver.findElementByAccessibilityId("Views").click();
        AndroidElement list = (AndroidElement) driver.findElement(By.id("com.jazz.jazzworld:id/usagedetails_recyclerview"));
        MobileElement listGroup = list
                .findElement(MobileBy
                        .AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                                + "new UiSelector().text(\"Unsubscribe\"));"));
     //   assertNotNull(listGroup.getLocation());
        listGroup.click();
    }
   // public void quit(){
    //	driver.quit();
   // };
	
	

}




// /*
//  * Copyright (c) 2018. Ivan Widyan - All Rights Reserved
//  * Unauthorized copying of this file, via any medium is strictly prohibited
//  * Proprietary and confidential
//  * Email: ivanwidyan@yahoo.com
//  */

// package com.testing.example;

// import com.testing.Handler;
// import com.testing.constants.ConfigConstants;
// import com.testing.logging.Log;
// import com.testing.example.constants.ExampleConfigConstants;
// import io.appium.java_client.android.AndroidDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;
// import org.openqa.selenium.remote.CapabilityType;
// import org.openqa.selenium.remote.DesiredCapabilities;
// import org.testng.annotations.*;

// import java.net.URL;
// import java.util.concurrent.TimeUnit;

// public class SetUp {

//     @BeforeSuite
//     public void Init() {
//         Log.Debug("SetUp initiated");
//         Handler.init();
//     }

//     @BeforeTest
//     @Parameters({"platform", "browser", "devicename", "udid", "ip", "port"})
//     public void SetUp(String platform, @Optional String browser, @Optional String devicename,
//                       @Optional String udid, @Optional String ip, @Optional String port) throws Exception {

//         String info = "";

//         Log.Error("Test " + platform);

//         if (platform.equalsIgnoreCase("android")) {
//             if (com.testing.Handler.GetCurrentAppiumDriver() == null) {
//                 if (devicename == null)
//                     devicename = ExampleConfigConstants.DEVICE_NAME;

//                 DesiredCapabilities capabilities = new DesiredCapabilities();
//                 capabilities.setCapability(ConfigConstants.CAPABILITIES_DEVICE_NAME, devicename);
//                 capabilities.setCapability(CapabilityType.BROWSER_NAME, ExampleConfigConstants.BROWSER_NAME);
//                 capabilities.setCapability(ConfigConstants.CAPABILITIES_PLATFORM_NAME, ExampleConfigConstants.PLATFORM_NAME);
//                 capabilities.setCapability(ConfigConstants.CAPABILITIES_APP_PACKAGE, ExampleConfigConstants.APP_PACKAGE);
//                 capabilities.setCapability(ConfigConstants.CAPABILITIES_APP_ACTIVITY, ExampleConfigConstants.APP_ACTIVITY);

//                 if (udid != null)
//                     capabilities.setCapability(ConfigConstants.CAPABILITIES_UDID, udid);

//                 if (ip == null)
//                     ip = ExampleConfigConstants.DEFAULT_IP;

//                 if (port == null)
//                     port = ExampleConfigConstants.DEFAULT_PORT;

//                 String url = "http://" + ip + ":" + port + "/wd/hub";
//                 Handler.SetCurrentAppiumDriver(new AndroidDriver(new URL(url), capabilities));

//                 info = "SetUp Appium Driver for Device = " + com.testing.Handler.GetCurrentAppiumDriver()
//                         .getCapabilities().getCapability(ConfigConstants.CAPABILITIES_DEVICE_NAME);
//                 Log.Debug(info);

//             } else {
//                 info = "Duplicate Appium driver in the same thread";
//                 Log.Error(info);
//             }
//         } else if (platform.equalsIgnoreCase("web")) {
// //            System.setProperty("webdriver.gecko.driver", "/Users/ivanwidyan/Desktop/Ivan-Widyan/Tools/GeckoDriver/geckodriver");
//             System.setProperty("webdriver.gecko.driver", "/lib/geckodriver-v0.21.0/geckodriver.exe");
//             Handler.SetCurrentWebDriver(new FirefoxDriver());

//             Handler.GetCurrentWebDriver().manage().timeouts().implicitlyWait(ConfigConstants.DEFAULT_TIMEOUT, TimeUnit.SECONDS);

//             String url = "https://www.example.com/en";

//             Handler.GetCurrentWebDriver().get(url);
//         }
//     }

//     @AfterTest
//     public void AfterTest() {
//         if (Handler.GetCurrentAppiumDriver() != null) {
//             String info = "Quit Driver for Device = " + com.testing.Handler.GetCurrentAppiumDriver()
//                     .getCapabilities().getCapability(ConfigConstants.CAPABILITIES_DEVICE_NAME);
//             Log.Debug(info);
//             Handler.GetCurrentAppiumDriver().quit();
//         }

//         if (Handler.GetCurrentWebDriver() != null) {
//             String info = "Quit Driver for Web Driver = " + com.testing.Handler.GetCurrentWebDriver();
//             Log.Debug(info);
//             Handler.GetCurrentWebDriver().quit();
//         }
//     }

//     @AfterSuite
//     public void AfterSuite() throws Exception {
//         String info = "Clear Driver Hashmap";
//         Log.Debug(info);
//         Handler.ClearAppiumDriverHashmap();
//         Handler.ClearWebDriverHashmap();
//     }
// }
