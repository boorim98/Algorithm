package com.boj;

import java.util.*;
import java.io.*;

public class boj_6603 {
    static int k;
    static int[] arr;
    static int[] num;
    static boolean[] check;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0)
                break;

            arr = new int[k];
            check = new boolean[k];
            num = new int[6];
            for (int i = 0; i < k; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            back(0, 0);
            System.out.println();

        }
    }
    static public void back(int idx, int count) {
        if (count == 6){
            for (int i = 0; i < 6; i++) {
                System.out.print(num[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = idx; i < k; i++){
            if (!check[i]){
                check[i] = true;
                num[count] = arr[i];
                back(i + 1,count + 1); //오름차순이기 때문에 인덱스 위치 필요.
                check[i] = false;
            }
        }
    }
}
