package leetcodepractice.easy.is_subsequence_392;
/*
 * @lc app=leetcode id=392 lang=java
 *
 * [392] Is Subsequence
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
        var currentVal = 0;
        var length = s.length();
        if(length==0)return true;
        for(int i =0 , len = t.length() ; i < len ; i++) {
            if(s.charAt(currentVal) == t.charAt(i)) currentVal++;
            if(currentVal==length)return true;
        }
        return false;
    }

}
// @lc code=end

