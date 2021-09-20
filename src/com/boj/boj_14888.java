package com.boj;

import java.util.*;
import java.io.*;

public class boj_14888 {
    static int N;
    static int[] arr;
    static int[] operator;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        operator = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int n, int depth) {
        if (depth == N){
            max = Math.max(max, n);
            min = Math.min(min, n);
        }


        for (int i = 0; i < 4; i++){
            if (operator[i] > 0) {
                operator[i]--;

                switch (i) {
                    case 0:
                        dfs(n + arr[depth], depth + 1);
                        break;
                    case 1:
                        dfs(n - arr[depth], depth + 1);
                        break;
                    case 2:
                        dfs(n * arr[depth], depth + 1);
                        break;
                    case 3:
                        dfs(n / arr[depth], depth + 1);
                        break;
                }

                operator[i]++;
            }
        }
    }
}
