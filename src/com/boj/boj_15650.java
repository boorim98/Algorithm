package com.boj;

import java.util.*;
import java.io.*;

/*
N과 M (1)과 차이점 : 고른 수열은 오름차순이어야 한다.
따라서 입력을 4 4로 해주면 1 2 3 4만 출력되어야 한다.
*/

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
    public static void back(int idx, int count){ //오름차순으로 수열 만들기 위하여 idx라는 인자 하나 추가
        if (count == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = idx; i <= N; i++) { //오름차순을 위하여 숫자 탐색 범위를 idx부터 해야함(전 수보다 커야하니까)
            arr[count] = i;
            back(i + 1, count + 1);
        }
    }
}
