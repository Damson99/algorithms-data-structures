package abstractdatatypes;

import abstractdatatypes.list.DataList;

public class MainDataList
{
    public static void main(String[] args) {
        DataList list = new DataList(), list2 = new DataList();
        int[] tab = {-4, 12, 5, 6, 1, 78, 123, 876, 213, 1};
        list.printResult("List number 1:");
        list.printResult("List number 2:");
        for (int i = 0; i < tab.length; i++)
            list.addToEnd(tab[i]);

        for (int i = 0; i < tab.length; i++)
            list2.addSorted(tab[i]);

        list.printResult("List number 1 without sorting: ");
        list2.printResult("List number 2 with sorting: ");
    }
}
