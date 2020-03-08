package seleniumBaseApi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckTheBoxes {
    private WebDriver chDriver;

    @BeforeClass
    public void openTheMainPage() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exec");
        chDriver = new ChromeDriver();
        chDriver.get("https://formy-project.herokuapp.com/checkbox");
    }

    @DataProvider (name = "CssSelectorsForCheckboxes")
    public static Object[][] getCssSelectorsForCheckboxes() {
        return new Object[][]{
                {"#checkbox-1"},
                {"#checkbox-2"},
                {"#checkbox-3"}
        };
    }

    @DataProvider (name = "XPathSelectorsForCheckboxes")
    public static Object[][] getXPathSelectorsForCheckboxes() {
        return new Object[][]{
                {"//*[@id ='checkbox-1']"},
                {"//*[@id ='checkbox-2']"},
                {"//*[@id ='checkbox-3']"}
        };
    }

    @Test(dataProvider = "CssSelectorsForCheckboxes")
    public void clickOnCheckboxesUsingCSSSelector(String CssSelectorsForCheckboxes) {
        chDriver.findElement(By.cssSelector(CssSelectorsForCheckboxes)).click();
    }

    @Test(dataProvider = "XPathSelectorsForCheckboxes")
    public void clickOnCheckboxesUsingXPath(String XPathSelectorsForCheckboxes) {
        chDriver.findElement(By.xpath(XPathSelectorsForCheckboxes)).click();
    }

    @AfterClass
    public void closeThePage() {
        chDriver.quit();
    }
}
