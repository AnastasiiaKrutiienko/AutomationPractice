import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckEmailHappyPath {

    @DataProvider(name = "CheckEmailWithMinNumbersOfValidChars")
    public static Object[][] emailWithMinNumbersOfValidChars() {
        return new Object[][] { {"aBc@dE.fg"},
                                {"123@45.ab"},
                                {"A2b@C3.de"} };
    }

    @Test(dataProvider = "CheckEmailWithMinNumbersOfValidChars")
    public void checkMinNumbersOfValidChars(String email) {
        boolean actualResult = Email.isEmailCorrect(email);
        Assert.assertEquals(actualResult, true,
                "This email contains less than min numbers of valid chars at all/some of three parts of an email");
    }

    @DataProvider(name = "CheckEmailWithMaxNumbersOfValidChars")
    public static Object[][] emailWithMaxNumbersOfValidChars() {
        return new Object[][] { {"!6tFpysgnkRgpDibFmA1@aBcDe.abcde"},
                                {"12345678901234567890@12345.abcde"},
                                {"A2bFw34G57JRqiknutec@a1B2c.abcde"} };
    }

    @Test(dataProvider = "CheckEmailWithMaxNumbersOfValidChars")
    public void checkMaxNumbersOfValidChars(String email) {
        boolean actualResult = Email.isEmailCorrect(email);
        Assert.assertEquals(actualResult, true,
                "TThis email contains more than max numbers of valid chars at all/some of three parts of an email");
    }
}
