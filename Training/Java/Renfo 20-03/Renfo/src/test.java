public class test {
    public int h = 5;
    public static int x = 16;
    public static int move(int h){
        System.out.println((x = x+ h));
        return h;
    }

    public static void main(String[] args) {
        move(10);
    }
}
