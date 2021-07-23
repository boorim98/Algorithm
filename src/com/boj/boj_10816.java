package com.boj;

import java.io.*;
import java.util.*;

public class boj_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arrN = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arrN[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrN);

        int M = Integer.parseInt(br.readLine());
        int[] arrM = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++){

            int target = Integer.parseInt(st.nextToken());

            int lower = lowerBound(arrN, target, 0 , N);
            int upper = upperBound(arrN, target, 0 , N) - 1;

            if ( lower != upper) {
                arrM[i] += upper - lower + 1;
            }
            else
                arrM[i]++;
        }

        for (int i = 0; i < M; i++) {
            sb.append(arrM[i]).append(" ");
        }
        System.out.println(sb);
    }

    static int upperBound(int[] array, int target, int start, int end) {
        int mid = 0;
        while (start <  end) {
            mid  = (start +  end) / 2;
            if (target >= array[mid])
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }

    static int lowerBound(int[] array, int target, int start, int end) {
        int mid = 0;
        while (start <  end) {
            mid  = (start +  end) / 2;
            if (target <= array[mid])
                end = mid;
            else
                start = mid + 1;
        }
        return start;

    }
}
