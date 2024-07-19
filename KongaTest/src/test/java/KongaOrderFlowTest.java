import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Driver;

import static org.openqa.selenium.By.*;

public class KongaOrderFlowTest {
    //import selenium WebDriver
    private WebDriver driver;


    @BeforeTest
    public void SetUp() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //open your Chrome browser
        driver = new ChromeDriver();
        //maximize browser window
        driver.manage().window().maximize();

    }

    @Test(priority = 0)
    public void OpenkongaUrl() throws InterruptedException {
        //opening of konga website
        //input konga URL (https://www.konga.com)
        driver.get("https://konga.com");
        System.out.println("Open Konga Url");

    }

    @Test(priority = 1)
    private void SuccessfulSignIn() throws InterruptedException {
        //successfully signin
        Thread.sleep(10000);
        //Click on the Login/Signup button
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(5000);
        //locate enter email address or phone number field and enter email address
        driver.findElement(xpath("//*[@id=\"username\"]")).sendKeys("lordjoneszy@gmail.com");
        //locate password field and input password
        driver.findElement(xpath("//*[@id=\"password\"]")).sendKeys("Admin12345");
        //locate login button and click to signin
        driver.findElement(xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        //wait for home page to load
        Thread.sleep(10000);
        //verify home page has loaded by locating my account button
        WebElement myaccountButton = driver.findElement(xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/a/span"));
        Thread.sleep(5000);
        System.out.println(myaccountButton.getText());

    }

    @Test(priority = 2)
    public void AddToCart() throws InterruptedException {
        Thread.sleep(5000);
        //successfully add product to cart
        // From the Categories, click on "Computers and Accessories"
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        // locate and Click on the Laptop SubCategory
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/label/span")).click();
        Thread.sleep(5000);
        // locate and Click on the Apple MacBooks
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/ul/li[1]/a/label/span")).click();
        Thread.sleep(5000);
        // locate (Pro With M1 Pro Chip - 1TB HDD) and Add item to the cart by clicking add to cart button
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[1]/div/div/div[3]/form/div[2]/button")).click();
        Thread.sleep(10000);
        // verify the product is in the cart
        WebElement cartitem = driver.findElement(xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]"));
        cartitem.click();
        System.out.println(cartitem.getText());
    }



    @Test(priority = 3)
    public void Checkout() throws InterruptedException {
        //successfully checkout product
        Thread.sleep(10000);
        //locate checkout button and click
        driver.findElement(xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
        Thread.sleep(10000);
        System.out.println("CheckOut");


    }


    @Test(priority = 4)
    public void AddAddress() throws InterruptedException {
        //locate and click on the add address button
        driver.findElement(xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
        Thread.sleep(10000);
        //locate the first name field and enter first name
        driver.findElement(xpath("//*[@id=\"firstname\"]")).sendKeys("Jonah");
        //locate the last name field and enter last name
        driver.findElement(xpath("//*[@id=\"lastname\"]")).sendKeys("Agwuncha");
        //locate the phone number field and enter phone number
        driver.findElement(xpath("//*[@id=\"telephone\"]")).sendKeys("09039230556");
        //locate street address field and input street address
        driver.findElement(xpath("//*[@id=\"street\"]")).sendKeys("13 Abudu street, ogudu");
        //locate city field and input city
        driver.findElement(xpath("//*[@id=\"city\"]")).sendKeys("Ogudu");
        //locate state field and input state
        driver.findElement(xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/form/div[6]/div/div/select")).sendKeys("Lagos");
        Thread.sleep(10000);
        //locate LGA field and input LGA
        driver.findElement(name("areaId")).sendKeys("Kosofe");
        //locate and click on the save changes button
        driver.findElement(xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/form/div[8]/div[1]/button")).click();
        Thread.sleep(10000);
        //select added address to use
        WebElement AddedAddress = driver.findElement(xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/div[2]/div/form/button"));
        AddedAddress.click();
        Thread.sleep(10000);
        //locate use address button and click
        driver.findElement(xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
        Thread.sleep(5000);
        //verify address was added successfully
        WebElement Address = driver.findElement(xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/p[2]"));
        System.out.println("AddAddress");


    }
    @Test(priority = 5)
    public void SelectCardMethod() throws InterruptedException {
        Thread.sleep(10000);
        //locate pay now and click
        driver.findElement(xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
        //locate continue to payment button
        driver.findElement(xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        Thread.sleep(10000);
        //Switch to the iframe that displays payment modal
        WebElement iframe = driver.findElement(xpath("//*[@id=\"kpg-frame-component\"]"));
        driver.switchTo().frame(iframe);
        Thread.sleep(10000);
        //locate card payment method and select
        driver.findElement(className("Card")).click();
        System.out.println("Select Card Method");
        Thread.sleep(10000);


    }

    @Test(priority = 6)
    public void InputInvalidCardDetails() throws InterruptedException {
        //5. input invalid card details
        //locate card number field and enter invalid card number
        driver.findElement(id("card-number")).sendKeys("1234567890123");
        Thread.sleep(5000);
        //locate date field and enter invalid expiry date
        driver.findElement(id("expiry")).sendKeys("1215");
        Thread.sleep(5000);
        //locate cvv field and enter invalid cvv
        driver.findElement(id("cvv")).sendKeys("456");
        Thread.sleep(5000);
        System.out.println("input card details");
        //locate card pin field and click
        driver.findElement(By.xpath("//*[@id=\"card-pin-new\"]")).click();
        Thread.sleep(5000);
        //locate button 1 on password keypad and click
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[1]")).click();
        Thread.sleep(5000);
        //locate button 2 on password keypad and click
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[2]")).click();
        Thread.sleep(5000);
        //locate button 3 on password keypad and click
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[3]")).click();
        Thread.sleep(5000);
        //locate button 4 on password keypad and click
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[4]")).click();
        Thread.sleep(5000);
        //locate paynow button and click
        driver.findElement(By.xpath("//*[@id=\"validateCardForm\"]")).click();
        Thread.sleep(5000);
        System.out.println("input card pin");

    }


    @Test(priority = 7)
    public void ErrorMesage() throws InterruptedException {
        // Print out the error message: Invalid card number
        WebElement errorMessage = driver.findElement(id("card-number_unhappy"));
        //print out error message
        System.out.println(errorMessage.getText());
        Thread.sleep(5000);
    }


    @Test(priority = 8)
    public void ClosePaymentModal() throws InterruptedException {
        //locate x button on payment modal and click to close modal
        driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[1]/aside")).click();
        Thread.sleep(5000);
        System.out.println("Close Payment Modal");
    }



    @Test(priority = 9)
    public void ReturnToDefaultFrame() throws InterruptedException {
        //switch back to default frame
        driver.switchTo().defaultContent();
        System.out.println("restore default content");

    }
    @AfterTest
    public void tearDown() {
        // Quit the browser
        if (driver != null) {
            driver.quit();
        }

    }
}









