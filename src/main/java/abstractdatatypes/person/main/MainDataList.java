package abstractdatatypes.person.main;

import abstractdatatypes.list.DataList;

import static util.Logger.log;

public class MainDataList
{
    public static void main(String[] args) {
        DataList list = new DataList(), list2 = new DataList(), list3 = new DataList();
        int[] tab = {312, 12, 16, 3, 2};
        int[] tab2 = {12, 5, -4, 6, 1, 78, 123, 876, 213, 1};
        list.printResult("List number 1:");
        list.printResult("List number 2:");
        System.out.println();

        for (int i : tab)
            list.addToEnd(i);

        for (int i : tab2)
            list2.addSorted(i);

        list.printResult( "List number 1 without sorting: ");
        list2.printResult("List number 2 with sorting:    ");
        System.out.println();

        list.removeFirst();
        list.removeLast();
        list.remove(78);

        list.printResult( "List number 1 without sorting: ");
        list2.printResult("List number 2 with sorting:    ");

        log("\nIs 6 in list: " + list.search(6));
        System.out.println();

        list3 = list.joinTwoLists(list, list2);
        list3.printResult("sum L3=L1+L2    : ");

        list = list.fusion(list, list2);
        list2 = null;
        list.printResult("fusion L1=L1+L2 : ");
    }
}
