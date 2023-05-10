public class MyDLinkedListNode
{
    public Object data;
    public MyDLinkedListNode next, prev;

    public MyDLinkedListNode(Object data,
			     MyDLinkedListNode next,
			     MyDLinkedListNode prev) {
	this.data= data;
	this.next= next;
	this.prev= prev;
    }

}
