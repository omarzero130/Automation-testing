/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 *
 * @author omar shalaby
 */
public class NewEmptyTestNGTest {
    
    /**
     *
     */
    public NewEmptyTestNGTest() {
    }
   // Faker faker;
    
   WebDriver ChromeBroswerObject;
	
    /**
     *
     */
    @BeforeTest
	public void openingbrowser() {
		System.setProperty("webdriver.chrome.driver","F:\\chromedriver_win32\\chromedriver.exe");
		ChromeBroswerObject = new ChromeDriver();
		ChromeBroswerObject.navigate().to("http://www.google.com");
		ChromeBroswerObject.manage().window().maximize();
	}

    /**
     *
     */
    @Test (dependsOnMethods={"AssertPageTitle"})
	public void GoogleSearch() {
		WebElement SearchBox = ChromeBroswerObject.findElement(By.name("q"));
		SearchBox.sendKeys("Selenium");
		SearchBox.sendKeys(Keys.ENTER);
	}

    /**
     *
     */
    @Test (priority = 1)
	public void AssertPageTitle () {
		String actualPageTitle = ChromeBroswerObject.getTitle();
		String ExpectedPageTitle ="Google" ;
		Assert.assertEquals(actualPageTitle, ExpectedPageTitle);
	}

    /**
     *
     */
    @AfterTest
	public void CloseBrowser() {
		ChromeBroswerObject.close();
		
	}
}
