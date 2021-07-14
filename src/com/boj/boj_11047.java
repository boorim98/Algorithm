package com.boj;

import java.util.*;

public class boj_11047 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int num = 0;

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = N - 1; i >=0; i--){
            if (K / arr[i] >= 1) {
                num += K / arr[i];
                K %= arr[i];
            }
        }

        System.out.println(num);
    }
}
