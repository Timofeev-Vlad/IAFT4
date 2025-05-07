import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FirstTest {
    public String trialCode (int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "ТИМ";
        } else if (number % 5 == 0) {
            return "M";
        } else if (number % 3 == 0) {
            return "Т";
        } else return "FAIL";
    }

    @Test
    public void timTest () {
        String actualResult = trialCode(9);
        assertEquals(actualResult, "Т");
    }

    @Test
    public void tim5Test () {
        String actualResult = trialCode(25);
        assertEquals(actualResult, "M");
    }

    @Test
    public void tim58Test () {
        String actualResult = trialCode(15);
        assertEquals(actualResult, "ТИМ");
    }
}
