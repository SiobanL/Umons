public class MyLinkedList
extends MyAbstractList
{

    protected MyLinkedListNode first;
    protected int numNodes;

    public void add(int i, Object o) {
	if ((i < 0) || (i > numNodes))
	    throw new ArrayIndexOutOfBoundsException();
	if (numNodes == 0) {
	    first= new MyLinkedListNode(o, null);
	} else if (i == 0) {
	    first= new MyLinkedListNode(o, first);
	} else {
	    MyLinkedListNode tmp;
	    for (tmp= first; i > 1; tmp= tmp.next, i--);
	    tmp.next= new MyLinkedListNode(o, tmp.next);
	}
	numNodes++;
    }

    public Object get(int i) {
	if (i >= numNodes)
	    throw new ArrayIndexOutOfBoundsException();
	MyLinkedListNode tmp;
	for (tmp= first; i > 0; tmp= tmp.next, i--);
	return tmp.data;
    }

    public int size() {
	return numNodes;
    }

    public void visit(MyVisitor v) {
	MyLinkedListNode tmp= first;
	while (tmp != null) {
	    v.visit(tmp.data);
	    tmp= tmp.next;
	}
    }

}
