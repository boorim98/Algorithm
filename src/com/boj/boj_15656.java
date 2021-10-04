package com.boj;

import java.util.*;
import java.io.*;

public class boj_15656 {

    static int N, M;
    static int[] arr;
    static int[] wri;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        wri = new int[N];
        arr = new int[10];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            wri[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(wri); //오름차순 위하여 배열 정렬 먼저 하기.

        back(0);
        System.out.println(sb);

    }
    public static void back(int count){
        if (count == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) { //중복 가능이니 check 배열 필요 없음.
            arr[count] = wri[i];
            back(count + 1);
        }
    }
}
