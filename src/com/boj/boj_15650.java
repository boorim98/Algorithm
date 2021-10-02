package com.boj;

import java.util.*;
import java.io.*;

public class boj_15650 {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[10];

        back(1, 0);
    }
    public static void back(int idx, int count){
        if (count == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = idx; i <= N; i++) {
            arr[count] = i;
            back(i + 1, count + 1);
        }
    }
}
