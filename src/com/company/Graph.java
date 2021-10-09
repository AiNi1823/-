package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int v;
    //邻接表
    private LinkedList<Integer> adj[];

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 添加边
     *
     * @param s
     * @param t
     */
    public void addEdge(int s, int t) {
        //无向图一条边存两次
        adj[s].add(t);
        adj[t].add(s);
    }

    public void bfs(int s, int t) {
        if (s == t) return;
        //visited是用来记录已经被访问的顶点，用来避免顶点被重复访问
        boolean[] visited = new boolean[v];
        visited[v] = true;
        //queue是一个队列，用来存储已经被访问但相连顶点还没被访问的顶点
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        //prev用来记录搜索路径
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        printPath(prev,s,t);
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    //递归打印s->t的路径
    private void printPath(int[] prev, int s, int t) {
        if (prev[t] != -1 && t != s) {
            printPath(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }
}
