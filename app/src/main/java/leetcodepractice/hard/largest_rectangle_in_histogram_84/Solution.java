package leetcodepractice.hard.largest_rectangle_in_histogram_84;
/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] firstLowerTowerThanIndexOnLeft = new int[heights.length];
        Deque<Integer> towerIndexStack = new LinkedList<>();
        for(int i = 0 ;  i < heights.length ; i++){
            while(!towerIndexStack.isEmpty() && heights[towerIndexStack.peek()] >= heights[i]){
                towerIndexStack.pop();
            }
            if(towerIndexStack.isEmpty()){
                firstLowerTowerThanIndexOnLeft[i] = -1;
            }else{
                firstLowerTowerThanIndexOnLeft[i] = towerIndexStack.peek();
            }
            towerIndexStack.push(i);
        }
        towerIndexStack.clear();
        int[] firstLowerTowerThanIndexOnRight = new int[heights.length];
        for(int i = heights.length-1 ;  i >= 0 ; i--){
            while(!towerIndexStack.isEmpty() && heights[towerIndexStack.peek()] >= heights[i]){
                towerIndexStack.pop();
            }
            if(towerIndexStack.isEmpty()){
                firstLowerTowerThanIndexOnRight[i] = heights.length;
            }else{
                firstLowerTowerThanIndexOnRight[i] = towerIndexStack.peek();
            }
            towerIndexStack.push(i);
        }
        Integer maxValue = 0;
        for(int i = 0 ; i < heights.length ; i++){
            var height = heights[i];
            var breadth = (i - firstLowerTowerThanIndexOnLeft[i]) + (firstLowerTowerThanIndexOnRight[i] -i) - 1;
            maxValue = Integer.max(maxValue, height*breadth);
        }
        return maxValue;
        
    }
}
// @lc code=end

