/*
 * @lc app=leetcode.cn id=207 lang=cpp
 *
 * [207] 课程表
 */
class Solution {
public:
    // 进行拓扑排序（TopSort）。
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        if (prerequisites.empty())
            return true;
        // flag 数组用来判断结点访问状态。
        // -1: 正在遍历；0: 还没有遍历；1: 从当前结点开始的拓扑无环。
        vector<int> flag(numCourses, 0);
        vector<vector<int>> tmp(numCourses);
        for (int i = 0; i < prerequisites.size(); i++)
            tmp[prerequisites[i][0]].push_back(prerequisites[i][1]);
        bool ans = true;
        for (int i = 0; i < numCourses; i++)
            ans = ans && dfs(i, flag, tmp);
        return ans;
    }

    /**
     * 深度优先遍历图 tmp。
     * 
     * @return true: 没有环；false: 有环。
     */
    bool dfs(int v, vector<int>& flag, vector<vector<int>>& tmp)
    {
        if (flag[v] == -1)  // 代表有环。
            return false;

        if (flag[v] == 1)   // 可以确定从这个结点出发没有回路。
            return true;

        flag[v] = -1;   // 代表正在访问。
        for (int j = 0; j < tmp[v].size(); ++j)
        {
            if (!dfs(tmp[v][j], flag, tmp))
                return false;
        }
        flag[v] = 1;    // 从当前结点出发的每一个结点都访问完了，没有出现回路。
        return true;
    }
};

