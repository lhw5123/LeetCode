class Solution:
    def smallestEquivalentString(self, s1: str, s2: str, baseStr: str) -> str:
        parent = {}

        # 并查集中的路径压缩查找算法
        def find(x):
            if x not in parent:
                parent[x] = x  # 如果第一次访问 x，就把 x 的 parent 指向自己
            while parent[x] != x:
                parent[x] = parent[parent[x]]
                x = parent[x]
            return x

        # 合并两个字符集合，确保根节点是最小字典序
        def union(x, y):
            root_x = find(x)
            root_y = find(y)
            if root_x != root_y:
                if root_x < root_y:
                    parent[root_y] = root_x
                else:
                    parent[root_x] = root_y

        for a, b in zip(s1, s2):
            union(a, b)

        res = []
        for char in baseStr:
            res.append(find(char))

        return "".join(res)
