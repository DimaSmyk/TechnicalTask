package convert;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConvertIntToStringTest {

    @Test
    public void checkedConvertStringToInt() {
        ConvertStringToInt convert = new ConvertStringToInt();
        int expected = 1234;
        String a = "+1234";
        int actual = convert.stringToInt(a,1);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void TestForNull(){
        ConvertStringToInt convert = new ConvertStringToInt();
        String actual = convert.checkInput(convert.input);
        Assertions.assertNotNull(actual);
    }
    @Test
    public void minLengthTest() {
        ConvertStringToInt convert = new ConvertStringToInt();
        int expected = convert.input.length();
        int actualMinLength = 2;
        if (expected < actualMinLength ){
            Assertions.assertEquals(expected, actualMinLength);
        }
    }
@Test
    public void containsOnlyNumbers() {
        ConvertStringToInt convert = new ConvertStringToInt();
        boolean actual = convert.input.matches(".[0-9]");
        Assertions.assertTrue(actual);
    }
    @Test
    public void containsFloatingPointNumbers() {
        ConvertStringToInt convert = new ConvertStringToInt();
        boolean actual = convert.input.matches(".[0-9]*[.,][0-9]+$");
        Assertions.assertFalse(actual);
    }

}
