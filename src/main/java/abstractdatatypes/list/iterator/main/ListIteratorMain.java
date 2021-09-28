package abstractdatatypes.list.iterator.main;

import abstractdatatypes.list.iterator.CollectionList;
import abstractdatatypes.list.iterator.ListIterator;

import static util.Logger.log;

public class ListIteratorMain
{
    public static void main(String[] args) {
        CollectionList collectionList=new CollectionList();
        ListIterator iterator=new ListIterator(collectionList);
        iterator.addAfter('a');
        log("value of the record pointed by cursor: "+iterator.getCursor().getValue());

        collectionList.print();
        iterator.addAfter('b');
        log("value of the record pointed by cursor: "+iterator.getCursor().getValue());

        collectionList.print();
        iterator.addBefore('c');
        log("value of the record pointed by cursor: "+iterator.getCursor().getValue());

        collectionList.print();
        iterator.iterateNext();
        log("Move by one position to next , value of the record pointed by cursor: "
                +iterator.getCursor().getValue());

        iterator.iterateNext();
        log("Move by one position to next , value of the record pointed by cursor: "
                +iterator.getCursor().getValue());

        iterator.addBefore('d');
        collectionList.print();
        iterator.addBefore('B');
        iterator.addAfter('C');
        iterator.addAfter('D');
        iterator.addAfter('E');
        collectionList.print();
        log("value of the record pointed by cursor: "+iterator.getCursor().getValue());

        log("Deleting current: "+iterator.removeCurrent());
        collectionList.print();
    }
}
