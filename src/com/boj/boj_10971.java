package com.boj;

import java.util.*;
import java.io.*;

public class boj_10971 {
    static int N;
    static int[][] arr;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            back(i, i,0,0); //시작점과 시작점으로 돌아와야하니 그 점, n개의 도시를 거쳐야하니 개수, 비용을 구해야하니 비용 매개변수
        }
        System.out.println(min);
    }

    public static void back(int start, int back, int count, int ex) {
        if (count == N && start == back) {
            if (ex < min) {
                min = ex;
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i] && arr[start][i] != 0) {
                visit[i] = true;
                ex = ex + arr[start][i];
                back(i, back, count + 1, ex);
                ex -= arr[start][i]; //비용과 거쳐갔는지 다시 원래대로 돌려줘야 함.
                visit[i] = false;
            }
        }
    }
}
