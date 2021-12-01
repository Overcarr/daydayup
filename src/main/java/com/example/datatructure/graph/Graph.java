package com.example.datatructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 图
 * @author overcare
 */
public class Graph {
    private boolean[] isVisited;
    private int[][] edges;
    private List<String> vertexList;

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
    }

    /**
     * 深度遍历算法
     *
     */
    public void dfs() {
        isVisited = new boolean[vertexList.size()];

        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    public void dfs(boolean[] isVisited, int i) {
        System.out.println(vertexList.get(i) + "->");
        isVisited[i] = true;

        int j = getFirstNeighbor(i);
        while (j != -1) {
            if (!isVisited[j]) {
                dfs(isVisited, j);
            }
            j = getNextNeighbor(i, j);
        }
    }

    private int getFirstNeighbor(int i) {
        for (int j = 0; j < vertexList.size(); j++) {
            int w = edges[i][j];
            if (w == 1) {
                return j;
            }
        }
        return -1;
    }

    private int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            int w = edges[v1][j];
            if (w == 1) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 广度遍历算法
     *
     */
    public void bfs() {
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }

    public void bfs(boolean[] isVisited, int i) {
        // 队列的头结点
        int u;
        // 相邻节点
        int w;
        List<Integer> linkedList = new LinkedList<>();

        System.out.println(vertexList.get(i) + "->");
        linkedList.add(i);

        while (!linkedList.isEmpty()) {
            u = linkedList.remove(0);
            w = getFirstNeighbor(u);
            if (isVisited[w]) {
                linkedList.add(w);
                System.out.println(vertexList.get(w) + "->");
                isVisited[w] = true;
            }

            w = getNextNeighbor(u, w);
        }
    }

}
