package com.boj;

import java.util.*;
import java.io.*;

public class boj_20055 {
    static int N, K;
    static boolean[] robot;
    static int[] score;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        score = new int[2 * N];
        robot = new boolean[2 * N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(check(0));

    }
    public static int check(int count) {
        while (k()){
            int temp = score[score.length - 1]; //컨베이어 벨트 회전
            for (int i = score.length - 1; i > 0; i--){
                score[i] = score[i - 1];
            }
            score[0] = temp;

            for (int i = robot.length - 1; i > 0; i--){ //로봇도 같이 회전
                robot[i] = robot[i - 1];
            }
            robot[0] = false;

            robot[N - 1] = false; //로봇 내리기
            for (int i = N - 1; i > 0; i--){
                if (robot[i - 1] && !robot[i] && score[i] >= 1) { //로봇이 이동하려는 칸에 로봇 없어야하고 그 칸의 내구도가 0보다 커야함
                    robot[i] = true;
                    robot[i - 1] = false;
                    score[i]--;
                }
            }

            if(score[0] > 0){ //로봇 올리기 위한 체크
                robot[0] = true;
                score[0]--;
            }

            count++;
        }
        return count;
    }
    public static boolean k(){
        int count = 0;

        for (int i = 0; i < score.length; i++){
            if (score[i] == 0) {
                count++;
            }
            if (count >= K) {
                return false;
            }
        }

        return true;
    }
}
