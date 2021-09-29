package abstractdatatypes.stack.main;

import abstractdatatypes.stack.RestrictedStack;

import static util.Logger.log;

public class RestrictedStackMain
{
    public static void main(String[] args)
    {
        RestrictedStack<Integer> stack1=new RestrictedStack<>(6);
        Integer tmp;
        stack1.push(5);
        stack1.push(2);
        stack1.push(1);
        stack1.push(3);
        stack1.print();

        tmp=stack1.pop(); System.out.print("Taking down from stack: "+tmp); stack1.print();
        tmp=stack1.pop(); System.out.print("Taking down from stack: "+tmp); stack1.print();
        tmp=stack1.pop(); System.out.print("Taking down from stack: "+tmp); stack1.print();
        tmp=stack1.pop(); System.out.print("Taking down from stack: "+tmp); stack1.print();
        tmp=stack1.pop(); System.out.print("Taking down from stack: "+tmp); stack1.print();
        stackStatus(stack1);

        RestrictedStack<String> stack2=new RestrictedStack<>(2);
        String s;
        stack2.push("Ala");
        stack2.push("have");
        stack2.push("cat");
        stack2.push("Rex");
        stack2.print();

        s=stack2.pop(); System.out.print("Taking down from stack: "+s); stack2.print();
        s=stack2.pop(); System.out.print("Taking down from stack: "+s); stack2.print();
        s=stack2.pop(); System.out.print("Taking down from stack: "+s); stack2.print();

    }

    private static void stackStatus(RestrictedStack restrictedStack)
    {
        if(restrictedStack.size()==0)
            log("Stack is empty");
        else
            if(restrictedStack.size()== restrictedStack.capacity())
                log("Stack is full");
            else
                log("Still not full");
    }
}
