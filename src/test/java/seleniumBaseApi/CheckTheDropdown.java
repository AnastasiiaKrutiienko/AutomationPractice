package seleniumBaseApi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class CheckTheDropdown {
    private WebDriver chDriver;
    private static final String URL_TO_THE_SITE = "https://formy-project.herokuapp.com/dropdown";
    private static final String XPATH_TO_DROPDOWN_BUTTON = "//button[@class='btn btn-primary dropdown-toggle']";

    @DataProvider (name = "ExpectedUrlsOfDropdownMenuItems")
    public static Object[][] getExpectedUrlOfDropdownMenuItem() {
        return new Object[][]{
                {"1", "https://formy-project.herokuapp.com/autocomplete"},
                {"2", "https://formy-project.herokuapp.com/buttons"},
                {"3", "https://formy-project.herokuapp.com/checkbox"},
                {"4", "https://formy-project.herokuapp.com/datepicker"},
                {"5", "https://formy-project.herokuapp.com/dragdrop"},
                {"6", "https://formy-project.herokuapp.com/dropdown"},
                {"7", "https://formy-project.herokuapp.com/enabled"},
                {"8", "https://formy-project.herokuapp.com/fileupload"},
                {"9", "https://formy-project.herokuapp.com/filedownload"},
                {"10", "https://formy-project.herokuapp.com/keypress"},
                {"11", "https://formy-project.herokuapp.com/modal"},
                {"12", "https://formy-project.herokuapp.com/scroll"},
                {"13", "https://formy-project.herokuapp.com/radiobutton"},
                {"14", "https://formy-project.herokuapp.com/switch-window"},
                {"15", "https://formy-project.herokuapp.com/form"}
        };
    }

    @BeforeClass
    public void openTheMainPage() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exec");
        chDriver = new ChromeDriver();
        chDriver.manage().window().maximize();
    }

    @BeforeMethod
    public void clickOnDropdownButton() {
        chDriver.navigate().to(URL_TO_THE_SITE);
        chDriver.findElement(By.xpath(XPATH_TO_DROPDOWN_BUTTON)).click();
    }

    @Test (dataProvider = "ExpectedUrlsOfDropdownMenuItems")
    public void checkUrlsOfElementsOFDropdownMenuAreEqual(String index, String expectedUrl) {
        chDriver.findElement(By.xpath("html/body/div/div/div/a[" + index + "]")).click();
        String actualUrl = chDriver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Actual and expected URLs aren't equal");
    }

    @AfterMethod
    public void backToDropdownButtonPage() {
        chDriver.navigate().back();
    }

    @AfterClass
    public void closeThePage() {
        chDriver.quit();
    }
}
