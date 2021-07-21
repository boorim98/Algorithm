package com.boj;

import java.util.*;

public class boj_1012 {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0}; //이동 방향

    static int M;
    static int N;
    static int K;
    static int[][] adjArray;
    static boolean[][] visited;
    static int result; //dfs 메소드 사용 위하여 static으로 선언.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();

        for (int i = 0; i < testCase; i++) {
            M = scanner.nextInt(); //가로 길이
            N = scanner.nextInt(); //세로 길이
            K = scanner.nextInt(); //배추 개수

            adjArray = new int[M][N];
            visited = new boolean[M][N];
            result = 0;

            int X;
            int Y;
            for (int j = 0; j < K; j++) {
                X = scanner.nextInt();
                Y = scanner.nextInt(); //배추 위치

                adjArray[X][Y] = 1; //배추 존재하는 곳 1로 바꿔주기
            }

            for (int a = 0; a < M; a++) {
                for (int b = 0; b < N; b++) { //밭 돌면서 배추 존재하는 곳 탐색하기기                   if (adjArray[a][b] == 1 && !visited[a][b]){
                    dfs(a, b);
                    result++; //인접해있는 곳 나오면 result 값 추가.
                }
            }
        }

        System.out.println(result);
    }


    static void dfs(int x, int y) {
        visited[x][y] = true; //탐색 했으니 탐색한 곳이라고 표시

        for (int i = 0; i < 4; i++){
            int X = x + dx[i];
            int Y = y + dy[i]; //탐색한 곳에서 이동하기 위한 값 더해주기

            if (X >= 0 && Y >= 0 && X < M && Y < N) { //이동한 값이 밭의 범위 안에 존재했을 때만 따지기
                if(adjArray[X][Y] == 1 && !visited[X][Y]) {
                    dfs(X,Y);
                }
            }
        }
    }
}
