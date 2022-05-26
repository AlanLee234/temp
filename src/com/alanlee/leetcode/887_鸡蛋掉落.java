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
class Solution887 {
    Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public int superEggDrop(int k, int n) {
        return dp2(k, n);
    }

    // 二分
    public int dp2(int k, int n) {
        if (!memo.containsKey(n * 100 + k)) {
            int ans;
            if (n == 0) {
                ans = 0;
            } else if (k == 1) {
                ans = n;
            } else {
                int lo = 1, hi = n;
                while (lo + 1 < hi) {
                    int x = (lo + hi) / 2;
                    int t1 = dp(k - 1, x - 1);
                    int t2 = dp(k, n - x);

                    if (t1 < t2) {
                        lo = x;
                    } else if (t1 > t2) {
                        hi = x;
                    } else {
                        lo = hi = x;
                    }
                }

                ans = 1 + Math.min(Math.max(dp2(k - 1, lo - 1), dp2(k, n - lo)), Math.max(dp2(k - 1, hi - 1), dp2(k, n - hi)));
            }

            memo.put(n * 100 + k, ans);
        }

        return memo.get(n * 100 + k);
    }
// 链接：https://leetcode.cn/problems/super-egg-drop/solution/ji-dan-diao-luo-by-leetcode-solution-2/


    // 逆向思维:给你 K 个鸡蛋，测试 m 次，最坏情况下最多能测试 N 层楼
    public int superEggDrop1(int k, int n) {
        if (n == 1) {
            return 1;
        }
        int[][] f = new int[n + 1][k + 1];
        for (int i = 1; i <= k; ++i) {
            f[1][i] = 1;
        }
        int ans = -1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= k; ++j) {
                // dp[k][m - 1] 就是楼上的楼层数，因为鸡蛋个数 k 不变，也就是鸡蛋没碎，扔鸡蛋次数 m 减一；
                // dp[k - 1][m - 1] 就是楼下的楼层数，因为鸡蛋个数 k 减一，也就是鸡蛋碎了，同时扔鸡蛋次数 m 减一。
                f[i][j] = 1 + f[i - 1][j - 1] + f[i - 1][j];
            }
            if (f[i][k] >= n) {
                ans = i;
                break;
            }
        }
        return ans;
    }


    // 会超时
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
            // 如果鸡蛋碎了，那么鸡蛋的个数 K 应该减一，搜索的楼层区间应该从 [1..N] 变为 [1..i-1] 共 i-1 层楼；
            // 如果鸡蛋没碎，那么鸡蛋的个数 K 不变，搜索的楼层区间应该从 [1..N] 变为 [i+1..N] 共 N-i 
            res = Math.min(res, Math.max(dp(k-1, i-1), dp(k, n-i))+1);
        }
        memo.put(n*100+k, res);
        return res;
    }
}
// @lc code=end

