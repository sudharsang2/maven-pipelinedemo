package com.Practice12;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class OrangeHrmLocation {
	WebDriver driver;
	@BeforeClass
	public void Setup() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		 driver = new ChromeDriver(options);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	@Test
	public void Login() {
	driver.findElement(By.name("username")).sendKeys("Admin");
	driver.findElement(By.name("password")).sendKeys("admin123");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	@Test (dependsOnMethods = "Login")
	public void AddLocation() throws InterruptedException, AWTException {
		
	driver.findElement(By.xpath("//span[text()='Admin']")).click();
	driver.findElement(By.xpath("//span[text()='Organization ']")).click();
	driver.findElement(By.xpath("//a[text()='Locations']")).click();
	driver.findElement(By.xpath("(//button[@type=\"button\"])[4]")).click();

	driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys("DavidBilla");
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]")).sendKeys("chinnaovulapuram");
	//driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[4]")).sendKeys("Theni");
	//driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[5]")).sendKeys("625515");
	WebElement country = driver.findElement(By.xpath("//div[@class='oxd-select-text-input']"));
	country.click();
	Robot rob = new Robot();
	rob.keyPress(KeyEvent.VK_DOWN);
	rob.keyRelease(KeyEvent.VK_DOWN);
	rob.keyPress(KeyEvent.VK_DOWN);
	rob.keyRelease(KeyEvent.VK_DOWN);

	country.click();

	//driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[6]")).sendKeys("9150410956");
	//driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[7]")).sendKeys("9150410956");
	//driver.findElement(By.xpath("//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']")).sendKeys("101, North Street");
	//driver.findElement(By.xpath("(//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical'])[2]")).sendKeys("Sample Note");

	driver.findElement(By.xpath("//button[@type='submit']")).click();
	//Thread.sleep(3000);
	}
	
	@AfterClass
	public void tearDown() {
	System.out.println("Test Passed");
	driver.quit();
	}
}


