package com.boj;

import java.util.*;

public class boj_1292 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();

        int[] arr = new int[1002];

        int count = 1;
        for (int i = 1; i <= 1000; i++) {
            for (int j = 1; j <= i; j++) {
                if (count == 1001) break;
                arr[count] = i;
                count++;
            }
        }

        int sum = 0;
        for (int i = start; i <= end; i++){
            sum += arr[i];
        }
        System.out.println(sum);
    }
}
