package com.boj;

import java.io.*;
import java.util.*;

public class boj_14502 {
    static int N, M;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int ans = 0;

    public static class Location{
        int x, y;
        public Location(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
;            }
        }

        dfs(0);
        System.out.println(ans);

    }
    public static void dfs(int wall) {
        if (wall == 3) {
            int[][] copy = new int[N][M];
            arrCopy(copy, arr);
            virus();
            arrCopy(arr, copy);
            return;
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    dfs(wall + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    public static void virus() {
        Queue<Location> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 2) {
                    q.add(new Location(i,j));
                }
            }
        }

        while (!q.isEmpty()) {
            Location l = q.poll();
            for (int i = 0; i < 4; i++) {
                int nX = l.x + dx[i];
                int nY = l.y + dy[i];

                if (nX >= 0 && nX < N && nY >= 0 && nY < M && arr[nX][nY] == 0) {
                    arr[nX][nY] = 2;
                    q.add(new Location(nX, nY));
                }
            }
        }

        count();
    }

    public static void arrCopy(int[][] target, int[][] ori){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                target[i][j] = ori[i][j];
            }
        }
    }

    public static void count() {
        int num = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    num++;
                }
            }
        }

        ans = Math.max(num, ans);
    }
}