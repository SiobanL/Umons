public class Node{
    protected int data;
    protected Node next;

    public Node(int data){
        this(data,null);
    }

    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }

    public void setNext(Node next){
        this.next = next;
    }

    public int getData(){
        return this.data;
    }
}