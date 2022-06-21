package com.alanlee.real;

import java.util.Scanner;

/*
 * ? 给出一个数组，最多删除一个连续子数组，求剩下数组的严格递增连续子数组的最大长度
 * 
 * 
 * 9
5 3 4 9 2 8 6 7 1
out 4
先从左到右遍历，得到以每个位置i为右端点的严格上升子数组的最长长度a[i]。再从右到左遍历，动态维护一个数组b，b[i]表示长度为i+1的严格上升子数组的左端点的最大值，这个数组是严格递减的。遍历到j时，对b二分查找满足b[k]>nums[j]的k的最大值kmax，记录kmax+1+a[j]的最大值，同时记录以j为左端点的严格上升子数组的最长长度p，当p<=len(b)时，b[p-1]=max(b[p-1],nums[j])；否则把nums[j]添加到b的末尾。
https://www.nowcoder.com/discuss/947533?type=all&order=recall&pos=&page=1&ncTraceId=&channel=-1&source_id=search_all_nctrack&gio_id=E1F2A752355827A6295CD84EEB7BF212-1654055757592
https://www.nowcoder.com/discuss/947957?type=all&order=recall&pos=&page=1&ncTraceId=&channel=-1&source_id=search_all_nctrack&gio_id=E1F2A752355827A6295CD84EEB7BF212-1654055757592
https://leetcode.cn/circle/discuss/aqESuw/
*/

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
