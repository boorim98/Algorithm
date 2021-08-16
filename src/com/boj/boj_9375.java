package com.boj;

import java.util.*;
import java.io.*;

public class boj_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int test = Integer.parseInt(br.readLine());

        for (int i = 0; i < test; i++){
            int n = Integer.parseInt(br.readLine());
            int result = 1;

            Map<String, Integer> map = new HashMap<>();

            for (int j = 0; j < n; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String kind = st.nextToken();

                if (map.containsKey(kind)) {
                    map.put(kind, map. get(kind) + 1);
                }
                else {
                    map.put(kind, 1);
                }
            }
            Iterator<String> it =map.keySet().iterator();
            for(int j = 0; j < map.size(); j++) {
                String key = it.next();
                result *= (map.get(key)+1);
            }

            sb.append(result - 1);
            System.out.println(sb);
            sb.setLength(0);
        }
    }
}
