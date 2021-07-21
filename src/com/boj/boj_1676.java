package com.boj;

import java.util.*;

public class boj_1676 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int num = 0;

        while (N >= 5) {
            num += N / 5;
            N /= 5;
        }
        System.out.println(num);
    }
}
