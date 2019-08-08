package com.StepDefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class StepDefs {
	
	public WebDriver driver;
	String title;
	@Given("user is on loginpage")
	public void user_is_on_loginpage() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\s.wankhede\\Desktop\\SeleniumDrivers\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://localhost:7744/TestMeApp/login.htm");
		
		
	}

	@When("user enters valid username")
	public void user_enters_valid_username() {

		WebElement uname=driver.findElement(By.name("userName"));
		uname.sendKeys("Lalitha");
		
	}

	@When("user enters valid password")
	public void user_enters_valid_password() throws InterruptedException {
		
		WebElement pwd=driver.findElement(By.name("password"));
		pwd.sendKeys("password123");
		
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {

		WebElement login=driver.findElement(By.name("Login"));
		login.click();
		
	}

	@Then("user is redirected to homepage")
	public void user_is_redirected_to_homepage() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals("Home", driver.getTitle());
		
		driver.close();
		
	}
	
	@When("^user enters valid (\\w+) and valid (\\w+)$")
	public void user_enters_valid_lalitha_and_valid_password(String uname, String pass) {
	    
		WebElement username=driver.findElement(By.name("userName"));
		WebElement password=driver.findElement(By.name("password"));
		this.title=uname;
		username.sendKeys(uname);
		password.sendKeys(pass);
	}

	@When("clicks login button")
	public void clicks_login_button() {
	   driver.findElement(By.name("Login")).click();
	}

	@Then("user is shown homepage")
	public void user_is_shown_homepage() throws InterruptedException {
	   if(title.equalsIgnoreCase("admin")) {
		   Assert.assertEquals("Admin Home", driver.getTitle());
	   }else {
		   Assert.assertEquals("Home", driver.getTitle());
	   }
		
	   Thread.sleep(2000);
		driver.close();
	}

}
