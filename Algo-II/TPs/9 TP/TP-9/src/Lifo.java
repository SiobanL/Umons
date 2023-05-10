public class Lifo {
    private MyLinkedList<Integer> lifo;
    public void push (int n){
        lifo.insertBeginning(n);
    }
    public int top (){
        return lifo.get(lifo.getSize());
    }
    public int pop (){
        return lifo.removeBeginning();
    }
}
