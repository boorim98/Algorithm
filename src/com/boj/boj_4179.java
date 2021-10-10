package com.boj;

import java.util.*;
import java.io.*;

class location {
    int x, y;

    location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class boj_4179 {
    static int R, C;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Queue<location> j1;
    static Queue<location> f1;
    static int answer = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[R][C];
        j1 = new LinkedList<>();
        f1 = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                char c = s.charAt(j);
                switch (c) {
                    case '#':
                        arr[i][j] = -1;
                        break;
                    case 'J':
                        j1.add(new location(i, j));
                        arr[i][j] = 1;
                        break;
                    case 'F':
                        f1.add(new location(i, j));
                        arr[i][j] = -2;
                        break;
                    default:
                        arr[i][j] = 0;
                        break;
                }
            }
        }
        bfs();
    }

    public static void bfs() {
        while (true){
            answer++;

            int fs = f1.size();
            while (fs > 0) {
                fs--;
                location loc = f1.remove();
                int x = loc.x;
                int y = loc.y;

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                        if (arr[nx][ny] >= 0) {
                            f1.add(new location(nx, ny));
                            arr[nx][ny] = -2;
                        }
                    }
                }
            }

            int js = j1.size();
            while (js > 0) {
                js--;
                location loc = j1.remove();
                int x = loc.x;
                int y = loc.y;

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                        System.out.println(answer);
                        return;
                    }
                    if (arr[nx][ny] == 0) {
                        j1.add(new location(nx, ny));
                        arr[nx][ny] = 1;
                    }
                }
            }
            if (j1.isEmpty()) {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }
    }
}
