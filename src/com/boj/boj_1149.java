package com.boj;

import java.util.*;

public class boj_1149 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[][] rgb = new int[N][3];

        for (int i = 0; i < N; i++){
            for (int j = 0; j < 3; j++){
                rgb[i][j] = scanner.nextInt();
            }
        }

        int money = 0;
        int first_min = rgb[0][0];
        int first_index = 0;
        for (int i = 1; i < 3; i++){
            if (rgb[0][i] < first_min) {
                first_min = rgb[0][i];
                first_index = i;
            }
        }

        money += first_min;

        int index = first_index;
        for (int i = 1; i < N; i++){
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < 3; j++){
                if (j == index){
                    continue;
                }
                else {
                    if (min >= rgb[i][j]) {
                        min = rgb[i][j];
                        index = j;
                    }
                }
            }
            money += min;
        }

        System.out.println(money);

    }
}
