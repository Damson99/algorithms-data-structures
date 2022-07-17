package computingsystems;

public class BinaryForm {
    public static void main(String[] args) {
        for (int i = 0; i <= 100; i++) {
            System.out.print("Binary form of number " + i + ": ");
            convertToBinaryForm(i);
            System.out.println();
        }
    }

    private static void convertToBinaryForm(int number) {
        if (number != 0) {
            convertToBinaryForm(number / 2);
            System.out.print(number % 2);
        } else System.out.print(0);
    }
}
