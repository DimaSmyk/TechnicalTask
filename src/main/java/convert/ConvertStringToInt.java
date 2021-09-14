package convert;

/**
 * @author Dmitriy Smyk
 * This class allows converting to int from string.
 * String accepts input of positive ot negative numbers and converts the string.
 * Floating point values are not supported
 */
public class ConvertStringToInt {

    int num;
    char firstChar;
    int convertedLine;
    String input = "23";

    public static void main(String[] args) {
        ConvertStringToInt convert = new ConvertStringToInt();
        convert.checkInput(convert.input);
    }
    /**
     * This method checks input for string length and allows '0' input. Also calls the method printResult,
     * which prints the result to the console
     * @param input - takes user input
     * @return - return checks s
     */
    public String checkInput(String input) {
        double maxLimitLength = Math.pow(2, 32) - 1;
        if (input.isEmpty()){
            throw new NullPointerException();
        }
        if (input.length() >= 2 && input.length() <= maxLimitLength || input.equals("0")) {
            printResult(input);
        } else {
            System.out.println("If you need to enter numbers [1-9]. Add '+' or '-' at the beginning");
            System.out.println("Repeat enter");
        }
        return input;
    }
    /**
     * @param input  - user's input
     * @param a - this variable help to validate the input with '+' or '-'.
     *          If the input begins with this symbol, then this variable must be equal to 1,
     *          else equal 0.
     * @return - converted number from string
     */
    public int stringToInt(String input, int a) {

        firstChar = input.charAt(0);
        if (firstChar == '+' | firstChar == '-') {
            convertCycle(input, 1);
            if (firstChar == '+') {
                convertedLine = num;
            } else {
                convertedLine = -num;
            }
        } else {
            convertCycle(input,0);
            convertedLine = num;
        }
        return convertedLine;
    }

    /**
     * This method prints the result to the console and calls method "stringToInt".
     * @param input - user's input
     */
    public void printResult(String input) {
        firstChar = input.charAt(0);
        if (firstChar == '+' | firstChar == '-') {
            stringToInt(input, 1);
        } else {
            stringToInt(input, 0);
        }
        System.out.println(convertedLine);
    }

    /**
     * This method contains the logic for converting a string to a number.
     * So that the code does not repeat itself, moved to a separate method.
     * @param input - user's input
     * @param a - a - this variable help to validate the input with '+' or '-'.
     *           If the input begins with this symbol, then this variable must be equal to 1,
     *           else equal 0.
     */
    public void convertCycle(String input, int a) {
        for (int i = a; i < input.length(); i++) {
            if ((input.charAt(i) >= 48) && (input.charAt(i) <= 59)) {
                num = num * 10 + (input.charAt(i) - 48);
            } else {
                throw new NumberFormatException();
            }
        }
    }
}