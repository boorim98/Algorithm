package com.boj;

import java.util.*;

public class boj_2606 {

    static ArrayList<Integer>[] arrayLists;
    static boolean visited[];
    static int answer = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M =  scanner.nextInt();

        arrayLists = new ArrayList[N+1];
        visited = new boolean[N+1];

        int vertex1, vertex2 = 0;

        for (int i = 1; i < N+1; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            vertex1 = scanner.nextInt();
            vertex2 = scanner.nextInt();

            arrayLists[vertex1].add(vertex2);
            arrayLists[vertex2].add(vertex1);
        }

        for (int i = 1; i < N+1; i++) {
            if (!visited[i]) {
                dfs(i);
                break;
            }
        }

        System.out.println(answer);
    }

    static void dfs(int v) {
        if(visited[v]) {
            return;
        }

        visited[v] = true;
        for (int i : arrayLists[v]){
            if(!visited[i]) {
                answer++;
                dfs(i);
            }
        }
    }
}
