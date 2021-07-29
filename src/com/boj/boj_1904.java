package com.boj;

import java.io.*;
import java.util.*;

public class boj_1904 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        if (N <= 2) {
            System.out.println(N);
        } else {
            long[] arr_n = new long[N+1];
            arr_n[1] = 1;
            arr_n[2] = 2;

            for (int i = 3; i <= N; i++) {
                arr_n[i] = (arr_n[i - 1] + arr_n[i - 2]) % 15746;
            }
            System.out.println(arr_n[N]);
        }
    }
}
