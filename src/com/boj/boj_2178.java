package com.boj;

import java.util.*;
import java.io.*;

class miro {
    int x; // 세로
    int y; // 가로

    miro(int x, int y) {
        this.x = x; // 세로
        this.y = y; // 가로
    }
}

public class boj_2178 {
    static int M; // 가로
    static int N; // 세로
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우위아래
    static int[] dy = {0, 0, -1, 1}; // 상하좌우위아래
    static int[][] board; // 토마토 판
    static boolean[][] visit;
    static Queue<miro> que;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visit = new boolean[N][M];
        que = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }
        que.add(new miro(0, 0));
        visit[0][0] = true;
        BFS();
        System.out.println(board[N-1][M-1]);
    }

    public static void BFS() {
        while (!que.isEmpty()) {
            miro t = que.remove();
            int x = t.x; // 세로
            int y = t.y; // 가로

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i]; // 세로
                int ny = y + dy[i]; // 가로

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (!visit[nx][ny] && board[nx][ny] == 1) {
                        que.add(new miro(nx, ny));
                        visit[nx][ny] = true;
                        board[nx][ny] = board[x][y] + 1;
                    }
                }
            }
        }
    }
}
