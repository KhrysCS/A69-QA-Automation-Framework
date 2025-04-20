import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.List;

//Test case to assert that a playlist has a number of songs
public class CountPlaylistSongs extends BaseTest {

    @Test
    public void countSongsInPlaylist(){
        //Prerequisites - user created playlist named "Playlist Demo" with at least 1 song
        provideEmail("khrystal.colon@testpro.io");
        providePassword("t3$t$tudent");
        clickSubmit();

        choosePlaylistByName("Playlist Demo");
        displayAllSongs();
        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongs())));
        //verifies if the playlist details song count is equal to the retrieved number of songs
    }

    private void choosePlaylistByName(String playlistDemo) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'"+playlistDemo+"')]"))).click();
    }
    private int countSongs() {//counts songs inside playlist
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("section#playlistWrapper td.title"))).size();
        // driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();
    }
    private String getPlaylistDetails() {//retrieves playlist details from playlist header(displays number of songs in playlist)
        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
    }
    private void displayAllSongs() {//prints all songs inside the playlist - for demo purposes
        List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        System.out.println("Number of songs found: " + countSongs());
        for(WebElement e : songList){
            System.out.println(e.getText());
        }
    }


}

