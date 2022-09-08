import java.util.*;

public class App {
    public static void main(String[] args) {    
        /*
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            String s = sc.nextLine();
            System.out.println(Integer.parseInt(s.substring(2,s.length()),16));
        }
        sc.close();
        */      
    }

    public static int[][] inputMatrix(Scanner sc, int m, int n) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }
}