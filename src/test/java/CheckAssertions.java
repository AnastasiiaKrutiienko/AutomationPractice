import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;


public class CheckAssertions {

    @Test
    public void checkAssertionString() {
        String actual = "GitHub";
        String expected = "Github";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void checkAssertionStringWithMessage() {
        String actual = "GitHub";
        String expected = "github";
        Assert.assertEquals(actual, expected, "These strings are not equals");
    }

    @Test
    public void checkAssertionBoolean() {
        boolean actual = true;
        boolean expected = true;
        Assert.assertEquals(actual, expected,"Actual and expected results are not equals");
    }

    @Test
    public void checkAssertionCollections() {
        ArrayList<Boolean> firstBooleanArrayList = new ArrayList<Boolean>();
        ArrayList<Boolean> secondBooleanArrayList = new ArrayList<Boolean>();

        firstBooleanArrayList.add(true);
        firstBooleanArrayList.add(false);

        secondBooleanArrayList.add(true);
        secondBooleanArrayList.add(false);

        Assert.assertEquals(firstBooleanArrayList, secondBooleanArrayList, "Collections are not equals");
    }

    @Test
    public void checkAssertTrueAndFalse() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exec");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.youtube.com/");

        Assert.assertTrue(chromeDriver.getTitle().startsWith("You"), "The title doesn't start with You");
        Assert.assertFalse(chromeDriver.getTitle().startsWith("Tube"), "The title starts with Tube");
    }

}
