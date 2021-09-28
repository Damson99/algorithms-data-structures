package abstractdatatypes.list.iterator;

public class CollectionList
{
    private DataRecord head;


    public CollectionList()
    {
        this.head=null;
    }

    public DataRecord getHead()
    {
        return head;
    }

    public void setUpStart(DataRecord elt)
    {
        this.head=elt;
    }

    public boolean isEmpty()
    {
        return this.head==null;
    }

    public void print()
    {
        System.out.print("List ");
        DataRecord elt=head;
        System.out.print("{ ");
        while(elt!=null){
            elt.print();
            elt=elt.getNext();
        }
        System.out.print("}\n");
    }
}
