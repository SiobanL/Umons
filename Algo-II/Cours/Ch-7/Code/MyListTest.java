public class MyListTest
{
    
    protected static MyVisitor v= new MyVisitorImpl();

    public static void addItems(MyList l) {
	l.add(new Integer(0));
	l.add(new Integer(1));
	l.add(new Integer(2));
	l.add(0, "Hello");
	l.add(2, "World");
	l.add("!!!");
    }

    public static void iterate(MyList l) {
	for (int i= 0; i < l.size(); i++)
	    System.out.println("  " + i + " : " + l.get(i));
    }

    public static void testLinkedList() {
	System.out.println("---=[ Singly-Linked-List ]=---");
	MyLinkedList l= new MyLinkedList();
	addItems(l);
	System.out.print("forward  : ");
	l.visit(v);
	System.out.println();
	iterate(l);
    }

    public static void testDLinkedList() {
	System.out.println("---=[ Doubly-Linked-List ]=---");
	MyDLinkedList l= new MyDLinkedList();
	addItems(l);
	System.out.print("forward  : ");
	l.visit(v);
	System.out.println();
	System.out.print("backward : ");
	l.visitReversed(v);
    	System.out.println();
	iterate(l);
    }

    public static void testArrayList() {
	System.out.println("---=[ Array-List ]=---");
	MyArrayList l= new MyArrayList();
	addItems(l);
	System.out.print("forward  : ");
	l.visit(v);
	System.out.println();
	iterate(l);
    }

    public static void main(String [] args) {
	testLinkedList();
	testDLinkedList();
	testArrayList();
    }

}
