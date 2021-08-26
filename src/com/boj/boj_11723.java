package com.boj;

import java.util.*;
import java.io.*;

public class boj_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st1.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < M; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            String s = st2.nextToken();
            int n;

            switch (s) {
                case "add":
                    n = Integer.parseInt(st2.nextToken());
                    if (!arr.contains(n)) {
                        arr.add(n);
                    }
                    break;
                case "remove" :
                    n = Integer.parseInt(st2.nextToken());
                    if (!arr.contains(n)) {
                        arr.remove(n);
                    }
                    break;
                case "check":
                    n = Integer.parseInt(st2.nextToken());
                    if (!arr.contains(n)) {
                        System.out.println(0);
                    }
                    else System.out.println(1);
                    break;
                case "toggle":
                    n = Integer.parseInt(st2.nextToken());
                    if (!arr.contains(n)) {
                        arr.add(n);
                    }
                    else
                        arr.remove(Integer.valueOf(n));
                    break;
                case "all":
                    arr.clear();
                    for (int j = 1; j <= 20; j++){
                        arr.add(j);
                    }
                    break;
                case "empty":
                    arr.clear();
                    break;
            }

        }
    }
}
