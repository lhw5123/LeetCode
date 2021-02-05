/*
 * @lc app=leetcode.cn id=733 lang=cpp
 *
 * [733] 图像渲染
 */

// @lc code=start
class Solution {
public:
    const int dx[4] = {1,0,0,-1};
    const int dy[4] = {0,1,-1,0};
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        // BFS
        int currentColor = image[sr][sc];
        if (currentColor == newColor) return image;

        int n = image.size(), m = image[0].size();
        queue<pair<int, int>> que;
        que.emplace(sr, sc);
        image[sr][sc] = newColor;
        while (!que.empty()) {
            int x = que.front().first, y = que.front().second;
            que.pop();
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < n && my < m && image[mx][my] == currentColor) {
                    que.emplace(mx, my);
                    image[mx][my] = newColor;
                }
            }
        }
        return image;
    }
};
// @lc code=end

