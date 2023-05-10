public class TrafficLightTest
{
    public static void main(String args[])
    {
        TrafficLight light = new TrafficLight();
        light.add(new Car("m1", "ERR404"));
        light.add(new Car("m2", "TESTIN"));
        light.add(new Bicycle("v1", "red"));
        light.add(new Bicycle("v2", "red"));
        light.add(new Car("m2", "OTHER"));
        System.out.println(light);
    }
}
