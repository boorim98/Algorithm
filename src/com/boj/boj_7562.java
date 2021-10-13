package com.boj;

import java.util.*;
import java.io.*;

/*
어떻게 풀거니
시작점에서 bfs 돌리는데, 언제까지? 도착점 도착할 때까지.
어떻게 움직이느냐 -> 원래는 상하좌우 였는데 여기서는 좌표값 변경해서 8군데로 반복문?
움직였을 때 도착점 아니면 다시 거기서 bfs 실행. (큐에 넣기)
이미 움직인 점은 visit에 true로 놓기.
 */
class node7562 {
    int x,y;

    node7562(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class boj_7562 {
    static int tCase, l;
    static int[][] chess;
    static boolean[][] visit;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int sx, sy, ax, ay;

    static int move;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        tCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < tCase; t++){
            l = Integer.parseInt(br.readLine());

            chess = new int[l][l];
            visit = new boolean[l][l];
            st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            ax = Integer.parseInt(st.nextToken());
            ay = Integer.parseInt(st.nextToken());

            bfs();
            System.out.println(chess[ax][ay]);

        }
    }
    public static void bfs() {

        Queue<node7562> queue = new LinkedList<>();
        queue.offer(new node7562(sx, sy));
        visit[sx][sy] = true;

        while (!queue.isEmpty()) {
            node7562 node = queue.poll();
            int x = node.x;
            int y = node.y;

            if (x == ax && y == ay) {
                break;
            }

            for (int i = 0; i < 8; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                move++;

                if (nx >= 0 && nx < l && ny >= 0 && ny < l) {
                    if (!visit[nx][ny]) {
                        queue.add(new node7562(nx, ny));
                        visit[nx][ny] = true;
                        chess[nx][ny] = chess[x][y] + 1;
                    }
                }
            }


        }
    }
}
