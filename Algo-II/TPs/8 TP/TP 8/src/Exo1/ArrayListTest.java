package Exo1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ArrayListTest {
    private static final Random PRNG = new Random();
    public static ArrayList<String> create(int n){
        var list = new ArrayList<String>(n);

        for (int i = 0; i < 100; i++) {
            StringBuilder s = new StringBuilder(PRNG.nextInt(101));
            for (int j = 0; j < s.length(); j++) {
                char c = (char) PRNG.nextInt(32,127);
                s.append(c);
            }
            list.add(s.toString());
        }
        return list;
    }
    public static void add(ArrayList<String> list, String s){
        list.add(s);
    }
    public static void empty(ArrayList<String> list){
//        for (int i = list.size()-1; i >= 0; i--) {
//            list.remove(i);
//        }
        list.clear();
    }
    public static void display(ArrayList<String> list){
        for (var s:list) {
            System.out.printf("%s \n", s);
        }
        //System.out.println(Arrays.toString(list.toArray())+);
    }

    public static void main(String[] args) {
        var list = create(10);
        display(list);
    }
}
