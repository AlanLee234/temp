package com.alanlee.real;

import java.util.Scanner;

public class ByteDance_202205064 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int ans = 0;
        if(n==0){
            System.out.println(0);
        }
        if(n==1){
            System.out.println(1);
        }
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        } 
//         int left=0;
//         int right =nums.length;
        for(int right=nums.length-1;right>=1;right--){
            for(int left=0;left<right;left++){
               int[] numm = new int[nums.length -right+left-1];
            for(int i=0;i<nums.length -right+left-1;i++){
                if(i>right){
                    numm[i-right+left-1] =nums[i];
                }else if(i<left){
                    numm[i] =nums[i];
                }else{
                    continue;
                }
            }
            ans = Math.max(ans,findLengthOfLCIS( numm) );
            }
        }
//         ans = ;
        System.out.println(ans);
    }
//     public static int findLengthOfLCIS(int[] nums,int left,int right) {
//         int ans = 0;
//         int n = right+1;
//         int start = 0;
//         for (int i = left; i < n; i++) {
//             if (i > 0 && nums[i] <= nums[i - 1]) {
//                 start = i;
//             }
//             ans = Math.max(ans, i - start + 1);
//         }
//         return ans;
//     }
    public static int findLengthOfLCIS(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] <= nums[i - 1]) {
                start = i;
            }
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }
}
