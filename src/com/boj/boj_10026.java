package com.boj;

import java.util.*;
import java.io.*;

class Node10026{
    int x, y;

    Node10026(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class boj_10026 {
    static int n;
    static char[][] arr1;
    static char[][] arr2;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visit;
    static Queue<Node10026> qu;
    static int ans1, ans2 = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr1 = new char[n][n];
        arr2 = new char[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++){
            String st = br.readLine();
            for (int j = 0; j < n; j++) {
                arr1[i][j] = st.charAt(j);

                if (arr1[i][j] == ('G')) {
                    arr2[i][j] = 'R';
                }
                else {
                    arr2[i][j] = arr1[i][j];
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!visit[i][j]) {
                    bfs(i,j,arr1);
                    ans1++;
                }
            }
        }

        visit = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visit[i][j]) {
                    bfs(i,j,arr2);
                    ans2++;
                }
            }
        }

        System.out.println(ans1 + " " + ans2);

    }

    public static void bfs(int i, int j, char[][] arr) {
        qu = new LinkedList<>();
        qu.add(new Node10026(i, j));
        visit[i][j] = true;

        while (!qu.isEmpty()) {
            Node10026 node = qu.remove();
            int x = node.x;
            int y = node.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y +  dy[k];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (arr[nx][ny] == (arr[i][j]) && !visit[nx][ny]) {
                        visit[nx][ny] = true;
                        qu.add(new Node10026(nx, ny));
                    }
                }
            }
        }
    }
}
