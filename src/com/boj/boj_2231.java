package com.boj;

import java.util.*;

public class boj_2231 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        boolean find = false;

        for (int i = 1; i < num; i++) {
            int candidate = i;
            LinkedList<Integer> stack = new LinkedList<>();
            while(candidate != 0){
                stack.push(candidate % 10);
                candidate /= 10;
            }
            int digit = 0;
            while (!stack.isEmpty()){
                int s = stack.pop();
                digit += s;
            }
            digit += i;

            if (digit == num){
                System.out.println(i);
                find = true;
                break;
            }
        }

        if (!find) {
            System.out.println(0);
        }

    }
}
