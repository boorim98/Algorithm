package com.boj;

import java.util.*;
import java.io.*;

public class boj_15664 {
    static int N, M;
    static int[] arr;
    static int[] wri;
    static LinkedHashSet<String> ans;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        wri = new int[N];
        arr = new int[10];
        ans = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            wri[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(wri); //오름차순 위하여 배열 정렬 먼저 하기.

        back(0, 0);

        // LinkedHashSet에 저장된 내역을 출력
        ans.forEach(System.out::println);
        br.close();

    }
    public static void back(int idx, int count){
        if (count == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(' ');
            }
            // sb 객체를 LinkedHashSet에 넣어 중복되는 경우는 제외 시킴
            ans.add(sb.toString());
            return;
        }

        for (int i = idx; i < N; i++) {
            arr[count] = wri[i];
            back(i + 1, count + 1);
        }
    }
}
