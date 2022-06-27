package com.alanlee.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

/*
  ! 因为是求所有可能，所以一定是要穷举的，就是要回溯，但是要优化
  A1:回溯 + 记忆化搜索
  A2:
 */

// @lc code=start
class Solution131 {
    int[][] f;
    List<List<String>> ret = new ArrayList<List<String>>();
    List<String> ans = new ArrayList<String>();
    int n;

    public List<List<String>> partition(String s) {
        n = s.length();
        f = new int[n][n];
        dfs(s, 0);
        return ret;
    }

    public void dfs(String s, int index) {
        if (index == n) {
            ret.add(new ArrayList<String>(ans));
            return;
        }
        
        for (int i = index; i<n; i++) {
            System.out.println("index" + index + "i" + i);
            if (isPalindrome(s, index, i) == 1) {
                ans.add(s.substring(index, i + 1));
                dfs(s, i + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }

     // 记忆化搜索中，f[i][j] = 0 表示未搜索，1 表示是回文串，-1 表示不是回文串
    public int isPalindrome(String s, int i, int j) {
        System.out.println(i + " " +j);
        if (f[i][j] != 0) {
            return f[i][j];
        }

        // 当>时，已经执行完
        if (i >= j) {
            f[i][j] = 1;
        } else if (s.charAt(i) == s.charAt(j)) {
            f[i][j] = isPalindrome(s, i + 1, j - 1);
        } else {
            f[i][j] = -1;
        }
        return f[i][j];
    }
}

class Solution131dp {
    boolean[][] f;
    List<List<String>> ret = new ArrayList<List<String>>();
    List<String> ans = new ArrayList<String>();
    int n;

    public List<List<String>> partition(String s) {
        n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(f[i], true);
        }

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                // 状态转移，也可以理解为记忆化搜索
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }

        dfs(s, 0);
        return ret;
    }

    public void dfs(String s, int i) {
        if (i == n) {
            ret.add(new ArrayList<String>(ans));
            return;
        }
        for (int j = i; j < n; ++j) {
            if (f[i][j]) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }
}
// @lc code=end
