package com.boj;

import java.util.*;

public class boj_2798 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        int sum = 0;
        int max = 0;
        for (int i = 0; i < arr.length - 2; i++){
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++)  {
                    sum = arr[i] + arr[j] + arr[k];

                    if (m >= sum && sum > max) {
                        max = sum;
                    }
                }
            }
        }
        System.out.println(max);
    }
}
