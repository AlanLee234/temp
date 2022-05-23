package com.alanlee.real;

import java.util.Scanner;

public class ByteDance_202205062 {
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            int t = sc.nextInt();
            long[] nums = new long[t];
            for(int j=0;j<t;j++){
                nums[j]= sc.nextLong();
            }
            
        }
//         System.out.println(ans);
    }

     /*
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            int t = sc.nextInt();
            long[] nums = new long[t];
            for(int j=0;j<t;j++){
                nums[j]= sc.nextLong();
            }
            check(nums);
        }
//         System.out.println(ans);
    }
    public static void check(long[] nums){     
        System.out.println("NO");
    }
    */

}
