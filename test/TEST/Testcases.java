/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST;

//import com.github.javafaker.Faker;
import com.github.javafaker.Faker;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author omar shalaby
 */


public class Testcases {

public static String generate_string_num(int n)
    {
        int x ;
        char ch ;
        int num;
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<n;i++)
        {
            x = (int) (Math.random()*100+48);
            if((x>=97 && x<=122))
            {
                ch = ((char)x);
                sb.append(ch);
            }
            else if((x>=48 && x<=57))
            {
                num = Character.getNumericValue(x);
                sb.append(num);
            }
            else
                n++;
        }
        return sb.toString();
        
    }

    public static String generate_string(int n)
    {
        int x ;
        char ch ;
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<n;i++)
        {
            x = (int) (Math.random()*100+48);
            if((x>=97 && x<=122))
            {
                ch = ((char)x);
                sb.append(ch);
            }
            else
                n++;
        }
        return sb.toString();
        
    }
    
    public static String generate_numbers(int n)
    {
        int x ;
        int num;
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<n;i++)
        {
            x = (int) (Math.random()*100+48);
            if((x>=48 && x<=57))
            {
                num = Character.getNumericValue(x);
                sb.append(num);
            }
            else
                n++;
        }
        return sb.toString();
        
    }
    
   
 Faker faker;
   
   
   public String email(){
        String Email=faker.bothify("????####@gmail.com");
       return Email;
   
   }
   
   public String FirstName(){
       String first=faker.letterify("??????");
       return first;
   }
   public String LastName(){
       String last=faker.letterify("????????");
       return last;
   }
   public String password(){
       String password=faker.bothify("????###");
       return password;
   }
    public String Company(){
       String comp_name=faker.letterify("??????");
       return comp_name;
   }
     public String Address(){
       String Address=faker.letterify("????????????????");
       return Address;
   }
      public String city(){
       String city=faker.bothify("????");
       return city;
   }
      public String zip_postal_code(){
       String postal=faker.numerify("#####");
       return postal;
   }
      public String ADD_INFO(){
       String info=faker.letterify("???????????????????????????????????????????????????????????");
       return info;
   }
      public String phone(){
            String phone=faker.numerify("########");
       return phone;

      } 
        WebDriver ChromeBroswerObject;
        JavascriptExecutor jse ;
        
        Actions action ;

        @BeforeTest
	public void openingbrowser() {
                System.setProperty("webdriver.chrome.driver", "F:\\chromedriver_win32\\chromedriver.exe");
		ChromeBroswerObject = new ChromeDriver();
		ChromeBroswerObject.navigate().to("http://automationpractice.com");
		ChromeBroswerObject.manage().window().maximize();
	}
        
        @Test 
	public void homeTitleAssert() {
		String actualPageTitle = ChromeBroswerObject.getTitle();
		String ExpectedPageTitle ="My Store" ;
		Assert.assertEquals(actualPageTitle, ExpectedPageTitle);
	}
        
	@Test (dependsOnMethods={"homeTitleAssert"})
	public void SIGN_IN_link() {
		WebElement sign_link = ChromeBroswerObject.findElement(By.xpath("//a[contains(text(),'Sign in')]"));
                sign_link.click();
              
	}
	
	@Test (dependsOnMethods={"SIGN_IN_link"})
	public void LoginPageTitle () {
		String actualPageTitle = ChromeBroswerObject.getTitle();
		String ExpectedPageTitle ="Login - My Store" ;
		Assert.assertEquals(actualPageTitle, ExpectedPageTitle);
        }
        
       
        @Test (dependsOnMethods={"LoginPageTitle"})
        public void Email_Creation() {
            ChromeBroswerObject.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement email_input=ChromeBroswerObject.findElement(By.id("email_create"));
            WebElement email_button=ChromeBroswerObject.findElement(By.id("SubmitCreate"));
           
            email_input.sendKeys(generate_string(10)+"@gmail.com");
            email_button.click();
            
        }
         
        
       
        @Test(dependsOnMethods={"Email_Creation"})
        public void create_Account() {
            
            ChromeBroswerObject.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement checkbox=ChromeBroswerObject.findElement(By.xpath("//input[@id='id_gender1']"));
            checkbox.click();
            
            WebElement first_namee=ChromeBroswerObject.findElement(By.id("customer_firstname"));
           
	
            first_namee.sendKeys(generate_string(8));
              
            WebElement last_name=ChromeBroswerObject.findElement(By.id("customer_lastname"));
            last_name.sendKeys(generate_string(8));
            WebElement password=ChromeBroswerObject.findElement(By.id("passwd"));
            password.sendKeys(generate_string(8));
            
            WebElement daysDropdown = ChromeBroswerObject.findElement(By.id("days"));
            Select day = new Select(daysDropdown);
            day.selectByValue("25");
            WebElement monthsDropdown = ChromeBroswerObject.findElement(By.id("months"));
            Select month= new Select(monthsDropdown);
            month.selectByValue("2");
            WebElement yearDropdown = ChromeBroswerObject.findElement(By.id("years"));
            Select year = new Select(yearDropdown);
            year.selectByValue("1999");
             
            
            WebElement newsletter_checkbox = ChromeBroswerObject.findElement(By.id("newsletter"));
            newsletter_checkbox.click();
            WebElement offers_checkbox = ChromeBroswerObject.findElement(By.id("optin"));
            offers_checkbox.click();
            WebElement  Address_company = ChromeBroswerObject.findElement(By.id("company"));
            Address_company.sendKeys(generate_string(15));
            WebElement  address1 = ChromeBroswerObject.findElement(By.id("address1"));
            address1.sendKeys(generate_string(15));
            WebElement  address2 = ChromeBroswerObject.findElement(By.id("address2"));
            address2.sendKeys(generate_string(15));
            
            WebElement  city = ChromeBroswerObject.findElement(By.id("city"));
            city.sendKeys(generate_string(8));
            WebElement stateDropdown = ChromeBroswerObject.findElement(By.id("id_state"));
            Select State= new Select(stateDropdown);
            State.selectByValue("2");
            
            WebElement postalcode = ChromeBroswerObject.findElement(By.id("postcode"));
            postalcode.sendKeys(generate_numbers(5));
            WebElement CountryDropdown = ChromeBroswerObject.findElement(By.id("id_country"));
            Select countryDropdown= new Select(CountryDropdown);
            countryDropdown.selectByValue("21");
            
            WebElement Addtional_info = ChromeBroswerObject.findElement(By.id("other"));
            Addtional_info.sendKeys(generate_string(20));
            
            WebElement phone=ChromeBroswerObject.findElement(By.id("phone"));
            phone.sendKeys(generate_numbers(8));
            WebElement phone_mobile=ChromeBroswerObject.findElement(By.id("phone_mobile"));
            phone_mobile.sendKeys(generate_numbers(10));
            WebElement Address_alias=ChromeBroswerObject.findElement(By.id("alias"));
            
            Address_alias.sendKeys(generate_string(15));
            WebElement Sumbit_button=ChromeBroswerObject.findElement(By.id("submitAccount"));
            Sumbit_button.click();

    
   
}
        
        /*@Test (dependsOnMethods={"create_Account"})
	public void MyAccountPage () {
		String actualPageTitle = ChromeBroswerObject.getTitle();
		String ExpectedPageTitle ="My account - My Store" ;
		Assert.assertEquals(actualPageTitle, ExpectedPageTitle);
        }
*/
        
        @Test (dependsOnMethods={"create_Account"})
	public void go_to_shopping() {
		WebElement home_link=ChromeBroswerObject.findElement(By.xpath("//div[@id='header_logo']/a"));
                home_link.click();
        }
        
        
        @Test (dependsOnMethods={"go_to_shopping"})
	public void Shopping_assertion () { 
		String actualPageTitle = ChromeBroswerObject.getTitle();
		String ExpectedPageTitle ="My Store" ;
		Assert.assertEquals(actualPageTitle, ExpectedPageTitle);
        }
        
        @Test (dependsOnMethods={"Shopping_assertion"})
	public void select_item() {
                
                jse = (JavascriptExecutor)ChromeBroswerObject;
                jse.executeScript("window.scrollBy(0,750)", "");
               
		
                action=new Actions(ChromeBroswerObject);
                action.moveToElement(ChromeBroswerObject.findElement(By.xpath("//ul[@id='homefeatured']/li[position() = 1]"))).build().perform();
                WebElement item1=ChromeBroswerObject.findElement(By.xpath("//ul[@id='homefeatured']/li[position() = 1]//a[@title='Add to cart']"));
                item1.click();
              
                WebElement continue_shopping=ChromeBroswerObject.findElement(By.xpath("//div[@class='button-container']//span[@title='Continue shopping']"));
                continue_shopping.click();
                action.moveToElement(ChromeBroswerObject.findElement(By.xpath("//ul[@id='homefeatured']/li[position() = 2]"))).build().perform();
                WebElement item2=ChromeBroswerObject.findElement(By.xpath("//ul[@id='homefeatured']/li[position() = 2]//a[@title='Add to cart']"));
                item2.click();
          
               WebElement proceed=ChromeBroswerObject.findElement(By.xpath(" //span[contains(text(),'Proceed to checkout')]"));
                proceed.click();
                
                
             
        }
        
       
        
         
        @Test (dependsOnMethods={"select_item"})
        public void checkout_summary() {
                jse = (JavascriptExecutor)ChromeBroswerObject;
                jse.executeScript("window.scrollBy(0,1000)", "");
                WebElement proceedtocheckout=ChromeBroswerObject.findElement(By.xpath("//p//a[@title='Proceed to checkout']"));
                proceedtocheckout.click();
                
            
        }
       
        @Test (dependsOnMethods={"checkout_summary"})
        public void checkout_address() {
            jse = (JavascriptExecutor)ChromeBroswerObject;
            jse.executeScript("window.scrollBy(0,1000)","");
            WebElement Sumbit_button=ChromeBroswerObject.findElement(By.name("message"));
            Sumbit_button.sendKeys(generate_string(20));
            WebElement proceedtocheckout=ChromeBroswerObject.findElement(By.name("processAddress"));
            proceedtocheckout.click();
            
        }
        
        @Test (dependsOnMethods={"checkout_address"})
        public void checkout_shipping() {
            jse = (JavascriptExecutor)ChromeBroswerObject;
            jse.executeScript("window.scrollBy(0,1000)", "");
            WebElement checkbox=ChromeBroswerObject.findElement(By.name("cgv"));
            checkbox.click();
            WebElement proceedtocheckout=ChromeBroswerObject.findElement(By.name("processCarrier"));
            proceedtocheckout.click();
                
            
        }
         @Test (dependsOnMethods={"checkout_shipping"})
        public void checkout_payment() {
             jse = (JavascriptExecutor)ChromeBroswerObject;
                jse.executeScript("window.scrollBy(0,800)", "");
	WebElement PAYLINK=ChromeBroswerObject.findElement(By.xpath("//a[@title='Pay by check.']"));
        PAYLINK.click();
            
            
        }
         @Test (dependsOnMethods={"checkout_payment"})
        public void checkout_CONFIRM() {
             jse = (JavascriptExecutor)ChromeBroswerObject;
                jse.executeScript("window.scrollBy(0,800)", "");
            WebElement PAYLINK=ChromeBroswerObject.findElement(By.xpath("//span[contains(text(),'I confirm my order')]"));
        PAYLINK.click();
            
            
        }
        
      @Test (dependsOnMethods={"checkout_CONFIRM"})
      public void Logout(){
          WebElement sign_out_link=ChromeBroswerObject.findElement(By.xpath("//a[@title='Log me out']"));
          sign_out_link.click();
      }
      
      @AfterTest
      public void closing_browser(){
          ChromeBroswerObject.close();
      }
}
