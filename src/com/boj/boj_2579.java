package com.boj;

import java.util.*;

public class boj_2579 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++){
            arr[i] = scanner.nextInt();
        }

        dp[1] = arr[1];
        if (n >= 2){
            dp[2] = dp[1] + arr[2];
        }
        for (int i = 3; i <= n; i++){
            dp[i] = Math.max(arr[i - 1] + dp[i - 3], dp[i - 2]) + arr[i];
        }

        System.out.println(dp[n]);


    }
}
