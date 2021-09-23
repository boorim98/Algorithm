package com.boj;

import java.util.*;
import java.io.*;

public class boj_11725 {
    static int N;
    static ArrayList<Integer>[] arrayLists;
    static int[] parents;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        parents = new int[N + 1];

        arrayLists = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++){
            arrayLists[i] = new ArrayList<>();
        }

        int vertex1, vertex2;
        for (int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());
            vertex1 = Integer.parseInt(st.nextToken());
            vertex2 = Integer.parseInt(st.nextToken());

            arrayLists[vertex1].add(vertex2);
            arrayLists[vertex2].add(vertex1);
        }

        dfs(1);
        for(int i = 2; i <= N; i++){
            System.out.println(parents[i]);
        }
    }
    public static void dfs(int root){
        visited[root] = true;

        for (int i : arrayLists[root]) {
            if (!visited[i]) {
                parents[i] = root;
                dfs(i);
            }
        }
    }
}
