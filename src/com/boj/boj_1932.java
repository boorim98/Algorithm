package com.boj;

import java.util.*;

public class boj_1932 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        ArrayList[] arr = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j <= i; j++){
                arr[i].add(scanner.nextInt());
            }
        }

        for (int i = 1; i < n; i++){
            for (int j = 0; j < i + 1; j++){
                if (j == 0) {
                    arr[i].set(j, (Integer)arr[i].get(j) + (Integer)arr[i - 1].get(j));
                }
                else if (j == i){
                    arr[i].set(j, (Integer)arr[i].get(j) + (Integer)arr[i - 1].get(j - 1));
                }
                else {
                    arr[i].set(j, Math.max((Integer)arr[i].get(j) + Integer.valueOf((Integer) arr[i - 1].get(j - 1)).intValue(), (Integer)arr[i].get(j) + Integer.valueOf((Integer) arr[i - 1].get(j)).intValue()));
                }
            }
        }

        int answer = (int) Collections.max(arr[n - 1]);
        System.out.println(answer);

    }
}
