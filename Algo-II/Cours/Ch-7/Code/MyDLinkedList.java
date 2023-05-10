public class MyDLinkedList
extends MyAbstractList
{

    protected MyDLinkedListNode first, last;
    protected int numNodes;

    public void add(int i, Object o) {
	if ((i < 0) || (i > numNodes))
	    throw new ArrayIndexOutOfBoundsException();
	if (numNodes == 0) {
	    first= new MyDLinkedListNode(o, null, null);
	    last= first;
	} else if (i == 0) {
	    first.prev= new MyDLinkedListNode(o, first, null);
	    first= first.prev;
	} else if (i == numNodes) {
	    last.next= new MyDLinkedListNode(o, null, last);
	    last= last.next;
	} else {
	    MyDLinkedListNode tmp;
	    if (i > numNodes/2) {
		for (tmp= last; i < numNodes-1; tmp=tmp.prev, i++);
		tmp.prev.next= new MyDLinkedListNode(o, tmp, tmp.prev);
		tmp.prev= tmp.prev.next;
	    } else {
		for (tmp= first; i > 1; tmp=tmp.next, i--);
		tmp.next.prev= new MyDLinkedListNode(o, tmp.next, tmp);
		tmp.next= tmp.next.prev;
	    }
	}
	numNodes++;
    }

    public Object get(int i) {
	if (i >= numNodes)
	    throw new ArrayIndexOutOfBoundsException();
	MyDLinkedListNode tmp;
	if (i > numNodes/2) {
	    for (tmp= last; i < numNodes-1; tmp=tmp.prev, i++);
	} else {
	    for (tmp= first; i > 0; tmp= tmp.next, i--);
	}
	return tmp.data;
    }

    public int size() {
	return numNodes;
    }

    public void visit(MyVisitor v) {
	MyDLinkedListNode tmp= first;
	while (tmp != null) {
	    v.visit(tmp.data);
	    tmp= tmp.next;
	}
    }

    public void visitReversed(MyVisitor v) {
	MyDLinkedListNode tmp= last;
	while (tmp != null) {
	    v.visit(tmp.data);
	    tmp= tmp.prev;
	}
    }

}
