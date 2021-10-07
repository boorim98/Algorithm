package com.boj;

import java.util.*;
import java.io.*;

public class boj_1182 {
    static int N, S;
    static int[] arr;
    static boolean[] check;
    static int answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        check = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        che(0, 0);
        if (S == 0) answer--;
        System.out.println(answer);
    }
    public static void che(int depth, int sum) {

        if (depth == N) {
            if (sum == S) {
                answer++;
            }
            return;
        }

        che(depth + 1, sum);
        che(depth + 1, sum + arr[depth]);
    }
}
