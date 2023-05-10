public class Fifo {
    private MyLinkedList<Integer> fifo;
    public void enqueue (int n){
        fifo.insertEnd(n);
    }
    public int first (){
        return fifo.get(0);
    }
    public int dequeue (){
        return fifo.removeBeginning();
    }
}