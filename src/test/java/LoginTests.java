import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {
/*
//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);*/
        navigateToPage();
        provideEmail(" ");
        providePassword("   ");
        clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }
    @Test
    public void loginValidEmailPassword(){
        //Added ChromeOptions argument below to fix websocket error
       /* ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));*/

        navigateToPage();
        provideEmail("khrystal.colon@testpro.io");
        providePassword("t3$t$tudent");
        clickSubmit();

          /* String url = "https://qa.koel.app/";
        driver.get(url);

       WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
       emailField.clear();
       emailField.sendKeys("khrystal.colon@testpro.io");

       WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
       passwordField.clear();
       passwordField.sendKeys("t3$t$tudent");

       WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));
       submitBtn.click();*/

       WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));

       //Expeceted Result
        Assert.assertTrue(avatarIcon.isDisplayed());

        driver.quit();
    }

    @Test
    public void loginInvalidEmailValidPassword() throws InterruptedException {
       /* //Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("invalid@testpro.io");

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("t3$t$tudent");

        WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        submitBtn.click();*/
        navigateToPage();
        provideEmail("demo@testpro.io");
        providePassword("t3$t$tudent");
        clickSubmit();
        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(),url);

        driver.quit();

    }

    @Test
    public void loginValidEmailEmptyPassword() throws InterruptedException{
        /*//Added ChromeOptions argument below to fix websocket error
       / ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("khrystal.colon@testpro.io");

        WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        submitBtn.click();*/
        navigateToPage();
        provideEmail("khrystal.colon@testpro.io");
        providePassword(" ");
        clickSubmit();

        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(),url);

        driver.quit();
    }
    @Test
    public void registrationNavigation(){

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);

        WebElement registrationLink = driver.findElement(By.cssSelector("a[href='registration']"));
        registrationLink.click();

        Assert.assertNotEquals(driver.getCurrentUrl(), url);

        driver.quit();
    }

}
