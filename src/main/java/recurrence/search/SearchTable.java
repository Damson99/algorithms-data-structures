package recurrence.search;

public class SearchTable
{
    public static void main(String[] args) {
        int[] tab = {1, 55, 5, 13, 32131, 66, 778, 51, 3, 5 , 9, 32,1323, 312};
        int leftIndex = 0;
        int lastIndex = tab.length - 1;
        int elementToFind = 9;
        search(tab, leftIndex, lastIndex, elementToFind);
    }

    private static void search(int[] tab, int leftIndex, int lastIndex, int elementToFind)
    {
        if(leftIndex > lastIndex)
            System.out.println("404 : Not found");
        else if (tab[leftIndex] == elementToFind)
            System.out.println("Element " + elementToFind + " was found on " + leftIndex + " index in table");
        else
            search(tab, leftIndex + 1, lastIndex, elementToFind);
    }
}
