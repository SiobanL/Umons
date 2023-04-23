public class MagicSquare {
    private static int[][] magicSquare;
    public MagicSquare (int n){
        int[][] magicSquare = new int[n][n];
        if (n % 2 != 0){
            magicSquare[n][n/2] = 1;
            for (int i = 0; i < magicSquare.length; i++) {
                for (int j = 0; j < magicSquare[i].length; j++) {
                    if(magicSquare[i][j] != 0){
                        if(i+1 < magicSquare.length && j+1 < magicSquare.length){
                            magicSquare[i+1][j+1] = magicSquare[i][j] + 1;
                        }
                    }
                }
            }
        }

    }
}
