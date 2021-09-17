package com.boj;

import java.util.*;
import java.io.*;

public class boj_14503 {
    static int N, M, r, c, d, count;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count = 1;
        find(r, c, d);
        System.out.println(count);

    }

    public static void find(int r, int c, int d) {

        arr[r][c] = 2; //2가 청소한 곳.

        for (int i = 0; i < 4; i++){

            d = (d + 3) % 4;
            int nx = r + dx[d];
            int ny = c + dy[d];

            if (nx > 0 && nx < N && ny > 0 && ny < M && arr[nx][ny] == 0) {
                count++;
                find(nx, ny, d);

                return;
            }
        }
        int back = (d + 2) % 4;
        int bx = r + dx[back];
        int by = c + dy[back];

        if (bx > 0 && bx < N && by > 0 && by < M && arr[bx][by] != 1) {
            find(bx, by, d);
        }
    }

}
