import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

//Test Case for 'Playing a Song' through contextual menu
public class ContextClick extends BaseTest {
    
    @Test
    public void playSong() throws InterruptedException{
        provideEmail("khrystal.colon@testpro.io");
        providePassword("t3$t$tudent");
        clickSubmit();
        chooseAllSongsList();
        contextClickFirstSong();
        choosePlayOption();
        Assert.assertTrue(isSongPlaying());
    }

    private void chooseAllSongsList() {
        //Selectors that work
        //li a.songs
        //li a.songs.active
        //a[href='#!/songs']
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
    }

    private void contextClickFirstSong() {
        WebElement firstSongElement = driver.findElement(By.cssSelector(".all-songs tr.song-item:nth-child(1)"));
        actions.contextClick(firstSongElement).perform();
    }

    private void choosePlayOption() {
        //li.playback
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.playback"))).click();
    }

    private boolean isSongPlaying() {
        WebElement soundBarVisualizer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='sound-bar-play']")));
        return soundBarVisualizer.isDisplayed();
    }
}
