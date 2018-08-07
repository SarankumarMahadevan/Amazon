package com.cg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AMAz {
	
	WebDriver driver = null;
	
	@Given("^the user enters the Amazon Webpage$")
	public void the_user_enters_the_Amazon_Webpage() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");   
		//Thread.sleep(1000);
	}

	@When("^the searches for the particular product$")
	public void the_searches_for_the_particular_product() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("teddy");
		driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input")).click();
	}

	@When("^the user enters the viewpage of the product$")
	public void the_user_enters_the_viewpage_of_the_product() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"result_1\"]/div/div[2]/div/div/a/img")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the user adds the product to the cart$")
	public void the_user_adds_the_product_to_the_cart() throws Throwable {
		WebElement s1=driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]"));
		s1.click();
		
	}

	@Then("^the user searches for few more products$")
	public void the_user_searches_for_few_more_products() throws Throwable {
		
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("watch");
		driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input")).click();
	}

	@Then("^the user adds them to the cart$")
	public void the_user_adds_them_to_the_cart() throws Throwable {
		
		
		
		
		driver.findElement(By.xpath("//*[@id=\"result_0\"]/div/div[2]/div/a/img")).click();
		for(String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
	
		
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("shirts");
		driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input")).click();
		driver.findElement(By.xpath("//*[@id=\"result_0\"]/div/div[2]/div/a/img")).click();
		for(String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
		
		
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("sunglasses");
		driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input")).click();
		driver.findElement(By.xpath("//*[@id=\"rot-B017IYSTVW\"]/div/div[1]/a/img[1]")).click();
		for(String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("shoes");
		driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input")).click();
		driver.findElement(By.xpath("//*[@id=\"result_3\"]/div/div[2]/div/a/img")).click();
		for(String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
		
		
		
		
		
		}

	@Then("^the user proceeds to checkout$")
	public void the_user_proceeds_to_checkout() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"hlb-ptc-btn-native\"]")).click();
	}
}
