package com.boj;

import java.util.*;

public class boj_1260 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int V = scanner.nextInt();

        boolean visited[] = new boolean[N+1];

        LinkedList<Integer>[] adjList = new LinkedList[N + 1];

        for (int i = 0; i <= N; i++) {
            adjList[i] = new LinkedList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(adjList[i]);
        }

        dfs(V, adjList, visited);
        Arrays.fill(visited, false);
        System.out.println();
        bfs(V, adjList, visited);


    }

    private static void dfs(int v, LinkedList<Integer>[] adjList, boolean[] visited) {
        visited[v] = true; // 정점 방문 표시
        System.out.print(v + " "); // 정점 출력

        Iterator<Integer> iter = adjList[v].listIterator(); // 정점 인접리스트 순회
        while (iter.hasNext()) {
            int w = iter.next();
            if (!visited[w]) // 방문하지 않은 정점이라면
                dfs(w, adjList, visited); // 다시 DFS
        }
    }

    public static void bfs(int v, LinkedList<Integer>[] adjList, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[v] = true;
        queue.add(v);

        while(queue.size() != 0) {
            v = queue.poll();
            System.out.print(v + " ");

            Iterator<Integer> iter = adjList[v].listIterator();
            while(iter.hasNext()) {
                int w = iter.next();
                if(!visited[w]) {
                    visited[w] = true;
                    queue.add(w);
                }
            }
        }
    }


}
