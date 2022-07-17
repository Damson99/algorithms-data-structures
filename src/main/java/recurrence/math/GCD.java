package recurrence.math;


import static util.Logger.*;

//Greatest Common Divisor
public class GCD {
    public static void main(String[] args) {
        log(nwd(1230123, 1241259));
    }

    private static int nwd(int a, int b) {
        if (b == 0) return a;
        else return nwd(b, a % b);
    }
}
