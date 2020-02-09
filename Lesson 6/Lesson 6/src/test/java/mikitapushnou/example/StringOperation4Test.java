package mikitapushnou.example;

import mikitapushnou.StringOperation;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StringOperation4Test {

    @DataProvider
    public Object[][] getStrings() {
        return new Object[][] {
                {"str1str2", "str1", "str2"},
                {"str1str2str3", "str1", "str2", "str3"},
                {"str1str2str3str4", "str1", "str2", "str3", "str4"}
        };
    }

    @Test(dataProvider = "getStrings")
    public void testConcatSeveralStrings(String expectedResult, String ... strings) {
        StringOperation stringOperation = new StringOperation();
        String actualResult = stringOperation.concatSeveralStrings(strings);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testGetDecimaOfTheSizeOfTheString() {
        StringOperation stringOperation = new StringOperation();
        double actualResult = stringOperation.getDecimaOfTheSizeOfTheString("");
        double expectedResult = 0;
    }

    @Test(enabled = false)
    public void testAddStringToTheEndOfTheSentence() {
    }

    @Test
    public void testAddStringToTheBeginningOfTheSentence() {
        StringOperation stringOperation = new StringOperation();
        String actualResult = stringOperation.addStringToTheBeginningOfTheSentence("qwerty");
        String expectedResult = "qwerty Lorem ipsum dolor sit amet";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testAddStringToTheMiddleOfTheSentence() {
        StringOperation stringOperation = new StringOperation();
        String actualResult = stringOperation.addStringToTheMiddleOfTheSentence("qwerty");
        String expectedResult = "Lorem ipsum dolor sit amet qwerty";
        Assert.assertNotEquals(actualResult, expectedResult);
    }
}