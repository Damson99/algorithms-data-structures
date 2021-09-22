package abstractdatatypes.list;

import abstractdatatypes.Status;

public class DataList {
    private Element head;
    private Element tail;

    public boolean isEmpty(){
        return (head == null);
    }

    public Element getHead(){
        return head;
    }
    public Element getTail(){
        return tail;
    }

    public Element addToEnd(int newVal){
        Element newElement = new Element(newVal);
        if (this.isEmpty())
            head = newElement;
        else{
            tail.setNext(newElement);
            newElement.setNext(null);
        }
        tail = newElement;
        return newElement;
    }

    public Element addSorted(int newVal){
        Element newElement = new Element(newVal);
        if (head == null){
            head = newElement;
            tail = newElement;
            newElement.setNext(null);
            return newElement;
        }

        Element prev = null, nextVal = this.head;
        Status status = Status.SEARCH;
        while ((status == Status.SEARCH) && (nextVal != null))
            if (nextVal.getValue() >= newVal)
                status=Status.STOP;
            else{
                prev = nextVal;
                nextVal = nextVal.getNext();
            }

        if (prev == null){
            head=newElement;
            newElement.setNext(nextVal);
        } else
        if (nextVal == null){
            tail.setNext(newElement);
            newElement.setNext(null);
            tail = newElement;
        }
        else{
            prev.setNext(newElement);
            newElement.setNext(nextVal);
        }
        return newElement;
    }

    public boolean search(int toFind){
        Element tmp = head;
        boolean res = false;
        while (tmp != null){
            if (tmp.getValue() == toFind){
                res = true;
                break;
            }
            else tmp=tmp.getNext();
        }
        return res;
    }

    public void printResult(String s){
        if (head != null)
            head.printFurther(s);
        else
            System.out.printf("%s is empty\n", s);
    }
}
