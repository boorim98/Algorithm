package com.boj;

import java.util.*;

public class boj_1427 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        String numString = String.valueOf(num);

        String[] strArr = numString.split("");
        Arrays.sort(strArr,Collections.reverseOrder());
        String result = "";
        for (String s : strArr) {
            result += s;
        }
        System.out.println(Integer.valueOf(result));


    }
}
