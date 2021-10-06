package com.boj;

import java.util.*;
import java.io.*;

/*
queen 말이 공격 가능한지 확인하려면
1. y 좌표가 같은지 확인
2. 좌측 하단 - 우측 상단 대각선에 있는지 - 두 좌표의 x + y 값이 같은지 확인.
3. 우측 하단 - 좌측 상단 대각선에 있는지 - 두 좌표의 x - y 값이 같은지 확인.
*/

public class boj_9663 {
    static int N;
    static boolean[] visit1; //y값이 인덱스
    static boolean[] visit2; //x+y값이 인덱스
    static boolean[] visit3; //x-y+n-1값이 인덱스
    static int answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visit1 = new boolean[40];
        visit2 = new boolean[40];
        visit3 = new boolean[40];
        check(0);
        System.out.println(answer);
    }

    public static void check(int count) { //count가 열 말하는 것.

        if (count == N){
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if(visit1[i] || visit2[i + count] || visit3[count - i + N - 1])
                continue;

            visit1[i] = true;
            visit2[i + count] = true;
            visit3[count - i + N - 1] = true;
            check(count + 1);
            visit1[i] = false;
            visit2[i + count] = false;
            visit3[count - i + N - 1] = false;
        }
    }
}
