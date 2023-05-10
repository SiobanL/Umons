import java.util.LinkedList;

public class MyLinkedList<T> {
    private Node head, tail;
    private int size = 0;
    public MyLinkedList(Node head){
        this.head = head;
        this.tail = head;
        size++;
    }

    public int getSize() {
        return size;
    }

    public void insertBeginning(int n){
        if (size == 0){
            head = new Node(n);
            tail = head;
        }
        else {
            Node tempHead = new Node(n);
            tempHead.setNext(this.head);
            this.head = tempHead;
        }
        size++;
    }
    public void insertEnd (int n){
        if (size == 0){
            head = new Node(n);
            tail = head;
        }
        else {
            Node tempHead = new Node(n);
            this.tail.setNext(tempHead);
            this.tail = tempHead;
        }
        size++;
    }
    public void insert (int i, int n){
        if(i > this.size || i < 0){
            throw new IndexOutOfBoundsException();
        }
        else {
            if (i == size) {
                insertEnd(n);
            } else if (i == 0) {
                insertBeginning(n);
            } else {
                Node current = this.head;
                Node newNode = new Node(n);
                for (int j = 0; j < i; j++) {
                    current = current.next;
                }
                newNode.setNext(current.next);
                current.setNext(newNode);
                size++;
            }
        }
    }
    public int get (int i){
        if (i > this.size || i <= 0){
            throw new IndexOutOfBoundsException();
        }
        Node current= this.head;
        for (int j = 1; j < i; j++) {
            current = current.next;
        }
        return current.getData();
    }
    public int removeBeginning (){
        if (size == 0){
            throw new IndexOutOfBoundsException();
        }
        Node tempHead = head;
        head = head.next;
        size--;
        return tempHead.getData();
    }
    public int removeEnd (){
        if (size == 0){
            throw new IndexOutOfBoundsException();
        }
        Node tempTail = tail;
        Node current = head;
        for (int i = 1; i < size-1; i++) {
            current = current.next;
        }
        current.next = null;
        tail = current;
        size--;
        return tempTail.getData();
    }
    public int remove (int i){
        if(i > this.size || i <= 0){
            throw new IndexOutOfBoundsException();
        }
        else {
            if (i == size) {
                return removeEnd();
            } else if (i == 1) {
                return removeBeginning();
            } else {
                Node current = head;
                for (int j = 1; j < i-1; j++) {
                    current = current.next;
                }
                Node tempNode = current.next;
                current.setNext(current.next.next);
                size--;
                return tempNode.getData();
            }
        }
    }
    public String toString (){
        String res = "";
        Node current = head;
        for (int i = 1; i <= size; i++) {
            if (i == size) {
                res += String.valueOf(current.getData());
            }
            else {
                res += String.valueOf(current.getData())+",";
            }
            current = current.next;
        }
        return "["+res+"]";
    }
    public LinkedList clone (){
        Node current = head;
        LinkedList temp = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            temp.add(current.getData());
            current = current.next;
        }
        return temp;
    }
}