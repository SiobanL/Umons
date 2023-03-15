class ExoCmd {
    public static void main(String args[]) {
        if (args.length < 2) {
            System.out.println("Please input at least two values");
        }
        else {
            int[] vals = new int[args.length];
            for (int i = 0; i < args.length; ++i) {
                vals[i] = Integer.parseInt(args[i]);
            }
            System.out.println("Sum : "+ExoTableau.somme(vals));
            System.out.println("Avg : "+ExoTableau.moyenne(vals));
        }
    }
}
