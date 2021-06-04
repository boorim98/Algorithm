package com.boj;

import java.util.Scanner;

public class boj_10870 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int answer = 0;
        int a = 1;
        int b = 1;

        if(n==1 || n==2){
            System.out.println(1);
            System.exit(0);
        }

        for(int i=3; i<=n; i++){
            answer = a + b;
            a = b;
            b = answer;

        }

        System.out.println(answer);
    }
}
