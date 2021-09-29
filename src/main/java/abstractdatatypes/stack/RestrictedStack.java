package abstractdatatypes.stack;

import java.util.Enumeration;
import java.util.Vector;

import static util.Logger.log;

public class RestrictedStack<BasicType>
{
    private Vector<BasicType> stack;

    public RestrictedStack(int size)
    {
        this.stack=new Vector<>(size);
        log("Creating stack with capacity: "+stack.capacity()+" || number of elements: "+stack.size());

    }

    public void clear()
    {
        stack.clear();
    }

    public void print()
    {
        Enumeration vEnum=stack.elements();
        System.out.print(" Stack contents: [");
        while(vEnum.hasMoreElements())
            System.out.print(vEnum.nextElement()+" ");
        System.out.print("]");
    }

    public void push(BasicType basicType)
    {
        if(stack.size()<stack.capacity()){
            System.out.print("Put down: ");
            System.out.print(basicType.toString());
            stack.add(basicType);
            log(", stack size: "+stack.size()+", stack capacity: "+stack.capacity());
        }
        else{
            log("Capacity exceeded");
        }
    }

    public BasicType pop()
    {
        BasicType tmp=null;
        if(stack.size()>0){
            tmp=stack.lastElement();
            stack.remove(tmp);
            System.out.print("Taking down: "+tmp.toString());
            log(", stack size: "+stack.size());
        }
        return tmp;
    }

    public int size()
    {
        return stack.size();
    }

    public int capacity()
    {
        return stack.capacity();
    }
}







