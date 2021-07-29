package com.boj;

import java.util.*;

public class boj_9461 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for (int i = 0; i < T; i++){
            int N = scanner.nextInt();

            if (N <= 3) {
                System.out.println(1);
            }
            else {
                long[] arr_n = new long[N+1];
                arr_n[1] = 1;
                arr_n[2] = 1;
                arr_n[3] = 1;

                for (int j = 4; j <= N; j++) {
                    arr_n[j] = (arr_n[j - 2] + arr_n[j - 3]);
                }
                System.out.println(arr_n[N]);
            }
        }

    }
}
