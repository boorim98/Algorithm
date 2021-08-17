package com.boj;

import java.util.*;
import java.io.*;

public class boj_1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        Map<String , Integer> map = new TreeMap<>();

        for (int i = 0; i < N; i++){
            String title = br.readLine();

            if (map.containsKey(title)) {
                map.put(title, map.get(title) + 1);
            }
            else {
                map.put(title, 1);
            }
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());

        System.out.println(entryList.get(0).getKey());

    }
}
