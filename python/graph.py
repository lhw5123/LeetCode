# 用 python 实现图的深度优先搜索和广度优先搜索

# 用邻接表实现图


class Vertex:
    def __init__(self, name, v_id=0):
        self.v_id = v_id
        self.name = name
        self.visited = False
        self.connected_to = {}


class Graph:
    def __init__(self):
        self.vert_list = {}
        self.vert_nums = 0


# graph 是一个邻接表的表示方式


graph = {"A": ["B", "C"], "B": ["D", "E"], "C": ["F"], "D": [], "E": ["F"], "F": []}


# dfs 和二叉树的前序遍历类似
def dfs(graph, start):
    visited = set()
    stack = [start]  # 用列表模拟栈
    res = []

    while stack:
        node = stack.pop()
        if node not in visited:
            res.append(node)
            visited.add(node)
            stack.extend(reversed(graph[node]))

    return res


# bfs 和二叉树的层序遍历类似
def bfs(graph, start):
    visited = set()
    res = []


dfsRes = dfs(graph, "A")
print(dfsRes)
