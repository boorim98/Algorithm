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

        /*잘못 생각한 코드*/

        boolean[] visited = new boolean[arr.length];
        int result = combination(arr, visited, 0, arr.length, 3, m, m, 0);

        System.out.println(result);
    }

    static int combination(int[] arr, boolean[] visited, int start, int n, int r, int m, int close, int result) {

        if (r == 0) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]){
                    sum += arr[i];
                    //System.out.println("arr = " + arr[i]);
                }
            }
            //System.out.println("sum = " + sum);
            if (sum <= m && m - sum < close) {
                close = m - sum;
                System.out.println("sum = " + sum);

                result = sum;
                System.out.println("result = " + result);
            }
        }
        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1, m, close, result);
            visited[i] = false;
        }

        return result;
    }
}
