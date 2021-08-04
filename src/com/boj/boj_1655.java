package com.boj;

import java.io.*;
import java.util.*;

public class boj_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());


        for (int i = 0; i < N; i++){
            int x = Integer.parseInt(br.readLine());

            if (min.size() == max.size()) {
                if (!min.isEmpty() && x > min.peek()){
                    max.add(min.poll());
                    min.add(x);
                }
                else
                    max.add(x);
            }
            else {
                if (!max.isEmpty() && x < max.peek()){
                    min.add(max.poll());
                    max.add(x);
                }
                else
                    min.add(x);

            }
            sb.append(max.peek()).append("\n");
        }
        System.out.println(sb);
    }
}
