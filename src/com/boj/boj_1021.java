package com.boj;

import java.util.*;

public class boj_1021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        LinkedList<Integer> stack = new LinkedList<>();
        int[] location = new int[M];

        for (int i = 0; i < M; i++) {
            location[i] = scanner.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            stack.add(i);
        }

        int num = 0;
        for (int i = 0; i < M; i++) {
            int loc = stack.indexOf(location[i]);

            int half = stack.size() / 2;
            if (stack.size() % 2 == 0){
                half --;
            }

            if (loc > half) {
                for (int j = 0; j < stack.size() - loc; j++){
                    int last = stack.removeLast();
                    stack.addFirst(last);
                    num++;
                }
            }
            else {
                for (int j = 0; j < loc; j++) {
                    int first = stack.removeFirst();
                    stack.addLast(first);
                    num++;
                }
            }
            stack.pollFirst();
        }
        System.out.println(num);
    }
}
