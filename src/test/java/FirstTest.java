import org.openqa.selenium.By;
import org.testng.annotations.Test;
import parent.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FirstTest extends BaseTest {

    @Test
    public void zipcode3DigitsCheck () {

        browser.get("https://sharelane.com/cgi-bin/register.py");
        browser.findElement(By.xpath("//input[@name='zip_code']")).sendKeys("345");
        browser.findElement(By.xpath("//input[@value='Continue']")).click();
        assertEquals (browser.findElement(By.cssSelector(".error_message")).getText(), "Oops, error on page. ZIP code should have 5 digits");
    }

    @Test
    public void zipcode5DigitsCheck () {

        browser.get("https://sharelane.com/cgi-bin/register.py");
        browser.findElement(By.xpath("//input[@name='zip_code']")).sendKeys("12345");
        browser.findElement(By.xpath("//input[@value='Continue']")).click();
        boolean regBtnIsDisplayed = browser.findElement(By.xpath("//*[@value='Register']")).isDisplayed();
        assertTrue(regBtnIsDisplayed);
    }
}
