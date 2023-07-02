package leetcodepractice.hard.median_of_two_sorted_arrays_4;

/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (35.87%)
 * Likes:    22007
 * Dislikes: 2485
 * Total Accepted:    1.8M
 * Total Submissions: 5M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return
 * the median of the two sorted arrays.
 * 
 * The overall run time complexity should be O(log (m+n)).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -10^6 <= nums1[i], nums2[i] <= 10^6
 * 
 * 
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        var totalLen = (nums1.length + nums2.length);
        var medianPos = totalLen/2;
        var resArray = (totalLen%2==0)? new int[2] : new int[1];
        var nums2pos = 0;
        var nums1pos = 0;
        for(int i = 0 ; i <= medianPos ; i++){
            if((nums2pos < nums2.length) &&( (nums1pos >= nums1.length) || nums2[nums2pos] < nums1[nums1pos])){
                resArray[i%resArray.length] = nums2[nums2pos++];
            }else if(nums1pos < nums1.length){
                resArray[i%resArray.length] = nums1[nums1pos++];
            }
        }
        return totalLen%2 ==0 ? (resArray[0]+resArray[1]) / 2.0 : resArray[0];

    }
    public static void main(String[] args) {
        var solution = new Solution();
        var nums1 = new int[]{2,3};
        var nums2 = new int[]{1};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
}
// @lc code=end

