package com.boj;

import java.util.*;
import java.io.*;

public class boj_2644 {
    static int N;
    static int a, b;
    static ArrayList<Integer>[] arrayLists;
    static boolean[] visitied;
    static int m;
    static int count = -1;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        arrayLists = new ArrayList[N + 1];
        visitied = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++){
            arrayLists[i] = new ArrayList<>();
        }

        int vertex1, vertex2;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            vertex1 = Integer.parseInt(st.nextToken());
            vertex2 = Integer.parseInt(st.nextToken());

            arrayLists[vertex1].add(vertex2);
            arrayLists[vertex2].add(vertex1);
        }

        dfs(a, 0);
        System.out.println(count);
    }

    public static void dfs(int a, int res) {

        if (a == b){
            count = res;
            return;
        }

        visitied[a] = true;
        for (int i : arrayLists[a]){
            if (!visitied[i]) {
                dfs(i, res + 1);
            }
        }

    }
}
