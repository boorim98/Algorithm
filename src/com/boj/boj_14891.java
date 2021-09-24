package com.boj;

import java.util.*;
import java.io.*;

public class boj_14891 {
    static ArrayList<String>[] arr;
    static int K, rot, dir;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new ArrayList[5];
        for (int i = 1; i <= 4; i++){
            arr[i] = new ArrayList();
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                arr[i].add(String.valueOf(s.charAt(j)));
            }
        }

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            rot = Integer.parseInt(st.nextToken());
            dir = Integer.parseInt(st.nextToken()); //1 : 시계, -1 : 반시계

            check(rot, dir);
        }

        int sum = 0;
        for (int i = 1; i <= 4; i++){
            if (arr[i].get(0).equals("1")){
                switch (i){
                    case(1):
                        sum += 1;
                        break;
                    case(2):
                        sum += 2;
                        break;
                    case(3):
                        sum += 4;
                        break;
                    case(4):
                        sum += 8;
                }
            }
        }
        System.out.println(sum);

    }

    public static void check(int rot, int dir) {
        left(rot - 1, -dir);
        right(rot + 1, -dir);
        rotate(rot, dir);
    }
    public static void left(int rot, int dir) {
        if (rot < 1)
            return;
        if (!arr[rot].get(2).equals(arr[rot + 1].get(6))){
            left(rot - 1, -dir);
            rotate(rot, dir);
        }
    }

    public static void right(int rot, int dir) {
        if (rot > 4)
            return;
        if (!arr[rot].get(6).equals(arr[rot - 1].get(2))){
            right(rot + 1, -dir);
            rotate(rot, dir);
        }
    }
    public static void rotate(int rot, int dir) {
        if (dir == 1){
            arr[rot].add(0, arr[rot].remove(7));
        }
        else {
            arr[rot].add(7, arr[rot].remove(0));
        }
    }
}
