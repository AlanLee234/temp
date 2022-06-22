package com.alanlee.real;

import java.util.HashMap;
import java.util.Scanner;

/*
? 给出一个数组，最多删除一个连续子数组，求剩下数组的严格递增连续子数组的最大长度

A1:(此方法可换方向执行)
先从左到右遍历，得到以每个位置i为右端点的严格上升子数组的最长长度a[i]。
再从右到左遍历，动态维护一个数组b，b[i]表示长度为i+1的严格上升子数组的左端点的最大值，这个数组是严格递减的。

遍历到j时，对b二分查找满足b[k]>nums[j]的k的最大值kmax，记录kmax+1+a[j]的最大值，同时记录以j为左端点的严格上升子数组的最长长度p，
当p<=len(b)时，b[p-1]=max(b[p-1],nums[j])；
否则把nums[j]添加到b的末尾。

link: lc 300子序列，可中断，dp
         *674 子串，贪心
9
5 3 4 9 2 8 6 7 1
out 4
*/
public class ByteDance_202205064 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        int n  = 9;
        // int[] nums = new int[]{5, 3, 4, 9, 2, 8, 6, 7, 1};
        // int[] nums = new int[]{5, 3, 4, 5, 2, 8, 6, 7, 1};
        int[] nums = new int[]{1, 2};

        int[] a = new int[n];
        int[] b = new int[n];
        int ans = 0;

        if (n == 0) {
            System.out.println(0);
        }
        if (n == 1) {
            System.out.println(1);
        }
        // for (int i = 0; i < n; i++) {
        //     nums[i] = sc.nextInt();
        // }

        // 每个位置i为右端点的严格上升子数组的最长长度a[i]
        a[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]) {
                a[i] = a[i-1] + 1;
            } else {
                a[i] = 1;
            }
        }
        
        // index, length
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        // b[i]表示长度为i+1的严格上升子数组的左端点的最大值
        b[0] = nums[nums.length-1];
        hashMap.put(nums.length-1, b[0]);
        for (int i=nums.length-2; i>=0; i--) {
            int chuan = 1;
            if (nums[i] < nums[i+1]) {
                chuan += hashMap.get(i+1);
            }
            hashMap.put(i, chuan);
            for (int j=0; j<chuan; j++) {
                if (b[j] < nums[i]) {
                    b[j] = nums[i];
                }
            }
        }

        for (int i=0; i<nums.length; i++) {
            ans = Math.max(ans, a[i] + getMaxB(b, nums[i]));
        }
        System.out.println(ans);
        sc.close();
    }

    // 二分搜索 查找长度i，右端点最大值。
    // 因为长度越长，为这个长度的右端点肯定越小，所以单调递减
    public static int getMaxB(int[] b, int num) {
        // for(int i=0; i<b.length; i++) {
        // if(b[i]>num) {
        // res = i+1;
        // }
        // }

        // 尽量往右，保证b>num
        int left = 0;
        int right = b.length-1;
        while (left < right) { // end left = right
            int mid = left + (right - left) / 2;
            if (b[mid] > num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(left + " " + right);
        return left;
    }
}
