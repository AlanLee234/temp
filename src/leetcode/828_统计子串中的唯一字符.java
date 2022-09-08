package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=828 lang=java
 *
 * [828] 统计子串中的唯一字符
 */

// @lc code=start
class Solution828 {
    List<String> set;
    int ans;

    // 分为不重复和重复讨论
    // 对于重复的字符，在所有字串中出现的次数=(某元素下标位置 - head) * (tail - 某元素下标位置)
    public int uniqueLetterString(String s) {
        Map<Character, List<Integer>> index = new HashMap<Character, List<Integer>>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!index.containsKey(c)) {
                index.put(c, new ArrayList<Integer>());
                index.get(c).add(-1);
            }
            index.get(c).add(i);
        }
        int res = 0;
        for (Map.Entry<Character, List<Integer>> entry : index.entrySet()) {
            List<Integer> arr = entry.getValue();
            arr.add(s.length());
            for (int i = 1; i < arr.size() - 1; i++) {
                res += (arr.get(i) - arr.get(i - 1)) * (arr.get(i + 1) - arr.get(i));
            }
        }
        return res;
    }

    // x 超时
    public int uniqueLetterStringX(String s) {
        // BuildTime = 2022-09-06 18:43:56
        // 全排列+计算唯一字符
        set = new ArrayList<>();
        ans = 0;
        for (int i = 0; i<s.length();i++) {
            backTrack(s, i, new StringBuilder(String.valueOf(s.charAt(i))));
        }
        return ans;
    }

    private void backTrack(String s, int start, StringBuilder sb) {
        set.add(sb.toString());
        ans += countUniqueChars(sb.toString());
        
        if (start+1 < s.length()) {
            sb.append(s.charAt(start+1));
            backTrack(s, start+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    private int countUniqueChars(String s) {
        int res = 0;
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'A']++;
        }
        for (int i = 0; i < num.length; i++) {
            if (num[i] == 1) {
                res++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution828 sol = new Solution828();
        sol.uniqueLetterString("ABC");
    }
}
// @lc code=end

