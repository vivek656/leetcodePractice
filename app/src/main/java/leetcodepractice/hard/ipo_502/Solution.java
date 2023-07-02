package leetcodepractice.hard.ipo_502;

import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=502 lang=java
 *
 * [502] IPO
 */

// @lc code=start
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        var capitalpc = new PriorityQueue<int[]>((a,b) -> a[0]-b[0]);
        var profitpc = new PriorityQueue<int[]>(
            (a,b) -> b[1]-a[1]); 
            

        for (int i = 0; i < capital.length; i++) {
            capitalpc.offer(new int[]{capital[i], profits[i]});
        }
        var currentProfit = w;
        for(int i = 0; i < k; i++) { //**O(k) */
            while(!capitalpc.isEmpty() && capitalpc.peek()[0] <= currentProfit) { //n
                profitpc.offer(capitalpc.poll()); //O(lg(n))
            }
            if(profitpc.isEmpty()) break;
            currentProfit += profitpc.poll()[1]; //O(lg(n))

        }
        return currentProfit;
    }

    // public static void main(String[] args) {
    //     var sol = new Solution();

    //     System.out.println(sol.findMaximizedCapital(1, 2, new int[]{1,2,3}, new int[]{1,1,2}));
    // }
}
// @lc code=end

