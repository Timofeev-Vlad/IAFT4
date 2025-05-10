import org.openqa.selenium.By;
import org.testng.annotations.Test;
import parent.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FirstTest extends BaseTest {

    @Test
    public void search3DigitsCheck () {

        browser.get("https://sharelane.com/cgi-bin/register.py");
        browser.findElement(By.xpath("//input[@name='keyword']")).sendKeys("345");
        browser.findElement(By.xpath("//input[@value='Search']")).click();
        assertEquals (browser.findElement(By.cssSelector(".confirmation_message")).getText(), "Please, note that current MySQL settings don't allow searches for words containing less than 4 chars");
    }

    @Test
    public void search5DigitsCheck () {

        browser.get("https://sharelane.com/cgi-bin/register.py");
        browser.findElement(By.xpath("//input[@name='keyword']")).sendKeys("12345");
        browser.findElement(By.xpath("//input[@value='Search']")).click();
        assertEquals (browser.findElement(By.cssSelector(".confirmation_message")).getText(), "Nothing is found :(");
    }
}
