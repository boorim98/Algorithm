package com.boj;

import java.util.*;

public class boj_1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        String[] arr = s.split("\\-");

        int result = add(arr[0]);
        for (int i = 1; i < arr.length; i++){
            result -= add(arr[i]);
        }
        System.out.println(result);
    }

    public static int add(String s) {
        String[] arr = s.split("\\+");

        int result = 0;

        for (int i = 0; i < arr.length; i++){
            result += Integer.parseInt(arr[i]);
        }

        return result;
    }
}
