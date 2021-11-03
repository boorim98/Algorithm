package com.boj;

import java.util.*;
import java.io.*;

class node2468 {
    int x, y;

    node2468(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class boj_2468 {
    static int N;
    static int[][] arr;
    static Queue<node2468> queue;
    static boolean[][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        int height = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (height < arr[i][j]) {
                    height = arr[i][j];
                }
            }
        }

        for (int i = 0; i < height + 1; i++) {
            visit = new boolean[N][N];
            int num = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (arr[j][k] > i && !visit[j][k]) {
                        bfs(j, k, i);
                        num++;
                    }
                }
            }

            if (max < num) {
                max = num;
            }
        }
        System.out.println(max);
    }
    public static void bfs(int a, int b, int height) {
        queue = new LinkedList<>();

        queue.add(new node2468(a, b));
        visit[a][b] = true;

        while (!queue.isEmpty()) {
            node2468 node = queue.poll();
            int x = node.x;
            int y = node.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && arr[nx][ny] > height && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    queue.add(new node2468(nx, ny));
                }
            }
        }
    }
}
