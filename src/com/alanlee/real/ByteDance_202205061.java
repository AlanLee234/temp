package com.alanlee.real;

import java.util.Scanner;

public class ByteDance_202205061 {
    /*
    ？叠加buff，分别输入获得时间和持续时间，求总共有buff的时长
    https://leetcode-cn.com/circle/discuss/aqESuw/
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] time = new int[n];
        int[] dur = new int[n];
        int count =0;
        int right =0;
        if(n==0){
            System.out.println(0);
            return;
        }

        for(int i=0;i<n;i++){
            time[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            dur[i] = sc.nextInt();
        }
       if(n==1){
            System.out.println(dur[0]);
            return;
        }
        /* x other ans
        for (int i = 0; i < time.length - 1; i++) {
            for (int j = 0; j < time.length - 1 - i; j++) {
                // 前后比较
                if (time[j] > time[j + 1]) {
                    int temp = time[j + 1];
                    time[j + 1] = time[j];
                    time[j] = temp;
                    int temp1 = dur[j + 1];
                    dur[j + 1] = dur[j];
                    dur[j] = temp1;
                }
            }
        }

        // exam ans
        right = time[0] + dur[0]-1;
        for(int i=1;i<n;i++){
            if(time[i]>right){
                count += dur[i-1]-time[i-1]+1;
            }else{
                count += time[i]-time[i-1];
            }
            right = time[i]+dur[i]-1;
            if(i==n-1){
                count += dur[i];
            }
        }
        */
        right = time[0] + dur[0];
        for(int i=1;i<n;i++){
            if(time[i]>=right){
                count += dur[i-1];
            }else{
                count += time[i]-time[i-1];
            }
            right = time[i];
            if(i==n-1){
                count += dur[i];
            }
        }        
        System.out.println(count);        
        sc.close();
    }
}
