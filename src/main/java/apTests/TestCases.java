
package apTests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
//Selenium Imports
import java.util.logging.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.BrowserType;
///
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestCases {
    RemoteWebDriver driver;

    public TestCases() throws MalformedURLException {
        System.out.println("Constructor: TestCases");

        final DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(BrowserType.CHROME);
        driver = new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"), capabilities);


        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() {
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");
        driver.get("https://www.wikipedia.org/");
        String url=driver.getCurrentUrl();
        if(url.contains("https://www.wikipedia.org/"))
        {
            
            System.out.println("We are in wikipedia");
        }

        System.out.println("end Test case: testCase01");

    }

    public void testCase02() {
        System.out.println("Start Test case: testCase02");
        driver.get("https://www.wikipedia.org/");
       WebElement head =driver.findElement(By.tagName("h1"));
         String wiki=  head.getText();
         if(wiki.contains("Wikipedia"))
         {
            System.out.println("header text contain Wikipedia");
         }

        
         WebElement tandc= driver.findElement(By.xpath(" //footer[@class='footer']/p/small[2]/a"));
         String tc= tandc.getText();
         System.out.println(tc);

         WebElement Policy= driver.findElement(By.xpath(" //footer[@class='footer']/p/small[3]/a"));
         String Pc= Policy.getText();
         System.out.println(Pc);
        System.out.println("end Test case: testCase02");

    }


    public void testCase03() {
        System.out.println("Start Test case: testCase03");
        driver.get("https://www.wikipedia.org/");
       WebElement search= driver.findElement(By.id("searchInput"));
       search.sendKeys("apple");
        WebElement result= driver.findElement(By.xpath("//p[text()='American multinational technology company']"));
          result.click();

          
          WebElement steve= driver.findElement(By.xpath("(//td[@class='infobox-data agent']/div/ul/li/a)[1]"));
          String stext= steve.getText();
          System.out.println(stext);
          System.out.println("end Test case: testCase03");
   
    }


    public void testCase04() {
        System.out.println("Start Test case: testCase04");
        driver.get("https://www.wikipedia.org/");
       WebElement search= driver.findElement(By.id("searchInput"));
       search.sendKeys("microsoft");
        WebElement result= driver.findElement(By.xpath("//p[text()='American multinational technology corporation']"));
          result.click();

          
          WebElement bill= driver.findElement(By.xpath("(//td[@class='infobox-data agent']/div/ul/li/a)[1]"));
          String stext= bill.getText();
          System.out.println(stext);
          bill.click();
          String billpage=driver.getCurrentUrl();
          if(billpage.contains("Bill_Gates"))
          {
            System.out.println("We are in bill's page");
          }

          System.out.println("end Test case: testCase04");
    }
    public void testCase05() {
        System.out.println("Start Test case: testCase05");
        driver.get("https://en.wikipedia.org/");

        WebElement drop= driver.findElement(By.id("vector-main-menu-dropdown"));
        drop.click();
        WebElement about= driver.findElement(By.xpath("//a[@title='Learn about Wikipedia and how it works']"));
        about.click();
        String aburl= driver.getCurrentUrl();
        if(aburl.contains("About"))
        {
            System.out.println("Yes the url contains about");
        }


       
          System.out.println("end Test case: testCase05");
    }



}

