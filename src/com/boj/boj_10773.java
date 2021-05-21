package com.boj;

import java.util.*;

public class boj_10773 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < num; i ++) {
            int money = scanner.nextInt();
            if (money != 0) {
                stack.push(money);
            }
            else stack.pop();
        }

        int sum = 0;
        while (!stack.isEmpty()){
            sum += stack.pop();
        }

        System.out.println(sum);
    }
}
