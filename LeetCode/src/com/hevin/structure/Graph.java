package com.hevin.structure;

/**
 * 抽象数据类型-图
 */
public class Graph {
    private final int V;    // 顶点数目
    private int E;          // 边的数目
    private Bag<Integer>[] adj; // 邻接表

    public Graph(int v) {
        this.V = v;
        this.E = 0;
        adj = new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new Bag<Integer>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
