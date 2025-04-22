import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public class BaseTest {

    //public WebDriver driver = null;
    public static WebDriver driver = null;

   // public String url;// =  "https://qa.koel.app/";
    public static String url;

    //public WebDriverWait wait = null;
    public static WebDriverWait wait = null;

   // public Actions actions = null;
   public static Actions actions = null;

    @BeforeSuite
    static void setupClass() {
        //WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBroswer(String BaseURL) throws MalformedURLException {
        //Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        //driver = new ChromeDriver(options);
        driver = pickBrowser(System.getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        url = BaseURL;
        navigateToPage();

    }

    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.79:4444";

        switch (browser){
            case "firefox": //gradle clean test -Dbrowser=firefox
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();

            case "MicrosoftEdge": //gradle clean test -Dbrowser=MicrosoftEdge
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(edgeOptions);

            case "grid-edge":  //gradle clean test -Dbrowser=grid-edge
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);

            case "grid-firefox": //gradle clean test -Dbrowser=grid-firefox
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);

            case "grid-chrome": //gradle clean test -Dbrowser=grid-chrome
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions =   new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(chromeOptions);
        }
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    protected void clickSubmit() {
        WebElement submitBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));//driver.findElement(By.cssSelector("button[type='submit']"));
        submitBtn.click();
    }

    protected void providePassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));//driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    protected void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));//driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    protected void navigateToPage() {
        driver.get(url);
    }

    @DataProvider(name="IncorrectLoginData")
    public static Object[][] getDataFromDataProvider(){
        return new Object[][]{
                {"invlaid@testpro.io", "invalidPassword"},
                {"demo@testpro.io", ""},
                {"",""}
        };
    }
}
