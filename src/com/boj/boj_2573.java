package com.boj;

import java.util.*;
import java.io.*;

class node2573 {
    int x, y;
    node2573 (int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class boj_2573 {
    static int N, M;
    static int[][] arr;
    static int[][] copy;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        copy = new int[N][M];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        int answer = 0;
        //bfs로 0이 아닌 곳 주위에서 0이면 그 개수를 copy 배열에 저장하기.
        while ((cnt = sepNum()) < 2) {

            if (cnt == 0) {
                answer = 0;
                break;
            }
            answer++;
            melt();
        }
        System.out.println(answer);
    }

    public static int sepNum() {
        boolean[][] visit = new boolean[N][M];

        int num = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++) {
                if (arr[i][j] != 0 && !visit[i][j]) {
                    bfs(i,j,visit);
                    num++;
                }
            }
        }
        return num;
    }

    public static void bfs(int a, int b, boolean[][] visit) {
        visit[a][b] = true;
        Queue<node2573> q = new LinkedList<>();
        q.offer(new node2573(a, b));

        int nx, ny;
        while (!q.isEmpty()) {
            node2573 node = q.poll();
            int x = node.x;
            int y = node.y;

            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (arr[nx][ny] != 0 && !visit[nx][ny]) {
                        visit[nx][ny] = true;
                        q.offer(new node2573(nx, ny));
                    }
                }
            }
        }
    }
    public static void melt() {
        Queue<node2573> queue = new LinkedList<>();
        boolean[][] visit = new boolean[N][M];


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] != 0) {
                    queue.offer(new node2573(i, j));
                    visit[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            node2573 node = queue.poll();
            int zero = 0;

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (arr[nx][ny] == 0 && !visit[nx][ny]) {
                        zero++;
                    }
                }
            }

            if (arr[node.x][node.y] - zero < 0) {
                arr[node.x][node.y] = 0;
            }
            else {
                arr[node.x][node.y] -= zero;
            }
        }

    }
}
