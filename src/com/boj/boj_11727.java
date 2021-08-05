package com.boj;

import java.util.*;

public class boj_11727 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[1001]; //런타임 에러 나지 않도록

        arr[1] = 1;
        arr[2] = 3;

        for (int i = 3; i <= n; i++){
            arr[i] = (arr[i - 1] + arr[i - 2] * 2) % 10007;
        }

        System.out.println(arr[n]);
    }
}
