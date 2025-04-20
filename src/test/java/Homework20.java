import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest{
    @Test
    public void deletePlaylist() throws InterruptedException{
        String expectedPlaylistDeletedMsg = "Deleted playlist \"Test Pro Playlist.\"";

        provideEmail("khrystal.colon@testpro.io");
        providePassword("t3$t$tudent");
        clickSubmit();
        openPlaylist();
        clickDeletePlaylistBtn();
        Assert.assertEquals(getDeletedPlaylistMsg(), expectedPlaylistDeletedMsg);
    }

    private void clickDeletePlaylistBtn() throws InterruptedException {
        WebElement deletePlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-delete-playlist")));
        deletePlaylist.click();
        Thread.sleep(2000);
    }

    private String getDeletedPlaylistMsg() {
        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMsg.getText();
    }

    private void openPlaylist() {
        WebElement emptyPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        emptyPlaylist.click();
    }
}
