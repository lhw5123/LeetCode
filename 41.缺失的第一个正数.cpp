/*
 * @lc app=leetcode.cn id=41 lang=cpp
 *
 * [41] 缺失的第一个正数
 */
class Solution {
public:
    int firstMissingPositive(vector<int>& nums) {
        int i;
        int n = nums.size();
        int * B = (int *) malloc(sizeof(int) * n);
        memset(B, 0, sizeof(int) * n);
        for (i = 0; i < n; ++i)
        {
            if (nums[i] > 0 && nums[i] <= n)
                B[nums[i] - 1] = 1;
        }
        for (i = 0; i < n; i++)
        {
            if (B[i] == 0)
                break;
        }
        return i + 1;
    }
};

