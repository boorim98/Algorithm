package com.boj;

import java.util.*;

public class boj_1654 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int K = scanner.nextInt();
        long N = scanner.nextLong();

        long[] arr = new long[K];

        for (int i = 0; i < K; i++) {
            arr[i] = scanner.nextLong();
        }

        Arrays.sort(arr);

        long high = arr[K - 1];
        long low = 1;

        while (low <= high) {
            long mid = (low + high) / 2;
            long count = 0;

            for (int i = 0; i < K; i++){
                count += arr[i] / mid;
            }
            if (count >= N) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        System.out.println(high);

    }

}
