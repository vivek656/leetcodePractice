package leetcodepractice.easy.flood_fill_733;
/*
 * @lc app=leetcode id=733 lang=java
 *
 * [733] Flood Fill
 *
 * https://leetcode.com/problems/flood-fill/description/
 *
 * algorithms
 * Easy (61.54%)
 * Likes:    6561
 * Dislikes: 655
 * Total Accepted:    662K
 * Total Submissions: 1.1M
 * Testcase Example:  '[[1,1,1],[1,1,0],[1,0,1]]\n1\n1\n2'
 *
 * An image is represented by an m x n integer grid image where image[i][j]
 * represents the pixel value of the image.
 * 
 * You are also given three integers sr, sc, and color. You should perform a
 * flood fill on the image starting from the pixel image[sr][sc].
 * 
 * To perform a flood fill, consider the starting pixel, plus any pixels
 * connected 4-directionally to the starting pixel of the same color as the
 * starting pixel, plus any pixels connected 4-directionally to those pixels
 * (also with the same color), and so on. Replace the color of all of the
 * aforementioned pixels with color.
 * 
 * Return the modified image after performing the flood fill.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation: From the center of the image with position (sr, sc) = (1, 1)
 * (i.e., the red pixel), all pixels connected by a path of the same color as
 * the starting pixel (i.e., the blue pixels) are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally
 * connected to the starting pixel.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
 * Output: [[0,0,0],[0,0,0]]
 * Explanation: The starting pixel is already colored 0, so no changes are made
 * to the image.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == image.length
 * n == image[i].length
 * 1 <= m, n <= 50
 * 0 <= image[i][j], color < 2^16
 * 0 <= sr < m
 * 0 <= sc < n
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        return floodFillRecursive(image, sr, sc, color, image[sr][sc]);
        
    }

    private int[][] floodFillRecursive(int[][] image, int sr, int sc, int color, int initialColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length
        || image[sr][sc]==color || image[sr][sc]!=initialColor) {

            return image;
        }
        image[sr][sc]=color;
        floodFillRecursive(image, sr - 1, sc, color,initialColor);
        floodFillRecursive(image, sr + 1, sc, color,initialColor);
        floodFillRecursive(image, sr, sc - 1, color,initialColor);
        floodFillRecursive(image, sr, sc + 1, color,initialColor);
        return image;
    }


}
// @lc code=end

