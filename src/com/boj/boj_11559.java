package com.boj;

import java.util.*;
import java.io.*;

/*
https://moonsbeen.tistory.com/213 --> 참고 블로그
 */

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

                        if (list.size() >= 4) { //같은 색 뿌요가 4개 이상이면 연쇄 작용 일어나서 터짐.
                            finish = false;
                            for (int k = 0; k < list.size(); k++) {
                                game[list.get(k).x][list.get(k).y] = '.';
                            }
                        }
                    }
                }
            }
            if (finish) //4개 이상인 뿌요가 없다는 뜻이니 멈추고 결과 출력해야함.
                break;
            fall(); //4개 이상인 뿌요 있다는 뜻이니 연쇄작용 일어났을 것. 밑으로 뿌요 떨어뜨려야 함.
            bang++;
        }
        System.out.println(bang);
    }
    public static void fall() {
        for (int i = 0; i < 6; i++) {
            for (int j = 11; j >= 0 ; j--) {
                if (game[j][i] == '.') { //뿌요 떨어뜨릴 때 .이면 위의 행들에 뿌요 있는지 확인해야함.
                    for (int k = j - 1; k >= 0; k--) { //즉 . 위의 행들에 대해서 확인하는 코드.
                        if (game[k][i] != '.') { //위 살펴보다가 뿌요 발견했을시
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
