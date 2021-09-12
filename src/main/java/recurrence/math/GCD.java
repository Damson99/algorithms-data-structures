package recurrence.math;

//Greatest Common Divisor
public class GCD
{
    public static void main(String[] args) {
        System.out.println(nwd(1230123, 1241259));
    }

    private static int nwd(int a, int b)
    {
        if(b == 0) return a;
        else return nwd(b, a % b);
    }
}
