package com.boj;

import java.util.*;
import java.io.*;

class node2667 {
    int x, y;

    node2667(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class boj_2667_bfs {
    static int n;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static int count = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && arr[i][j] == 1) {
                    count++;
                    bfs(i, j);
                    arrayList.add(count);
                    count = 0;
                }
            }
        }

        Collections.sort(arrayList);
        System.out.println(arrayList.size());
        for (int i = 0; i < arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }
    }

    public static void bfs(int i, int j) {
        Queue<node2667> q = new LinkedList<>();
        q.offer(new node2667(i, j));
        visit[i][j] = true;

        while (!q.isEmpty()) {

            node2667 node = q.poll();
            int x = node.x;
            int y = node.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (!visit[nx][ny] && arr[nx][ny] == 1) {
                        visit[nx][ny] = true;
                        q.offer(new node2667(nx, ny));
                        count++;
                    }
                }
            }
        }
     }
}
