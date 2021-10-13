package com.boj;

import java.util.*;
import java.io.*;

class node2583 {
    int x,y;

    node2583(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class boj_2583 {
    static int m, n, k;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[m][n];
        visit = new boolean[m][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            for (int j = sy; j < ey; j++) {
                for (int k = sx; k < ex; k++) {
                    arr[j][k] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0 && !visit[i][j]) {
                    bfs(i, j);
                }
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }

    }

    public static void bfs(int a, int b) {
        Queue<node2583> q = new LinkedList<>();
        int cnt = 0;

        q.offer(new node2583(a, b));
        while (!q.isEmpty()) {
            node2583 node = q.poll();
            int x = node.x;
            int y = node.y;

            for (int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (arr[nx][ny] == 0 && !visit[nx][ny]) {
                        visit[nx][ny] = true;
                        q.offer(new node2583(nx, ny));
                        cnt++;
                    }
                }
            }
        }
        if (cnt == 0) {
            answer.add(1);
        }
        else {
            answer.add(cnt);
        }
    }
}
