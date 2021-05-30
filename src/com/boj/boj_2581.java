package com.boj;

import java.util.*;

public class boj_2581 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            arrayList.add(s.substring(i));
        }

        Collections.sort(arrayList);

        for (int i = 0; i < arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }

    }
}
