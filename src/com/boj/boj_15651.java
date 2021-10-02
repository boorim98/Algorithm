package com.boj;

import java.io.*;
import java.util.*;

/*
N과 M (2)과 차이점 : 수 중복 가능
시간초과 떴던 이유 : StringBuilder로 출력하지 않아서.
*/

public class boj_15651 {
    static int N, M;
    static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[10];

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

        for (int i = 1; i <= N; i++) { // 오름차순 아니니 idx 필요 없고, 중복 허용이라 visit 배열도 필요 없음.
            arr[count] = i;
            back(count + 1);
        }
    }
}
