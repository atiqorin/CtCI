import java.util.*;

public class ZeroMatrix {
    public static void zerofy(int[][] mat){
        boolean[] row = new boolean[mat.length];
        boolean[] col = new boolean[mat[0].length];

        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for(int i = 0; i < row.length;i++){
            if(row[i]){
                nullifyRow(mat, i);
            }
        }        
        for(int i = 0; i < col.length;i++){
            if(col[i]){
                nullifyCol(mat, i);
            }
        }
    }

    public static void nullifyRow(int[][] mat, int row){
        for(int i = 0; i < mat[0].length; i++){
            mat[row][i] = 0;
        }
    }
    public static void nullifyCol(int[][] mat, int col){
        for(int i = 0; i < mat.length; i++){
            mat[i][col] = 0;
        }
    }
    public static int[][] generateMatrix(int n){
        int[][] mat = new int[n][n];

        for(int[] row : mat){
            for(int i=0; i<row.length;i++) {
                row[i] = (int)(Math.random()* 50);
            }
        }
        return mat;
    }

    public static void putRandomZeros(int[][] mat, int percentage){
        for(int[] row : mat){
            for(int i = 0; i < row.length; i++){
                row[i] = (int)(Math.random()*100) < percentage ? 0 : row[i];
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[][] mat = generateMatrix(sc.nextInt());
        putRandomZeros(mat, sc.nextInt());

        for(int[] row : mat){
            for(int i : row) {
                System.out.printf("\t%d", i);
            }
            System.out.println();
        }
        System.out.println("--------------------------------");
        zerofy(mat);
        for(int[] row : mat){
            for(int i : row) {
                System.out.printf("\t%d", i);
            }
            System.out.println();
        }
    }
}