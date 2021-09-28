package abstractdatatypes.array;

import static util.Logger.log;

public class ListTable {
    private final int maxSize=200;
    private int currentSize;
    private Card[] tab;

    public ListTable()
    {
        this.currentSize = 0;
        this.tab = new Card[maxSize];
    }

    public int search(String surname)
    {
        for(int i = 0; i < currentSize; i++)
            if(tab[i].getSurname().equals(surname))
                return i;
        return -1;
    }

    public void removePerson(String surname)
    {
        int index;
        index=search(surname);
        if(index>0)
        {
            for(int i=index; i<currentSize; i++)
                tab[i]=tab[i+1];
            currentSize--;
        }
    }

    public void addPerson(String surname, int age)
    {
        if(currentSize<maxSize){
            Card card = new Card(surname, age);
            tab[currentSize]=card;
            currentSize++;
        } else log("No space left!");
    }

    public void addPersonAtIndex(String surname, int age, int index)
    {
        if(index>=0 && currentSize<maxSize){
            Card card = new Card(surname, age);
            for(int i=currentSize; i>=index; i--)
                tab[i+1]=tab[i];
            tab[index]=card;
            currentSize++;
        } else log("This index is not empty!");
    }

    public void print(){
        for(Card c : tab){
            if(c!=null)
                log(c.getSurname()+" "+c.getAge());
        }
    }





}
