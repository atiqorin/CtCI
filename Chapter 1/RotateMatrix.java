import java.util.*;

public class RotateMatrix {
    public static int[][] rotate(int[][] mat){
        if(mat.length != mat[0].length) return null;
        int n = mat.length;
        for(int layer = 0; layer < n/2; layer++){
            int first = layer;
            int last = n - layer - 1;
            for(int i = first; i < last; i++){
                int offset = i - first;
                int top = mat[first][i];
                mat[first][i] = mat[last - offset][first];
                mat[last - offset][first] = mat[last][last - offset];
                mat[last][last - offset] = mat[i][last];
                mat[i][last] = top;
            }
        }
        return mat;
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] mat = generateMatrix(sc.nextInt());

        for(int[] row : mat){
            for(int i : row) {
                System.out.printf("\t%d", i);
            }
            System.out.println();
        }

        System.out.println("------------");
        mat = rotate(mat);
        for(int[] row : mat){
            for(int i : row) {
                System.out.printf("\t%d", i);
            }
            System.out.println();
        }
    }
}