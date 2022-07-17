package recurrence.math;

import util.NumberValidator;

import static util.Logger.log;


public class Fibonacci extends NumberValidator {

    public static void main(String[] args) {
        String data = stringFromScanner();
        if (validNumbers(data)) {
            int providedNumber = Integer.parseInt(data);
            for (long i = 0; i < providedNumber; i++)
                log("fib[ " + i + "] = " + fib(i));
        } else {
            log("Provide valid number");
        }
    }

    private static long fib(long x) {
        if (x < 2) return x;
        else return fib(x - 1) + fib(x - 2);
    }
}
