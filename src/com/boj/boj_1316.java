package com.boj;

import java.util.*;

public class boj_1316 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int result = 0;

        for (int i = 0; i < num; i++) {
           String s = scanner.next();
           HashMap<Character,Integer> hashMap = new HashMap<>();

           int x = 1;
           boolean b = true;
           for (int j = 0; j < s.length(); j++) {
               char c = s.charAt(j);

               if (hashMap.containsKey(c) && s.charAt(j-1) != s.charAt(j)) {
                   b = false;
                   continue;
               }
               hashMap.put(c,x);
           }

           if (b) {
               result++;
           }
        }

        System.out.println(result);
    }
}
