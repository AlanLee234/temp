package com.alanlee.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=887 lang=java
 *
 * [887] 鸡蛋掉落
 */

 /*
 ref:经典动态规划：高楼扔鸡蛋  labuladong
 */
// @lc code=start
class Solution {
    Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public int superEggDrop(int k, int n) {
        return dp(k, n);
    }

    public int dp(int k, int n) {
        // k egg | n build
        if(k == 1) {
            return n;
        }
        if(n == 0) {
            return 0;
        }
        if(memo.containsKey(n*100+k)){
            return memo.get(n*100+k);
        }
        
        int res = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++){
            res = Math.min(res, Math.max(dp(k-1, i-1), dp(k, n-i)))+1;
        }
        memo.put(n*100+k, res);
        return res;
    }
}
// @lc code=end

