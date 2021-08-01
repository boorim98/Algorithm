package com.boj;

import java.util.*;

public class boj_10844 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[] dp = new int[N + 1];

        dp[1] = 9;
        for (int i = 2; i <= N; i++){
            dp[i] = dp[i - 1] * 2 - 1;
        }
        System.out.println(dp[N] % 1000000000);
    }
}
