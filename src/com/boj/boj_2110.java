package com.boj;

import java.util.*;

public class boj_2110 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        long C = scanner.nextLong();

        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextLong();
        }

        Arrays.sort(arr);

        long right = arr[N - 1] - arr[0];
        long left = 1;

        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long start = arr[0];
            int count = 1;

            for (int i = 0; i < N; i++){
                if (arr[i] - start >= mid) {
                    count++;
                    start = arr[i];
                }
            }
            if (count >= C){
                result = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        System.out.println(result);

    }
}
