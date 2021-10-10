package com.boj;

import java.io.*;
import java.util.*;


public class boj_5427 {
    static int test;
    static int w, h;
    static int[][] arr;
    static Queue<location> sang;
    static Queue<location> fire;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int time;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        test = Integer.parseInt(br.readLine());

        for (int t = 0; t < test; t++){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken()); //너비
            h = Integer.parseInt(st.nextToken()); //높이

            arr = new int[h][w];
            sang = new LinkedList<>();
            fire = new LinkedList<>();

            for (int i = 0; i < h; i++){
                String s = br.readLine();
                for (int j = 0; j < w; j++) {
                    char c = s.charAt(j);

                    if (c == '#') {
                        arr[i][j] = -1;
                    }
                    else if (c == '@'){
                        sang.add(new location(i, j));
                        arr[i][j] = 1;
                    }
                    else if (c == '*') {
                        fire.add(new location(i, j));
                        arr[i][j] = -2;
                    }
                    else {
                        arr[i][j] = 0;
                    }
                }
            }
            time = 0;
            bfs();
        }

    }
    public static void bfs() {

        while (true) {
            time++;

            int fs = fire.size();
            while (fs > 0){
                fs--;

                location loc = fire.remove();
                int x = loc.x;
                int y = loc.y;

                for (int i = 0; i < 4; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < h && ny >= 0 && ny < w){
                        if (arr[nx][ny] >= 0) {
                            fire.add(new location(nx, ny));
                            arr[nx][ny] = -2;
                        }
                    }
                }
            }

            int ss = sang.size();
            while (ss > 0) {
                ss--;

                location loc = sang.remove();
                int x = loc.x;
                int y = loc.y;

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || nx >= h || ny < 0 || ny >= w){
                        System.out.println(time);
                        return;
                    }

                    if (arr[nx][ny] == 0) {
                        sang.add(new location(nx, ny));
                        arr[nx][ny] = 1;
                    }
                }
            }

            if (sang.isEmpty()) {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }
    }
}
