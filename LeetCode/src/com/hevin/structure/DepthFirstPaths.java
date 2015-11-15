package com.hevin.structure;

import java.util.Stack;

/**
 * 深度优先搜索图
 */
public class DepthFirstPaths {
    private boolean[] marked;   // 这个顶点被搜索过吗
    private int[] edgeTo;       // 从起点到一个顶点的已知路径上的最后一个顶点
    private final int s;        // 起点

    public DepthFirstPaths(Graph graph, int s) {
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        this.s = s;
    }

    /**
     * 深度优先搜索
     * @param graph
     * @param v
     */
    private void dfs(Graph graph, int v) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(graph, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
