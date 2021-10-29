package com.boj;

import java.util.*;
import java.io.*;

public class boj_15661 {
    static int n;
    static int[][] score;
    static boolean[] visit;
    static int answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        score = new int[n][n];
        visit = new boolean[n];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /*
        n명중 1팀에 m명 뽑았을 때 + 그 인원 제외하고 남은 사람들 능력치 구해서 차 구하기.
        https://exception-log.tistory.com/135
         */

        find(0,0);
        System.out.println(answer);
    }
    public static void find(int idx, int count) {
        if (count == n / 2) {
            answer = Math.min(answer, cal());
            if (answer == 0) {
                System.out.println(answer);
                System.exit(0);
            }
            return;
        }

        for (int i = idx; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                find(idx + 1, count + 1);
                visit[i] = false;
            }
        }
    }

    public static int cal() {
        int start = 0; // v[] 값이 true면 start팀
        int link = 0; // v[] 값이 false면 link팀
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                if(visit[i] && visit[j]) {
                    start += (score[i][j] +score[j][i]);
                }
                else if(!visit[i] && !visit[j]) {
                    link += (score[i][j] + score[j][i]);
                }
            }
        }
        return Math.abs(start - link);
    }
}
