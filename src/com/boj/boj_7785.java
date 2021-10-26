package com.boj;

import java.util.*;
import java.io.*;

/*
https://woovictory.github.io/2020/11/10/Map-Sort/
 */
public class boj_7785 {
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        HashMap<String, String> people = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            people.put(st.nextToken(), st.nextToken());
        }

        List<String> keys = new ArrayList<>(people.keySet());

        keys.sort(Collections.reverseOrder());
        for (String key : keys) {
            if (people.get(key).equals("enter")) {
                System.out.println(key);
            }
        }
    }
}
