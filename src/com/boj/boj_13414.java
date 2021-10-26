package com.boj;

import java.util.*;
import java.io.*;

/*
https://velog.io/@kha0318/Algorithm-%EB%B0%B1%EC%A4%80-13414-%EC%88%98%EA%B0%95%EC%8B%A0%EC%B2%AD
 */

public class boj_13414 {
    static int k, l;
    static LinkedHashMap<String, Boolean> ha = new LinkedHashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        for (int i = 0; i < l; i++) {
            String id = br.readLine();

            if (ha.containsKey(id)) {
                ha.remove(id);
            }
            ha.put(id,true);
        }

        List<String> keys = new ArrayList<>(ha.keySet());
        for(String s : keys) {
            if (k <= 0)
                break;
            System.out.println(s);
            k--;
        }
    }
}
