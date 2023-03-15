public class ExoCmd {
    public static void main(String[] args) {
        if (args.length < 2){
            System.out.printf("Error: I need two int params for run and you have passed %d params", args.length);
            System.exit(0);
        }
        int[] tempArgs = new int[args.length];
        for (int i = 0; i < tempArgs.length; i++) {
            tempArgs[i] = Integer.parseInt(args[i]);
        }
        System.out.printf("The sum of your args is: %d\n", ExoTableau.sum(tempArgs));
        System.out.printf("The average of your args is %.2f", ExoTableau.average(tempArgs));
    }
}
