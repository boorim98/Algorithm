package com.boj;

import java.util.*;

public class boj_9095 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        int[] arr = new int[12];

        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        for (int i = 4; i < 12; i++) {
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        }

        for (int i = 0; i < T; i++){
            int n = scanner.nextInt();
            System.out.println(arr[n]);
        }


    }
}
