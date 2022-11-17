package com.xiejin.leetcode.problem;

/**
 * Created by jin.xie on 2022/09/02
 */
public class Number42 {

    public static int trap(int[] height) {
        int[] dp = new int[height.length + 1];
        dp[0] = 0;
        int curMax = 1;
        boolean cache = false;
        int cacheNum = 0;
        for (int i = 0; i < height.length; i++) {
            int h = height[i];
            if (h <= curMax) {
                if (cache) {
                    cacheNum += curMax - h;
                }
                dp[i + 1] = dp[i];
                continue;
            }
            if (cacheNum == 0) {
                cache = true;
            } else {
                cache = false;
            }

            dp[i + 1] = dp[i] + (h - curMax) + cacheNum;
            curMax = h;
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int[] height = new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int area = trap(height);
        System.out.println(area);
    }
}
