package com.alanlee.real;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
？给定一组字符串，判断是否存在一个字符串是其他字符串的前缀。
*/

public class ByteDance_202205062 {

     // https://www.nowcoder.com/discuss/947555?type=all&order=recall&pos=&page=1&ncTraceId=&channel=-1&source_id=search_all_nctrack&gio_id=E1F2A752355827A6295CD84EEB7BF212-1654055757592
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            int t = sc.nextInt();
            long[] nums = new long[t];
            Set<Long> numsSet = new HashSet<Long>();
            for(int j=0;j<t;j++){
                nums[j]= sc.nextLong();
                numsSet.add(nums[j]);
            }
            boolean ans = check(nums, numsSet);
            System.out.println(ans);
        }
        sc.close();
    }
    public static boolean check(long[] nums, Set<Long> numsSet){
        int t = nums.length;  
        for (int j = 0; j < t; ++j) {
            long val = nums[j] / 10;
            while (val>0) {
                if (numsSet.contains(val)) {
                    return true;
                }
                else {
                    val /= 10;
                }
            }
        }
        return false;
    }


}
