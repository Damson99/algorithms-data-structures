package abstractdatatypes.list;

import abstractdatatypes.Status;

public class DataList {
    private Element head;
    private Element tail;

    public boolean search(int toFind) {
        Element tmp = head;
        boolean result = false;
        while (tmp != null)
        {
            if(tmp.getValue() == toFind)
            {
                result = true;
                break;
            }
            tmp = tmp.getNext();
        }

        return result;
    }

    public void printResult(String listName)
    {
        if(head != null)
            head.printFurther(listName);
        else
            System.out.printf("Lista %s jest pusta\n", listName);
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public Element addToEnd(int value) {
        Element newElement = new Element(value);
        if(this.isEmpty())
        {
            head = newElement;
        }
        else
        {
            head.setNext(newElement);
            newElement.setNext(null);
        }
        tail = newElement;
        return newElement;
    }

    public Element addSorted(int value) {
        Element newElement = new Element(value);
        if(head == null)
        {
            head = newElement;
            tail = newElement;
            newElement.setNext(null);
            return newElement;
        }
        Element prev = null, next = head;
        Status status = Status.SEARCH;
        while (status == Status.SEARCH && next != null)
            if(next.getValue() >= value)
                status = Status.STOP;
            else
            {
                prev = next;
                next = next.getNext();
            }
        if(prev == null)
        {
            head = newElement;
            next.setNext(next);
        }
        else if(next == null)
        {
            tail.setNext(newElement);
            newElement.setNext(null);
            tail = newElement;
        }
        else
        {
            prev.setNext(newElement);
            newElement.setNext(next);
        }
        return newElement;
    }
}
