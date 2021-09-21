package com.boj;

import java.io.*;
import java.util.*;

public class boj_14501 {
    static int N;
    static int[] T;
    static int[] P;
    static int[] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = new int[N + 2];
        P = new int[N + 2];
        dp = new int[N + 2];

        for (int i = 1; i < N + 1; i++){
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i > 0; i--){

            int day = i + T[i];
            if (day > N + 1){
                dp[i] = dp[i + 1];
            }
            else {
                dp[i] = Math.max(dp[day] + P[i], dp[i + 1]);
            }
        }

        System.out.println(dp[1]);
    }
}
