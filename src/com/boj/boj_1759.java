package com.boj;

import java.util.*;
import java.io.*;

public class boj_1759 {
    static int L, C;
    static String[] arr;
    static String[] str;
    static boolean[] check;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new String[C];
        str = new String[C];
        check = new boolean[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++){
            arr[i] = st.nextToken();
        }

        Arrays.sort(arr);
        back(0, 0);
    }

    static public void back(int idx, int count) {
        if (count == L) {
            int ja = 0;
            int mo = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < L; i++){
                sb.append(str[i]); //sb static으로 선언하지 말고 여기서 선언해서 바로 자음 모음 확인해서 내보내면 되는 문제.
                if (str[i].equals("a") || str[i].equals("e") || str[i].equals("i") || str[i].equals("o") || str[i].equals("u")){
                    mo++;
                }
                else
                    ja++;
            }
            if (mo >= 1 && ja >= 2) {
                System.out.println(sb);
            }
            return;
        }

        for (int i = idx; i < C; i++){
            if (!check[i]) {
                check[i] = true;
                str[count] = arr[i];
                back(i + 1, count + 1);
                check[i] = false;
            }
        }
    }
}
