package seleniumBaseApi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckTheButtons {
    private WebDriver chDriver;

    @BeforeClass
    public void openTheMainPage() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exec");
        chDriver = new ChromeDriver();
        chDriver.get("https://formy-project.herokuapp.com/buttons");
    }

    @AfterClass
    public void closeThePage() {
        chDriver.quit();
    }

    @Test(priority = 1)
    public void clickOnPrimaryButton() {
        chDriver.findElement(By.xpath("//button[contains(text(), \"Primary\")]")).click();
    }

    @Test(priority = 2)
    public void clickOnSuccessButton() {
        chDriver.findElement(By.xpath("//button[contains(text(), \"Success\")]")).click();
    }

    @Test(priority = 3)
    public void clickOnInfoButton() {
        chDriver.findElement(By.xpath("//*[@class='btn btn-lg btn-info']"));
    }

    @Test(priority = 4)
    public void clickOnWarningButton() {
        chDriver.findElement(By.xpath("//*[@class='btn btn-lg btn-warning']")).click();
    }

    @Test(priority = 5)
    public void clickOnDangerButton() {
        chDriver.findElement(By.className("btn-danger")).click();
    }

    @Test(priority = 6)
    public void clickOnLink() {
        chDriver.findElement(By.className("btn-link")).click();
    }

    @Test(priority = 7)
    public void clickOnLeftButton() {
        chDriver.findElement(By.xpath("//button[contains(text(),'Left')]")).click();
    }

    @Test(priority = 8)
    public void clickOnMiddleButton() {
        chDriver.findElement(By.xpath("//button[contains(text(),'Middle')]")).click();
    }

    @Test(priority = 9)
    public void clickOnRightButton() {
        chDriver.findElement(By.xpath("//button[contains(text(),'Right')]")).click();
    }

    @Test(priority = 10)
    public void clickOnButtonOne() {
        chDriver.findElement(By.xpath("//button[contains(text(),'1')]")).click();
    }

    @Test(priority = 11)
    public void clickOnButtonTwo() {
        chDriver.findElement(By.xpath("//button[contains(text(),'2')]")).click();
    }

    @Test(priority = 12)
    public void clickOnFirstDropdownLink() {
        chDriver.findElement(By.id("btnGroupDrop1")).click();
        chDriver.findElement(By.xpath("//a[contains(text(), \"Dropdown link 1\")]")).click();
    }

    @Test(priority = 13)
    public void clickOnSecondDropdownLink() {
        chDriver.findElement(By.id("btnGroupDrop1")).click();
        chDriver.findElement(By.xpath("//a[contains(text(), \"Dropdown link 2\")]")).click();
    }
}
