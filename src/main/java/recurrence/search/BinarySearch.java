package recurrence.search;

import java.util.Arrays;

import static util.Logger.log;

public class BinarySearch {
    public static void main(String[] args) {
        int[] tab = {1, 32, 5, 123, 1231, 25, 6353, 45, 7, 54645, 6, 457, 45, 74, 56};
        Arrays.sort(tab);
        Arrays.stream(tab).forEach(s -> System.out.print(s + " "));
        int toFind = 5;
        log("Looking for 5");
        log("5 was found at " + binarySearchWithSortedTab(tab, toFind, 0, tab.length - 1) + " index");
    }

    private static int binarySearchWithSortedTab(int[] tab, int toFind, int left, int right) {
        if (left > right)
            throw new RuntimeException("Number: " + toFind + " Not Found");
        else {
            int mid = (left + right) / 2;
            if (tab[mid] == toFind)
                return mid;
            else if (toFind < tab[mid])
                return binarySearchWithSortedTab(tab, toFind, left, mid - 1);
            else return binarySearchWithSortedTab(tab, toFind, mid + 1, right);
        }
    }
}
