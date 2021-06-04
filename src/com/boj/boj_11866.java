package com.boj;

import java.util.*;

public class boj_11866 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++){
            queue.add(i);
        }

        int i = 1;
        System.out.print("<");
        while (!queue.isEmpty()) {
            if (i != k){
                int top = queue.poll();
                queue.add(top);
                i++;
            }
            else {
                int top = queue.poll();
                if(queue.size() != 0){
                    System.out.print(top+", ");
                }
                else {
                    System.out.print(top);
                }
                i = 1;
            }
        }
        System.out.println(">");

    }
}
