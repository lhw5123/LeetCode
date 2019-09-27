/*
 * @lc app=leetcode.cn id=11 lang=cpp
 *
 * [11] 盛最多水的容器
 */
class Solution {
public:
    int maxArea(vector<int>& height) {
        // 思路：双指针法。
        int maxarea = 0, l = 0, r = height.size() - 1;
        while (l < r)
        {
            if (height[l] <= height[r])
            {
                maxarea = max(maxarea, (r - l) * height[l]);
                ++l;
            }
            else if (height[l] > height[r]) 
            {
                maxarea = max(maxarea, (r - l) * height[r]);
                --r;
            }
        }
        return maxarea;       
    }
};

