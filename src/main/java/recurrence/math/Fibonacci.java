package recurrence.math;

import util.NumberValidator;


public class Fibonacci extends NumberValidator
{
    public static void main(String[] args)
    {
        String data = stringFromScanner();
        if(validNumbers(data))
        {
            int providedNumber = Integer.parseInt(data);
            for(long i = 0; i < providedNumber; i++)
                System.out.println("fib[ " + i + "] = " + fib(i));
        }
        else System.out.println("Provide valid number");
    }

    private static long fib(long x) {
        if(x < 2) return x;
        else return fib(x - 1) + fib(x - 2);
    }
}
