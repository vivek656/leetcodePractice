package leetcodepractice.medium.longest_palindromic_substring;
/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start

import java.util.Comparator;
import java.util.List;

class Solution {
    public String longestPalindrome(String s) {
        int[] maxPair = { 0, 0 };
        palindromeAndLength(s, 0, s.length() - 1, new Boolean[s.length()][s.length()], maxPair);
        return s.substring(maxPair[0], maxPair[1] + 1);
    }

    private void palindromeAndLength(String s, int start, int end, Boolean[][] store, int[] maxStartEnd) {
        if (store[start][end] != null)
            return;
        int currentMaxLen = maxStartEnd[1] - maxStartEnd[0];
        if (start == end) {
            store[start][end] = true;
            return;
        }
        var endStartEqual = s.charAt(start) == s.charAt(end);
        if (end - start == 1) {
            if (endStartEqual) {
                store[start][end] = true;
                if (currentMaxLen < 1) {
                    maxStartEnd[0] = start;
                    maxStartEnd[1] = end;
                }
            } else {
                store[start][end] = false;
            }
            return;
        }
        /*
         * f(i,j) = Max(
         * f(i+1, j-1), f(i, j-1) , f(i+1, j) , if(i+1,j-1)ispalindrome then j-i
         * )
         */
        if (store[start + 1][end - 1] == null)
            palindromeAndLength(s, start + 1, end - 1, store, maxStartEnd);
        if (endStartEqual && store[start + 1][end - 1] == Boolean.TRUE) {
            store[start][end] = true;
            if (currentMaxLen < end - start) {
                maxStartEnd[0] = start;
                maxStartEnd[1] = end;
            }
            return;
        } else {
            store[start][end] = false;
        }
        if (store[start + 1][end] == null)
            palindromeAndLength(s, start + 1, end, store, maxStartEnd);

        if (store[start][end - 1] == null)
            palindromeAndLength(s, start, end - 1, store, maxStartEnd);

    }
}

// @lc code=end
