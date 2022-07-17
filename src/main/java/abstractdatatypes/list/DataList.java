package abstractdatatypes.list;

import abstractdatatypes.Status;

public class DataList {
    private Element head;
    private Element tail;

    public boolean isEmpty() {
        return (head == null);
    }

    public Element getHead() {
        return head;
    }

    public Element getTail() {
        return tail;
    }

    public Element addToEnd(int newVal) {
        Element newElement = new Element(newVal);
        if (this.isEmpty())
            head = newElement;
        else {
            tail.setNext(newElement);
            newElement.setNext(null);
        }
        tail = newElement;
        return newElement;
    }

    public Element addSorted(int newVal) {
        Element newElement = new Element(newVal);
        if (head == null) {
            head = newElement;
            tail = newElement;
            newElement.setNext(null);
            return newElement;
        }
        Element prev = null, nextVal = this.head;
        Status status = Status.SEARCH;
        while ((status == Status.SEARCH) && (nextVal != null))
            if (nextVal.getValue() >= newVal)
                status = Status.STOP;
            else {
                prev = nextVal;
                nextVal = nextVal.getNext();
            }
        if (prev == null) {
            head = newElement;
            newElement.setNext(nextVal);
        } else if (nextVal == null) {
            tail.setNext(newElement);
            newElement.setNext(null);
            tail = newElement;
        } else {
            prev.setNext(newElement);
            newElement.setNext(nextVal);
        }
        return newElement;
    }

    public DataList joinTwoLists(DataList firList, DataList secList) {
        DataList summedList = new DataList();
        Element hdFirList = firList.head, hdSecList = secList.head;
        while (hdFirList != null) {
            summedList.addSorted(hdFirList.getValue());
            hdFirList = hdFirList.getNext();
        }
        while (hdSecList != null) {
            summedList.addSorted(hdSecList.getValue());
            hdSecList = hdSecList.getNext();
        }

        return summedList;
    }

    public DataList fusion(DataList firList, DataList secList) {
        if (firList.head == null)
            return secList;
        if (secList.head == null)
            return firList;
        Element firListTail = firList.getTail();
        Element secListTail = secList.getTail();
        head = firList.head.sort(firList.head, secList.head);
        if (firListTail == null) {
            tail = secListTail;
            return this;
        } else if (secListTail == null)
            return this;
        else
            tail = firListTail;
        return this;
    }

    public boolean search(int toFind) {
        Element tmp = head;
        boolean isFind = false;
        while (tmp != null) {
            if (tmp.getValue() == toFind) {
                isFind = true;
                break;
            } else tmp = tmp.getNext();
        }
        return isFind;
    }

    public DataList removeFirst() {
        if (!this.isEmpty())
            head = head.getNext();
        return this;
    }

    public DataList removeLast() {
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Element temp = head;
            while (temp.getNext() != tail)
                temp = temp.getNext();
            tail = temp;
            temp.setNext(null);
        }
        return this;
    }

    public DataList remove(int toRemove) {
        Element tmp = head, prev = null;
        boolean isFind = false;
        while (tmp != null) {
            if (tmp.getValue() == toRemove) {
                isFind = true;
                break;
            } else {
                prev = tmp;
                tmp = tmp.getNext();
            }
        }
        if (!isFind)
            return this;
        if (prev == null && tmp.getNext() == null) {
            head = null;
            tail = null;
            return this;
        } else if (prev == null && tmp.getNext() != null) {
            head = tmp.getNext();
            return this;
        } else if (prev != null && tmp.getNext() == null) {
            prev.setNext(null);
            head = prev;
            return this;
        } else {
            prev.setNext(tmp.getNext());
            return this;
        }
    }

    public void printResult(String s) {
        if (head != null)
            head.printFurther(s);
        else
            System.out.printf("%s is empty\n", s);
    }
}
