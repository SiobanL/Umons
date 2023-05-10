package Exo2;
import java.util.ArrayList;
public class Test {
    public static void main(String[] args) {
        Car car1 = new Car("123-ABC","VW");
        Car car2 = new Car("456-DEF","BMW");
        Car car3 = new Car("789-GHI","AUDI");
        Bicycle bicycle1 = new Bicycle("RED", "ROCKRIDER");
        Bicycle bicycle2 = new Bicycle("YELLOW", "ROCKRIDER");
        Bicycle bicycle3 = new Bicycle("ORANGE", "ROCKRIDER");
        TrafficLight queue = new TrafficLight(new ArrayList<Vehicule>());
        queue.add(car1);
        queue.add(bicycle2);
        queue.add(car3);
        queue.add(car2);
        queue.add(bicycle1);
        queue.add(bicycle3);
        System.out.printf("%s",queue.toString());
    }
}
