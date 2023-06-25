public class DroiteTest {

    private static void testHorizontale(Droite d, String n) {
        if (d.isHorizontal()) {
            System.out.println(n + " est horizontale");
        }
    }

    private static void testIntersection(Droite d1, Droite d2, String n1, String n2) {
        Point inter = d1.intersection(d2);
        if (inter == null) {
            System.out.println("Les droites "+n1+" et "+n2+" sont parallèles");
        }
        else {
            System.out.println("Intersection de "+n1+" et "+n2+" : "+inter);
        }
    }

    public static void main(String[] args) {

        Point p1 = new Point(1, 1);
        Point p2 = new Point(5, 3);
        Point p3 = new Point(0, 4);
        Point p4 = new Point(4, 6);

        Droite d1 = new Droite(0, 1, -2);
        Droite d2 = Droite.create(p1, p2);
        Droite d3 = Droite.create(p3, p4);

        testHorizontale(d1, "d1");
        testHorizontale(d2, "d2");
        testHorizontale(d3, "d3");

        testIntersection(d1,d2,"d1","d2");
        testIntersection(d1,d3,"d1","d3");
        testIntersection(d2,d3,"d2","d3");
    }
}
