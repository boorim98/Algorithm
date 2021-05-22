package com.boj;

import java.util.*;

public class boj_1764 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int listen = scanner.nextInt();
        int watch= scanner.nextInt();

        ArrayList<String> listenArr = new ArrayList<>();

        ArrayList<String> result = new ArrayList<>();


        for (int i = 0; i < listen; i++) {
            listenArr.add(scanner.next());
        }

        Set<String> names = new HashSet<>(listenArr);

        for (int i = 0; i < watch; i++) {
            String s = scanner.next();
            if (names.contains(s)) {
                result.add(s);
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

    }
}
