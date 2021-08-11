package com.boj;

import java.util.*;

class tomato2 {
    int x;
    int y;
    int z;

    tomato2(int z, int x, int y ) {
        this.x = x; // 세로
        this.y = y; // 가로
        this.z = z; // 높이
    }
}

public class boj_7569 {
    static int M; // 가로
    static int N; // 세로
    static int H; // 높이
    static int[] dx = {-1, 0, 1, 0, 0, 0}; // 상하좌우위아래
    static int[] dy = {0, 1, 0, -1, 0, 0}; // 상하좌우위아래
    static int[] dz = {0, 0, 0, 0, 1, -1}; // 상하좌우위아래
    static int[][][] board; // 토마토 판
    static Queue<tomato2> que;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();

        board = new int[H][N][M];
        que = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    board[i][j][k] = sc.nextInt();

                    if (board[i][j][k] == 1) {
                        que.add(new tomato2(i, j, k));
                    }
                }
            }
        }
        System.out.println(BFS());
    }

    public static int BFS() {
        while (!que.isEmpty()) {
            tomato2 t = que.remove();

            int z = t.z;
            int x = t.x;
            int y = t.y;

            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < N && ny < M && nz < H) {
                    if (board[nz][nx][ny] == 0) {
                        que.add(new tomato2(nz, nx, ny));

                        board[nz][nx][ny] = board[z][x][y] + 1;
                    }
                }
            }
        }

        int result = Integer.MIN_VALUE;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (board[i][j][k] == 0)
                        return -1;

                    result = Math.max(result, board[i][j][k]);
                }
            }
        }

        if (result == 1)
            return 0;
        else
            return result - 1;
    }
}
