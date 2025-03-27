import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
public class Homework18 extends BaseTest{

    @Test
    public void playSong() throws InterruptedException {
        navigateToPage();
        provideEmail("khrystal.colon@testpro.io");
        providePassword("t3$t$tudent");
        clickSubmit();
        Thread.sleep(20000);
        clickPlayNextSong();
        clickPlayBtn();

        WebElement pauseBtn = driver.findElement(By.cssSelector("span[data-testid='pause-btn']"));

        Assert.assertTrue(pauseBtn.isDisplayed());
    }

    private void clickPlayBtn() throws InterruptedException {
        WebElement nextSong = driver.findElement(By.cssSelector("span[data-testid='play-btn']"));
        nextSong.click();
        Thread.sleep(2000);
    }

    private void clickPlayNextSong() throws InterruptedException {
        WebElement nextSong = driver.findElement(By.cssSelector("i[data-testid='play-next-btn']"));
        nextSong.click();
        Thread.sleep(2000);
    }
}
