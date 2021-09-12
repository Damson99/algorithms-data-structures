package util;

import java.util.Scanner;
import java.util.regex.Pattern;

public class NumberValidator
{
    private final static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    protected static boolean validNumbers(String isNum)
    {
        if (isNum == null || isNum.equals(""))
            return false;
        return pattern.matcher(isNum).matches();
    }

    protected static String stringFromScanner()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
