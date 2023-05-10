public class DroiteTest {
    public static String testHorizontal(Droite droiteTest){
        if (droiteTest.isHorizontal()){
            return droiteTest.toString() + " is horizontal";
        }
        else{
            return droiteTest.toString() + " isn't horizontal";
        }
    }
    public static String testIntersection(Point p){
        if(p == null){
            return "Les droites et sont parallèles ou parallèles confondues";
        }
        else{
            return p.toString();
        }
    }
    public static void main(String[] args) {
        Point p1 = new Point(1,1);
        Point p2 = new Point(5,3);
        Point p3 = new Point(0,4);
        Point p4 = new Point(4,6);

        Droite d1 = new Droite(0,1,2);
        Droite d2 = Droite.create(p1,p2);
        Droite d3 = Droite.create(p3,p4);

        System.out.printf("%s\n", testHorizontal(d2));
        System.out.printf("%s\n", testHorizontal(d3));
        System.out.printf("%s\n",testIntersection(d1.intersection(d2)));
        System.out.printf("%s\n",testIntersection(d1.intersection(d3)));
        System.out.printf("%s\n",testIntersection(d2.intersection(d3)));
    }
}
