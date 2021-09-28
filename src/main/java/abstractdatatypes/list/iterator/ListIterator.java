package abstractdatatypes.list.iterator;

public class ListIterator
{
    private DataRecord cursor;
    private DataRecord prev;
    private CollectionList data;

    public ListIterator(CollectionList data)
    {
        this.data=data;
        backToStart();
    }

    public void addAfter(char c)
    {
        System.out.print("Adding: ["+c+"]");
        DataRecord elt=new DataRecord(c);
        if(data.isEmpty()){
            data.setUpStart(elt);
            cursor=elt;
            prev=null;
        }
        else{
            elt.setNext(cursor.getNext());
            cursor.setNext(elt);
            iterateNext();
        }
    }

    public void addBefore(char c)
    {
        System.out.print("Adding: ["+c+"]");
        DataRecord elt=new DataRecord(c);
        if(prev==null){
            elt.setNext(data.getHead());
            data.setUpStart(elt);
            backToStart();
        }
        else{
            elt.setNext(prev.getNext());
            prev.setNext(elt);
            cursor=elt;
        }
    }

    public char removeCurrent()
    {
        char value=cursor.getValue();
        if(prev==null){
            data.setUpStart(cursor.getNext());
            backToStart();
        }
        else{
            prev.setNext(cursor.getNext());
            if(isLast())
                backToStart();
            else
                cursor=cursor.getNext();
        }
        return value;
    }

    public boolean isLast()
    {
        return cursor==null;
    }

    public void iterateNext()
    {
        if(cursor.getNext()!=null){
            prev=cursor;
            cursor=cursor.getNext();
        }
        else{
            backToStart();
        }
    }

    public DataRecord getCursor()
    {
        return cursor;
    }

    private void backToStart()
    {
        cursor=data.getHead();
        prev=null;
    }
}
