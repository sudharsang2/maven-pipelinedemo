package com.Practice12;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoWebShop1 {
	
static WebDriver driver;
	
	@BeforeClass
	  public void launchBrowser() {
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
		 driver = new ChromeDriver(options);
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  }
	
	
  @Test
  public void login() {
	  
	  driver.findElement(By.xpath("//a[contains(text(),'Log in')]")).click();
		driver.findElement(By.id("Email")).sendKeys("davidbilla07@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("David@07");
		driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
		String actual = "davidbilla07@gmail.com";
		WebElement name = driver.findElement(By.linkText("davidbilla07@gmail.com"));
		String expected = name.getText();
		Assert.assertEquals(actual,expected);
  }
  
  @Test(dependsOnMethods = "login")
  public void product() {
	  
	  WebElement computer = driver.findElement(By.xpath("//ul[@class='top-menu']//a[contains(text(),'Computers')]"));
		Actions act = new Actions(driver);
		act.moveToElement(computer).build().perform();
		driver.findElement(By.xpath("(//a[contains(text(),'Desktops')])[1]")).click();
		
		WebElement sortby = driver.findElement(By.id("products-orderby"));
		Select sel = new Select(sortby);
		sel.selectByVisibleText("Price: Low to High");
		driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
  }
  
  @Test(dependsOnMethods = "product")
  public void addToCart() {
	  
	  driver.findElement(By.id("add-to-cart-button-72")).click();
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.id("termsofservice")).click();
		driver.findElement(By.id("checkout")).click();
  }
  
  @Test(dependsOnMethods = "addToCart")
  public void checkOut() {
	  
	  driver.findElement(By.xpath("//input[@value='Continue']")).click();
		driver.findElement(By.xpath("(//input[@value='Continue'])[2]")).click();
		driver.findElement(By.xpath("(//input[@value='Continue'])[3]")).click();
		driver.findElement(By.xpath("(//input[@value='Continue'])[4]")).click();
		driver.findElement(By.xpath("(//input[@value='Continue'])[5]")).click();
		driver.findElement(By.xpath("//input[@value='Confirm']")).click();
		//Thread.sleep(2000);
		 WebElement details = driver.findElement(By.xpath("//ul[@class='details']"));
			String txt = details.getText();
			System.out.println(txt);
			
			driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
  }

  @AfterClass
  public void afterClass() {
	  
	 
		driver.quit();
  }

}
