package com.boj;

import java.util.*;
import java.io.*;

public class boj_16987 {
    static int N;
    static int[] s;
    static int[] w;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        s = new int[N];
        w = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            s[i] = Integer.parseInt(st.nextToken());
            w[i] = Integer.parseInt(st.nextToken());
        }

        back(0);
        System.out.println(max);
    }
    public static void back(int hand) {
        if (hand == N) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (s[i] <= 0) count++;
            }
            if (max < count) max = count;
            return;
        }

        if (s[hand] <= 0) {
            back(hand + 1);
        }
        else {
            boolean f = false;
            for (int i = 0; i < N; i++) {
                if (i == hand || s[i] <= 0) continue;
                f = true;
                s[i] -= w[hand];
                s[hand] -= w[i];
                back(hand + 1);
                s[i] += w[hand];
                s[hand] += w[i];
            }
            if (!f) {
                back(hand + 1);
            }
        }


    }
}
