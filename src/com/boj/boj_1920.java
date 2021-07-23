package com.boj;

import java.util.*;

public class boj_1920 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arrN = new int[N];

        for (int i = 0; i < N; i++){
            arrN[i] = scanner.nextInt();
        }

        Arrays.sort(arrN);

        int M = scanner.nextInt();
        int[] arrM = new int[M];

        for (int i = 0; i < M; i++){
            arrM[i] = scanner.nextInt();

            System.out.println(binary(arrN, arrM[i], 0 , N - 1));
        }



    }

    static int binary(int[] array, int target, int start, int end) {

        while (start <=  end) {
            int mid  = (start +  end) / 2;
            if (array[mid] == target)
                return 1;
            else if (array[mid] > target)
                end = mid -  1;
            else
                start = mid + 1;
        }
        return 0;

    }
}
