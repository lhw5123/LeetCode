/*
 * @lc app=leetcode.cn id=133 lang=cpp
 *
 * [133] 克隆图
 */
/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;

    Node() {}

    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
/**
 * 思路：其实是对图的遍历，可以用 BFS 或 DFS。
 */
class Solution {
public:
    // map 是 C++ STL 提供的容器。用来存放 node 对应的拷贝结点。
    map<Node*, Node*> mp;
    Node* cloneGraph(Node* node) {
        if (!node)  return NULL;
        // map.count(k) 返回 k 有没有对应的 v，固定返回 1 或 0。
        if (mp.count(node))    return mp[node];
        Node* c = new Node(node -> val);
        mp[node] = c;
        for (int i = 0; i < node -> neighbors.size(); ++i)
        {
            if (node -> neighbors[i])
                // a.push_back(t) 将 t 插入到 a.end() 前面。
                c -> neighbors.push_back(cloneGraph(node -> neighbors[i]));
        }
        return c;
    }
};

