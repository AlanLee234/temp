package com.alanlee.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start
class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        int pLen = p.length();
        int sLen = s.length();
        int left = 0;
        int right = 0;
        int count = 26;
        List<Integer> ans = new ArrayList<>();
        int[] need = new int[26]; // 当前状态

        for (int i = 0; i < pLen; i++) {
            // 有多少个字母不满足数量
            if ( need[p.charAt(i) - 'a'] == 0) {
                count--;
            }
            need[p.charAt(i) - 'a']--;
        }

        while (right < sLen) {
            // 每次更改need的前后都要判断，当增加时，破坏平衡状态，就要减少已完成字母
            if(need[s.charAt(right) - 'a'] == 0) {
                count--;
            }
            need[s.charAt(right) - 'a']++;
            if (need[s.charAt(right) - 'a'] == 0) {
                count++;
                if (count == 26) {
                    ans.add(left);
                }
            }
            right++;

            while (right - left > pLen) {
                if(need[s.charAt(left) - 'a'] == 0) {
                    count--;
                }
                need[s.charAt(left) - 'a']--;
                if (need[s.charAt(left) - 'a'] == 0) {
                    count++;
                    if (count == 26) {
                        ans.add(left + 1);
                    }
                }
                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution438 sol = new Solution438();
        List<Integer> ans = sol.findAnagrams("cbaebabacd", "abc");
    }
}
// @lc code=end

