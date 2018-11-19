package com.crossover.e2e;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class e2e extends baseClass {
	
	@Test
	public void testSendEmail() throws InterruptedException, IOException
	{
		driver = setUp();
        login();
        WebElement composeElement = driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']"));
        composeElement.click();
        WebElement toField = driver.findElement(By.xpath("//textarea[@aria-label='To']"));
        toField.sendKeys("deepak1001jindal@gmail.com");
        WebElement subjectInput = driver.findElement(By.xpath("//input[@name='subjectbox']"));
        subjectInput.sendKeys("crossover subject");
        WebElement bodyInput = driver.findElement(By.xpath("//div[@aria-label='Message Body']"));
        bodyInput.sendKeys("crossover body");
        WebElement moreButton = driver.findElement(By.xpath("//div[@class='J-JN-M-I J-J5-Ji Xv L3 T-I-ax7 T-I']"));
        moreButton.click();
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("//div[@class='J-Ph J-N']"))).build().perform();
        Thread.sleep(3000);
        WebElement searchLabelInput = driver.findElement(By.xpath("//div[@class='J-M-JJ asg']//input[@type='text']"));
        searchLabelInput.sendKeys("Social");
        Thread.sleep(2000);
        WebElement selectSocialLabel = driver.findElement(By.xpath("//div[@title='Social']"));
        selectSocialLabel.click();
        driver.findElement(By.xpath("//*[@role='button' and text()='Send']")).click();
        Thread.sleep(5000);
	}
	
	
	@Test(enabled=true)
	public void verifyMailContents() throws InterruptedException, IOException
	{
		
		driver = setUp();
        login();
        driver.findElement(By.xpath("//div[@class='aAy aKe-aLe']")).click();
        driver.findElement(By.xpath("//span[@id=':mo']")).click();
        List<WebElement> unreademeil = driver.findElements(By.xpath("//*[@class='zF']"));
        String mailer = "me";
        for(int i=0; i< unreademeil.size();i++)
        {
        	if(unreademeil.get(i).getText().equals(mailer)){
        		assertTrue(unreademeil.get(i).getText().equals(mailer));
        		unreademeil.get(i).click();
        		break;
        	}
        }
        Thread.sleep(2000);
        String subjectText = driver.findElement(By.xpath("//div[@class='ha']")).getText();
        assertTrue(subjectText.contains("crossover subject"));
        String bodyText = driver.findElement(By.xpath("//div[@dir='ltr'][contains(text(),'crossover body')]")).getText();
        assertTrue(bodyText.contains("crossover body"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
