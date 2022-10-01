

import java.util.ArrayList;
import java.util.Scanner;

class CMB_20220929_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 8;
        int a = 2; // 0
        int b = 3; // 1
        ans = 0;
        String str = "10111000";
        int[][] dp = new int[n][2];
        for(int i = 0;i<a-1;i++) {
            dp[i][0] = -1;
        }
        for(int i = 0;i<b-1;i++) {
            dp[i][1] = -1;
        }
        dp[a-1][0] = find(str, 0, a, '0');
        dp[b-1][1] = find(str, 0, b, '1');
        
        System.out.println(ans);
        sc.close();
    }

    // find [left,right)中需要改为t的个数
    public static int find(String str, int left, int right, char t) {
        int res = 0;
        while(left<right) {
            if (t != str.charAt(left)) {
                res++;
            }
            left++;
        }
        return res;
    }

    static int ans;
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt(); // 0
        int b = sc.nextInt(); // 1
        ans = 0;
        sc.nextLine();
        String x = sc.nextLine();
        char[] nums = x.toCharArray();
        // dfs();// nums,a,b
        int ia = -1;
        int ib = -1;
        int index=0;
        while(index<n) {
            char first = nums[index];
            int k = 0;
            for (int i=index;i<n;i++){
                if (nums[i] == first) {
                    k++;
                    k = k % (first=='0' ? a:b);
                } else {
                    first = nums[i];
                    if (k!=0) {
                        ans +=k;
                    }
                    k = 0;
                    index = i;
                    break;
                }
            }
        }   

        System.out.println(ans);
        sc.close();
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 8;
        int a = 2; // 0
        int b = 3; // 1
        ans = 0;
        String x = "10111000";
        char[] nums = x.toCharArray();
        // dfs();// nums,a,b
        int ia = -1;
        int ib = -1;
        int index=0;
        while(index<n) {
            char first = nums[index];
            int k = 0;
            for (int i=index;i<n;i++){
                if (nums[i] == first) {
                    k++;
                    k = k % (first=='0' ? a:b);
                } else {
                    first = nums[i];
                    if (k!=0) {
                        ans +=k;
                    }
                    k = 0;
                    index = i;
                    break;
                }
            }
        }   

        System.out.println(ans);
        sc.close();
    }
    
}
