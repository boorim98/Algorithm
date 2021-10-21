package com.boj;

import java.util.*;
import java.io.*;

class Puyo {
    int x; // 행
    int y; // 열
    char color;

    Puyo(int x, int y, char color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
}

public class boj_11559 {
    static char[][] game;
    static boolean[][] visited;
    static ArrayList<Puyo> list;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int bang = 0;
    static boolean check = false;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        game = new char[12][6];

        for (int i = 0; i < 12; i++){
            String s = br.readLine();
            for (int j = 0; j < 6; j++){
                game[i][j] = s.charAt(j);
            }
        }

        while (true) {
            boolean finish = true;
            visited = new boolean[12][6];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (game[i][j] == 'R' || game[i][j] == 'G' || game[i][j] == 'B' || game[i][j] == 'P' || game[i][j] == 'Y') {
                        list = new ArrayList<>();
                        bfs(i, j, game[i][j]);

                        if (list.size() >= 4) {
                            finish = false;
                            for (int k = 0; k < list.size(); k++) {
                                game[list.get(k).x][list.get(k).y] = '.';
                            }
                        }
                    }
                }
            }
            if (finish)
                break;
            fall();
            bang++;
        }
        System.out.println(bang);
    }
    public static void fall() {
        for (int i = 0; i < 6; i++) {
            for (int j = 11; j >= 0 ; j--) {
                if (game[j][i] == '.') {
                    for (int k = j - 1; k >= 0; k--) {
                        if (game[k][i] != '.') {
                            game[j][i] = game[k][i];
                            game[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }
    public static void bfs(int a, int b, char c) {
        Queue<Puyo> queue = new LinkedList<>();
        list.add(new Puyo(a, b, c));
        queue.offer(new Puyo(a, b, c));
        visited[a][b] = true;

        while (!queue.isEmpty()) {
            Puyo puyo = queue.poll();
            int x = puyo.x;
            int y = puyo.y;
            char color = puyo.color;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < 12 && ny >= 0 && ny < 6) {
                    if (color == game[nx][ny] && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        list.add(new Puyo(nx, ny, game[nx][ny]));
                        queue.offer(new Puyo(nx, ny, game[nx][ny]));
                    }
                }
            }
        }
    }
}
