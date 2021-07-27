package com.boj;

import java.util.*;

public class boj_1003 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        int[] zero = new int[41];
        int[] one = new int[41];

        zero[0] = 1;
        one[0] = 0;
        zero[1] = 0;
        one[1] = 1;

        for (int i = 2; i < 41; i++) {
            zero[i] = zero[i - 1] + zero[i - 2];
            one[i] = one[i - 1] + one[i - 2];
         }

        for (int i = 0; i < T; i++){
            int N = scanner.nextInt();
            System.out.println(zero[N] + " " + one[N]);
        }


    }
}
