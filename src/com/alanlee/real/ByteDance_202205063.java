package com.alanlee.real;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
？：完成两个任务，总共可支配时间m，给出n个任务，求能完成的最大价值
！：贪心, 先选择前两个, 如果时间不够直接返回 0. 
    从第三个开始, 判断其价值与选择的两物品的价值, 若价值更大且有足够时间替换, 优先选择价值小的进行替换, 最后价值就是答案
*/

public class ByteDance_202205063 {
    // 暴力
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] values = new int[n][2];
        for(int i = 0; i < n; i++){
            values[i][0] = sc.nextInt(); // 时间
            values[i][1] = sc.nextInt(); // 价值
        }
        // 按价值排序
        Arrays.sort(values, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (values[i][0] >= m) 
                continue;
            int tmpSum = 0;
            for (int j = i + 1; j < n; ++j) {
                tmpSum = values[i][1] + values[j][1];
                if (tmpSum <= res) 
                    break;
                if (values[i][0] + values[j][0] <= m) 
                    res = Math.max(res, tmpSum);
            }
        }
        System.out.println(res);
        sc.close();
    }

    /* exam 暴力，不完全对
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] values = new int[n][2];
        if(m==0 || m==1){
            System.out.println(0);
            return;
        }
        int ans = 0;
        int max = 10000000;
        for(int i = 0; i < n; i++){
            values[i][0]= sc.nextInt();
            if(values[i][0]<m){
                max = i;
            }
            values[i][1]=sc.nextInt();
            
//             if(values[a]>0){
//                 if(b<values[a]){
//                     values[a]=b;
//                 }
//             }else{
//                 values[a]=b;
//             }
        }
//         if(max >= 10000000){
//             max = n;
//         }
        
        for(int j=1;j<max+1;j++){
            for(int i=0;i<j;i++){
                if(values[i][0]+values[j][0]<=m && values[i][1]+values[j][1]>ans){
                    ans = values[i][1]+values[j][1];
                }
            }
        }
//         for(int j=m-1;j>0;j--){
//             for(int i=m-j;i>0&&i<j;i--){
//                 if(values[i]>0&&values[j]>0&&values[i]+values[j]>ans){
//                     ans = values[i]+values[j];
//                 }
//             }
//         }
        System.out.println(ans);
    }
    */
}
