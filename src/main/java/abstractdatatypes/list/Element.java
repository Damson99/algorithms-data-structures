package abstractdatatypes.list;

//lista jednokierunkowa
public class Element {
    private int value;
    private Element next;

    public Element(int newVal)
    {
        this.value = newVal;
        this.next = null;
    }
    public int getValue(){
        return value;
    }

    public Element getNext(){
        return next;
    }

    public void setNext(Element nextVal)
    {
        next = nextVal;
    }

    public Element sort(Element fir, Element sec)
    {
        if(fir == null)
            return sec;
        if(sec == null)
            return fir;
        if(fir.value <= sec.value){
            fir.next = sort(fir.next, sec);
            return fir;
        }
        else{
            sec.next = sort(sec.next, fir);
            return sec;
        }
    }

    public void printFurther(String listName)
    {
        Element tmp = this;
        System.out.printf("Further elements: %s",listName);
        while(tmp != null){
            System.out.printf("%d ",tmp.value);
            tmp = tmp.next;
        }
        System.out.println();
    }
}
