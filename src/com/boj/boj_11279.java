package com.boj;

import java.util.*;

public class boj_11279 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++){
            int x = scanner.nextInt();

            if (x == 0){
                if (pq.isEmpty())
                    System.out.println(0);
                else System.out.println(pq.poll());
            }
            else {
                pq.add(x);
            }
        }
    }
}
