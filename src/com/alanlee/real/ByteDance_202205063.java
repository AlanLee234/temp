package com.alanlee.real;

import java.util.Scanner;

public class ByteDance_202205063 {
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
}
