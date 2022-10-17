import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (sc.hasNextInt()) {
            String str = sc.nextLine();
            String[] s = str.split(" ");
            System.out.println(Integer.parseInt(str.substring(2, str.length()), 16));
        }
        sc.close();
    }
}
