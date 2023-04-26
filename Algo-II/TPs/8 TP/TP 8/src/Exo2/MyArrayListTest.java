package Exo2;

public class MyArrayListTest {
    private static void testList(MyArrayList<Integer> list){
        for (int i = 0; i < 10000; i++) {
            list.add(42);
            System.out.printf("%d %d %d %d %d", list.size(), list.getV(),list.getW(), list.getX(), list.getY());
        }
    }

    public static void main(String[] args) {
        testList(new AdditiveArrayList<>(1, 2));
        testList(new AdditiveArrayList<>(10, 2));
        testList(new AdditiveArrayList<>(100, 2));
        testList(new AdditiveArrayList<>(10, 100));
        testList(new AdditiveArrayList<>(100, 100));
    }
}
