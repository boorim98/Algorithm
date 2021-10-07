package com.boj;

import java.util.*;
import java.io.*;

public class boj_1182 {
    static int N, S;
    static int[] arr;
    static boolean[] check;
    static int answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        check = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        che(0, 0);
        if (S == 0) answer--;
        System.out.println(answer);
    }
    public static void che(int depth, int sum) {

        if (depth == N) { //마지막 숫자까지 확인했는지
            if (sum == S) { //확인했을 때의 합이 S가 맞는지
                answer++;
            }
            return;
        }

        che(depth + 1, sum); //매순간 수열의 해당 수를 더할지 말지 선택해야함 -> 선택하지 않은 경우
        che(depth + 1, sum + arr[depth]); //수열의 해당 수를 선택한 경우
    }
}
