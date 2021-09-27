package recurrence.math;

import util.NumberValidator;

import static util.Logger.*;

public class Factorial extends NumberValidator
{
    public static void main(String[] args) {
        String data = stringFromScanner();
        if(validNumbers(data))
        {
            int providedNumber = Integer.parseInt(data);
            log("----------------------|----------------------");
            log("------------------factorial------------------");
            log("----------------------|----------------------");
            for(long i = 0; i < providedNumber; i++)
                System.out.printf("factorial(%2d) = %12d\n", i, factorial(i, 1));
        }
        else log("Provide valid number");
    }

    private static long factorial(long i, long tmp) {
        if(i == 0)
            return tmp;
        else
            return factorial(i - 1, i * tmp);
    }
}
