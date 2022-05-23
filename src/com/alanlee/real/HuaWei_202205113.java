package com.alanlee.real;

import java.util.Arrays;
import java.util.Scanner;

public class HuaWei_202205113 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
//        int n =  sc.nextInt();
//        int[][] grid = new int[n][n];
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                grid[i][j] = sc.nextInt();
//            }
//        }
        int n=3;
        int[][] grid = new int[n][n];
        grid[0][0] = 0;grid[0][1] = 2;grid[0][2] = 1;
        grid[1][0] = 1;grid[1][1] = 0;grid[1][2] = 1;
        grid[2][0] = 1;grid[2][1] = 2;grid[2][2] = 1;

        int N = grid.length;
        int[][] dp = new int[N][N];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        dp[0][0] = grid[0][0];

        // 一共要走 2 * N - 2 步，满足横纵坐标之和为 t
        for (int t = 1; t <= 2 * N - 2; t++) {
            int[][] dp2 = new int[N][N];
            for (int[] row : dp2) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
            // 枚举第一个人可能走的横坐标
            for (int i = Math.max(0, t - (N - 1)); i <= Math.min(N - 1, t); i++) {
                // 枚举2横
                for (int j = Math.max(0, t - (N - 1)); j <= Math.min(N - 1, t); j++) {
                    // 遇到墙
//                    if (grid[i][t - i] == -1 || grid[j][t - j] == -1) {
//                        continue;
//                    }

                    int res = grid[i][t - i] >0?1:0;
                    if (i != j) {
                        // 不重合的时候加上另一个坐标
                        res += grid[j][t - j] >0?1:0;
                    }else{
                        res += grid[j][t - j]-1 >0?1:0;
                    }
                    System.out.println(i+" " +j + " "+ res);

                    // 枚举上一步的坐标，更新dp
                    for (int pi = i - 1; pi <= i; pi++) {
                        for (int pj = j - 1; pj <= j; pj++) {
                            if (pi >= 0 && pj >= 0) {
                                dp2[i][j] = Math.max(dp2[i][j], dp[pi][pj] + res);
                            }
                        }
                    }
                }
            }
            dp = dp2;
        }
        System.out.println(Math.max(0, dp[N - 1][N - 1]));
    }
}
