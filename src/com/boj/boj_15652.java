package com.boj;

import java.io.*;
import java.util.*;
/*
N과 M (2)과 차이점 : 비 내림 차순
*/

public class boj_15652 {
    static int N, M;
    static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[10];

        back(1,0);
        System.out.println(sb);
    }
    public static void back(int idx, int count){ //비내림차순으로 수열 만들기 위하여 idx라는 인자 하나 추가
        if (count == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = idx; i <= N; i++) { //비내림차순을 위하여 숫자 탐색 범위를 idx부터 해야함(전 수보다 작으면 안되니까)
            arr[count] = i;
            back(i,count + 1);//중복 가능이니 i + 1이 아닌 i부터 가능
        }
    }
}
