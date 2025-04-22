package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy(css = "input[type='email']") WebElement emailField;
    @FindBy(css = "input[type='password']") WebElement passwordField;
    @FindBy(css = "button[type='submit']") WebElement submitBtnLocator;
    //By emailField = By.cssSelector("input[type='email']");
  //  By passwordField = By.cssSelector("input[type='password']");
    //By submitBtn = By.cssSelector("button[type='submit']");

    public LoginPage provideEmail(String email){
       // findElement(emailField).sendKeys(email);
        emailField.sendKeys(email);
        return this;
    }
    public LoginPage providePassword(String password){
        //findElement(passwordField).sendKeys(password);
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage clickSubmit(){
      //  findElement(submitBtn).click();
      submitBtnLocator.click();
        return this;
    }
    public LoginPage login(){
        provideEmail("khrystal.colon@testpro.io");
        providePassword("t3$t$tudent");
        clickSubmit();
        return this;
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
}
