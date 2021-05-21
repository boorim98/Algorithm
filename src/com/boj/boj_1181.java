package com.boj;

import java.util.*;

public class boj_1181 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        List<String> st = new ArrayList<>();

        for (int i = 0; i < num; i ++) {
            String s = scanner.next();
            if(!st.contains(s)) {
                st.add(s);
            }
        }

        Comparator<String> c = new Comparator<String>() {
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                }
                return Integer.compare(s1.length(), s2.length());
            }
        };
        Collections.sort(st, c);

        for (int i = 0; i < st.size(); i++) {
            System.out.println(st.get(i));
        }
    }
}
