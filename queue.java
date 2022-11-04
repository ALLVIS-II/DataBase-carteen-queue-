
/****

 * @author (Alvis)
 * @version (28/06/2022)
 */
public class queue
{
    private Converter head;//head 
    private Converter tail;//tail
    //private Converter head2;//teacher queue head 
    //private Converter tail2;//teacher queue tail
    private boolean queueEmpty;

    public queue()
    {
        head = null;
        tail = null;
        //head2 = null;
        //tail2 = null;

    }

    
    void enqueue(people name){
        Converter item = new Converter(name);

        if (queueEmpty() ==true) {
            this.head = item;

        }
        else{

            this.tail.setFollows(item);

        }
        this.tail = item;
    }

    people dequeue(){
        people item = head.getValue();

        head = this.head.getFollows();
        return item;
    }

    boolean queueEmpty(){
        if (this.head ==null)
            return true;
        else {
            return false;

        }
    }
}

