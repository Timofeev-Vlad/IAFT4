import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import parent.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HerokkuTest extends BaseTest {
    @Test
    public void logincheck () {
        browser.get("https://the-internet.herokuapp.com/login");
        browser.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        browser.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        browser.findElement(By.xpath("//button")).click();
        boolean LogoutBtnIsDisplayed = browser.findElement(By.xpath("//i[contains(text (),' Logout')]")).isDisplayed();
        assertTrue (LogoutBtnIsDisplayed);
    }

    @Test
    public void loginerror () {
        browser.get("https://the-internet.herokuapp.com/login");
        browser.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith.");
        browser.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!.");
        browser.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        boolean LogoutBtnIsDisplayed = browser.findElement(By.xpath("//div[@id='flash']")).isDisplayed();
        assertTrue (LogoutBtnIsDisplayed);
    }

    @Test
    public void keypresses () {
        browser.get("https://the-internet.herokuapp.com/key_presses");
        browser.findElement(By.xpath("//input[@id='target']")).sendKeys(Keys.BACK_SPACE);
        assertEquals (browser.findElement(By.xpath("//p[@id='result']")).getText(), "You entered: BACK_SPACE");
    }

   @Test
    public void dropdownCheck () {
        browser.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = browser.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        assertEquals(select.getFirstSelectedOption().getText(), "Option 1");
    }
}
