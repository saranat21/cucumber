package com.flipkart.stepdefinition ;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MobileSearchSteps  {

	static WebDriver driver;
	static String parentUrl;

	@Given("user need to lauch flipkart application")
	public void user_need_to_lauch_flipkart_application() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Given("user needs to enter the credential details and click on login")
	public void user_needs_to_enter_the_credential_details_and_click_on_login() {

		try {
			WebElement button = driver.findElement(By.xpath("//button[text()='✕']"));
			button.isDisplayed();
			button.click();
		} catch (Exception e) {
			System.out.println("pop messeage is not displayed");
		}
	}

	@When("user needs to search for mobile in search box")
	public void user_needs_to_search_for_mobile_in_search_box() {

		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("realme", Keys.ENTER);
	}

	@When("user needs to select the required mobile phone")
	public void user_needs_to_select_the_required_mobile_phone() throws Throwable {

		driver.findElement(By.xpath("//div[text()='realme Narzo 50A (Oxygen Blue, 64 GB)']")).click();
		Thread.sleep(1000);

	}

	@When("user needs to place the selected mobile in add to cart")
	public void user_needs_to_place_the_selected_mobile_in_add_to_cart() throws InterruptedException {

		parentUrl = driver.getWindowHandle();
		Set<String> childUrl = driver.getWindowHandles();
		for (String child : childUrl) {
			if (!parentUrl.equals(child)) {
				driver.switchTo().window(child);

				Thread.sleep(1000);
				
			}
		}

	}

	@Then("user will be navigate into add to cart window")
	public void user_will_be_navigate_into_add_to_cart_window() throws Throwable {

		driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();

		Thread.sleep(1000);

	}

	@Then("user needs to check the order update")
	public void user_needs_to_check_the_order_update() throws Throwable  {

		driver.switchTo().window(parentUrl);

		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[text()='Cart']")).click();
		
	
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Place Order']")).isDisplayed());
		
		System.out.println("assert is running");
		try {
			WebElement button = driver.findElement(By.xpath("//button[text()='✕']"));
			button.isDisplayed();
			button.click();
		} catch (Exception e) {
			System.out.println("pop messeage is not displayed");

		}

	}

	@Then("user needs to check the order update and place the order")
	public void user_needs_to_check_the_order_update_and_place_the_order() {

		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Place Order']")).isDisplayed());
		System.out.println(" why assert is not running");
		driver.quit();
	}
}
