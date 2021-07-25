package com.boj;

import java.util.*;

public class boj_2805 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        long M = scanner.nextLong();

        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextLong();
        }

        Arrays.sort(arr);

        long right = arr[N - 1];
        long left = 1;

        while (left <= right) {
            long mid = (left + right) / 2;
            long max = 0;

            for (int i = 0; i < N; i++){
                if (arr[i] - mid > 0)
                    max += arr[i] - mid;
            }
            if (max >= M){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        System.out.println(right);


    }
}
