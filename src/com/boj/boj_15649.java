package com.boj;

import java.util.*;
import java.io.*;

public class boj_15649 {
    static int n, m;
    static int[] arr;
    static boolean[] check;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[10];
        check = new boolean[10];

        back(0);
    }
    public static void back(int count){
        if (count == m) {
            for (int i = 0; i < m; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++){
            if (!check[i]) {
                arr[count] = i;
                check[i] = true;
                back(count + 1);
                check[i] = false;
            }
        }
    }
}
