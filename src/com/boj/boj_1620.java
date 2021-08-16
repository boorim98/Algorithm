package com.boj;

import java.util.*;
import java.io.*;

public class boj_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, String> map1 = new LinkedHashMap<>();
        Map<String , Integer> map2 = new LinkedHashMap<>();

        for (int i = 1; i <= N; i++){
            String s = br.readLine();
            map1.put(i,s);
            map2.put(s, i);
        }

        for (int i = 0; i < M; i++){
            String q = br.readLine();

            boolean output = true;

            if (!Character.isDigit(q.charAt(0)))
                output = false;

            if (!output){ //이름으로 검색
                sb.append(map2.get(q));
            }
            else { //번호로 검색
                sb.append(map1.get(Integer.parseInt(q)));
            }

            System.out.println(sb);
            sb.setLength(0);
        }

    }
}
