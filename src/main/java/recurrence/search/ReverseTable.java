package recurrence.search;

import static util.Logger.log;

public class ReverseTable {
    public static void main(String[] args) {
        int[] tab = {1, 4, 3, 6, 1023, 3123124, 6341, 75, 9, 0};
        for (int i : tab)
            System.out.print(i + " ");

        log("\nReversed: ");

        reverse(tab, 0, tab.length - 1);
        for (int i : tab)
            System.out.print(i + " ");
    }

    private static void reverse(int[] tab, int left, int right) {
        int tmp;
        if (left < right) {
            tmp = tab[left];
            tab[left] = tab[right];
            tab[right] = tmp;
            reverse(tab, left + 1, right - 1);
        }
    }
}
