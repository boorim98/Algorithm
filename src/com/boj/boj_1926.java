package com.boj;

import java.util.*;
import java.io.*;

class picture {
    int x, y;
    picture(int x, int y) {
        this.x = x; //행
        this.y = y; //열
    }
}

public class boj_1926 {
    static int n, m;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Queue<picture> queue;
    static int num = 0;
    static int max = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && !visit[i][j]) {
                    visit[i][j] = true;
                    bfs(i, j);
                    num++; //시작점에서 bfs 시작이니 그림의 개수를 여기서 세준다.
                }
            }
        }
        System.out.println(num);
        System.out.println(max);
    }

    public static void bfs(int x, int y) {
        queue = new LinkedList<>();
        queue.add(new picture(x, y));
        int count = 1 ; //시작점도 그림 넓이에 해당되니 넓이 초기화를 1로 해줌.

        while (!queue.isEmpty()) {
            picture p = queue.poll();

            for (int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                if (visit[nx][ny] || arr[nx][ny] == 0)
                    continue;

                visit[nx][ny] = true;
                queue.add(new picture(nx, ny));
                count++; //상하좌우 그림이 연결되어 있으면 큐에 넣어주고 넓이도 늘려줌.
            }
        }
        max = Math.max(max, count); //그림 하나가 끝나면 그림 최대값 갱신해줌.
    }
}
