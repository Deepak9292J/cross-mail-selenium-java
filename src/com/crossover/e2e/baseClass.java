package com.crossover.e2e;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class baseClass {
	
	public WebDriver driver ;
	public Properties prop;
	
	public baseClass()
	{
		super();
	}
	
	@BeforeSuite(alwaysRun=true)
	public WebDriver setUp() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Manual Installs\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		prop = new Properties();
		prop.load(new FileReader(new File("test.properties")));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver ;
	}	
	
	public void login() throws InterruptedException
	{
		driver.get("https://mail.google.com/");
        WebElement userElement = driver.findElement(By.id("identifierId"));
        userElement.sendKeys(prop.getProperty("username"));
        driver.findElement(By.id("identifierNext")).click();
        Thread.sleep(1000);
        WebElement passwordElement = driver.findElement(By.name("password"));
        passwordElement.sendKeys(prop.getProperty("password"));
        Thread.sleep(2000);
        driver.findElement(By.id("passwordNext")).click();
        Thread.sleep(1000);
	}
	

}
