package com.boj;

import java.util.*;

public class boj_2667 {
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int count = 0;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        arr = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++){
            String s = scanner.next();
            for (int j = 0; j < N; j++){
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (arr[i][j] == 1 && !visited[i][j]){
                    count = 1;
                    dfs(i,j);
                    list.add(count);
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

    public static void dfs(int x, int y) {

        visited[x][y] = true;

        for (int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && arr[nx][ny] == 1 && !visited[nx][ny]) {
                dfs(nx, ny);
                count++;
            }
        }

    }
}
