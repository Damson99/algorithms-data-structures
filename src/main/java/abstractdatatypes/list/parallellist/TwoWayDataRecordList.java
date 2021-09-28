package abstractdatatypes.list.parallellist;

import static util.Logger.log;

//lista dwukierunkowa
public class TwoWayDataRecordList
{
    private static int currentSize=0;
    private TwoWayDataRecord head;
    private TwoWayDataRecord tail;


    public int size()
    {
        return currentSize;
    }

    public void print()
    {
        TwoWayDataRecord tmp=head;
        while(tmp!=null){
            System.out.print("["+tmp.getSurname()+" "+tmp.getAge()+"] -> ");
            tmp=tmp.getNext();
        }
        System.out.println();
    }

    public void printFromEnd()
    {
        TwoWayDataRecord tmp=tail;
        while(tmp!=null){
            System.out.print("["+tmp.getSurname()+" "+tmp.getAge()+"] <- ");
            tmp=tmp.getPrev();
        }
        System.out.println();
    }

    public void remove(String surname)
    {
        TwoWayDataRecord tmp=head;
        while(tmp!=null){
            if(tmp.getSurname().compareTo(surname)==0){
                if(tmp==head){
                    head=tmp.getNext();
                    currentSize--;
                    break;
                }
                else if(tmp==tail){
                    tail=tmp.getPrev();
                    currentSize--;
                    break;
                }
                else{
                    tmp.getPrev().setNext(tmp.getNext());
                    tmp.getNext().setPrev(tmp.getPrev());
                    currentSize--;
                    break;
                }
            }
            tmp=tmp.getNext();
        }
        if(tmp==null)
            System.out.printf("No record [%s] found", surname);
    }

    public void addSorted(String surname, int age)
    {
        TwoWayDataRecord newDataRecord=new TwoWayDataRecord(surname, age, null, null);
        if(head==null){
            head=newDataRecord;
            tail=newDataRecord;
            currentSize++;
        }
        else{
            TwoWayDataRecord tmp=head;
            while(head!=null){
                if(tmp.getSurname().compareTo(surname)<0)
                    tmp=tmp.getNext();
                else{
                    if(tmp==head){
                        tmp.setPrev(newDataRecord);
                        newDataRecord.setNext(tmp);
                        head=newDataRecord;
                    }
                    else{
                        newDataRecord.setPrev(tmp.getPrev());
                        newDataRecord.setNext(tmp);
                        tmp.getPrev().setNext(newDataRecord);
                        tmp.setPrev(newDataRecord);
                    }
                    currentSize++;
                    break;
                }
            }
            if(tmp==null)
            {
                tail.setNext(newDataRecord);
                newDataRecord.setPrev(tail);
                tail=newDataRecord;
                currentSize++;
            }
        }
    }
}
