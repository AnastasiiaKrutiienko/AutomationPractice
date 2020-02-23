import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckEmailUnhappyPath {
    @DataProvider(name = "CheckEmailWithOverTheMaxLineNumbersOfValidCharsBeforeAtSign")
    public static Object[][] emailWithOverTheMaxLineNumbersOfValidCharsBeforeAtSign() {
        return new Object[][] { {"!6tFpysgnkRgpDibFmA12@25a.abc"},
                                {"123456789012345678901@453.abc"},
                                {"A2bhsk567kfbtlxRTkYUe@C3d.abc"} };
    }

    @Test(dataProvider = "CheckEmailWithOverTheMaxLineNumbersOfValidCharsBeforeAtSign")
    public void checkOverTheMaxLineNumbersOfValidCharsBeforeAtSign(String email) {
        boolean actualResult = Email.isEmailCorrect(email);
        Assert.assertEquals(actualResult, false, "This email have 20 or less valid chars before @ symbol");
    }

    @DataProvider(name = "CheckEmailWithOverTheMaxLineNumbersOfValidCharsBeforeThePoint")
    public static Object[][] emailWithOverTheMaxLineNumbersOfValidCharsBeforeThePoint() {
        return new Object[][] { {"!6tFpys@25a34d.abc"},
                                {"1234560@453671.abc"},
                                {"A2bTkYe@C3dFh3.abc"} };
    }

    @Test(dataProvider = "CheckEmailWithOverTheMaxLineNumbersOfValidCharsBeforeThePoint")
    public void checkOverTheMaxLineNumbersOfValidCharsBeforeThePoint(String email) {
        boolean actualResult = Email.isEmailCorrect(email);
        Assert.assertEquals(actualResult, false, "This email have 5 or less valid chars before the point");
    }

    @DataProvider(name = "CheckEmailWithOverTheMaxLineNumbersOfValidCharsAfterThePoint")
    public static Object[][] emailWithOverTheMaxLineNumbersOfValidCharsAfterThePoint() {
        return new Object[][] { {"!6tFpysgnkRgpDibFmA12@25a.abc"},
                {"123456789012345678901@453.abc"},
                {"A2bhsk567kfbtlxRTkYUe@C3d.abc"} };
    }

    @Test(dataProvider = "CheckEmailWithOverTheMaxLineNumbersOfValidCharsAfterThePoint")
    public void checkOverTheMaxLineNumbersOfValidCharsAfterThePoint(String email) {
        boolean actualResult = Email.isEmailCorrect(email);
        Assert.assertEquals(actualResult, false, "This email have 5 or less valid chars after the point");
    }

    @DataProvider(name = "CheckEmailWithoutAtSignSymbol")
    public static Object[][] emailWithoutAtSignSymbol () {
        return new Object[][] { {"!6tFpysgnkRa.abc"},
                                {"123456789053.abc"},
                                {"A2bhsk567C3d.abc"} };
    }

    @Test(dataProvider = "CheckEmailWithoutAtSignSymbol")
    public void checkEmailsWithoutAtSignSymbol(String email) {
        boolean actualResult = Email.isEmailCorrect(email);
        Assert.assertEquals(actualResult, false, "This email contains @ symbol");
    }

    @DataProvider(name = "CheckEmailWithoutThePoint")
    public static Object[][] emailWithoutThePoint () {
        return new Object[][] { {"!6tFpysgnkRa@abc"},
                                {"123456789053@abc"},
                                {"A2bhsk567C3d@abc"} };
    }

    @Test(dataProvider = "CheckEmailWithoutThePoint")
    public void checkEmailsWithoutThePoint(String email) {
        boolean actualResult = Email.isEmailCorrect(email);
        Assert.assertEquals(actualResult, false, "This email contains the point symbol");
    }

}
