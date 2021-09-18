package com.boj;

import java.util.*;
import java.io.*;

public class boj_14500 {
    static int N, M, max;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];
        max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 0, 0);
                visited[i][j] = false;
                other(i, j);
            }
        }
        System.out.println(max);
    }

    public static void dfs(int x, int y, int depth, int sum) {

        if (depth == 4){
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++){

            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && N > nx && 0 <= ny && M > ny && !visited[nx][ny]){
                visited[nx][ny] = true;
                dfs(nx, ny, depth + 1, sum + arr[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }
    public static void other(int x, int y){

        if ((x == 0 || x == N - 1) && (y == 0 || y == M - 1)) {
            return;
        }
        int sum = arr[x][y];
        if (x == 0)
            sum += arr[x][y + 1] + arr[x][y - 1] + arr[x + 1][y];
        else if (x == N - 1)
            sum += arr[x][y + 1] + arr[x][y - 1] + arr[x - 1][y];
        else if (y == 0)
            sum += arr[x - 1][y] + arr[x + 1][y] + arr[x][y + 1];
        else if (y == M - 1)
            sum += arr[x - 1][y] + arr[x + 1][y] + arr[x][y - 1];
        else {
            sum = Math.max(sum, arr[x][y] + arr[x - 1][y] + arr[x + 1][y] + arr[x][y + 1]);
            sum = Math.max(sum, arr[x][y] + arr[x][y + 1] + arr[x][y - 1] + arr[x + 1][y]);
            sum = Math.max(sum, arr[x][y] + arr[x][y + 1] + arr[x][y - 1] + arr[x - 1][y]);
            sum = Math.max(sum, arr[x][y] + arr[x - 1][y] + arr[x + 1][y] + arr[x][y - 1]);
        }

        max = Math.max(max, sum);

    }
}
