package computingsystems;

public class BitsOperations
{
    public static final byte OPTION_1 = 1;
    public static final byte OPTION_2 = 2;
    public static final byte OPTION_3 = 4;
    public static final byte OPTION_4 = 8;

    public static void main(String[] args)
    {
        System.out.println("i\tbinarne\tprzes.w lewo\tnegacja\n");
        for(int i = 9; i < 33; i++)
        {
            System.out.print(i + "\t");
            showBits((char) i);

            System.out.print("\t");
            int j = i << 1;
            showBits((char) j);

            System.out.print("\t");
            int k = i -1;
            showBits((char) k);

            System.out.println();
        }

        byte options = OPTION_2 | OPTION_3;
        System.out.print((int) options + "\t");
        showBits((char) options);
    }

    private static void showBits(char s)
    {
        char[] weights = {1, 2, 4,8, 16 ,32, 64, 128};
        for(int i = 7; i >=0; i--)
        {
            int bit = (weights[i] & s);
            if(bit != 0) System.out.print("1");
            else System.out.print("0");
        }
    }
}
