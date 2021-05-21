package com.boj;
import java.util.*;

public class boj_1157 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

        int[] wordArray = new int[26];

        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            if (Character.isUpperCase(w)) {
                wordArray[w-65]++;
            }
            else {
                wordArray[w-97]++;
            }
        }

        /*int max = 0;
        boolean many = true;
        for (int i = 1; i < wordArray.length; i++) {
            if (wordArray[max] <= wordArray[i]) {
                max = i;
            }
        }

        for (int i = 0; i < wordArray.length; i++) {
            if (i == max) {
                continue;
            }
            else {
                if (wordArray[i] == wordArray[max]) {
                    many = false;
                }
            }
        }

        if (many) System.out.println((char)(max+65));
        else System.out.println("?");*/

        int max = -1;
        char ch = '?';

        for (int i = 0; i < 26; i++) {
            if (wordArray[i] > max) {
                max = wordArray[i];
                ch = (char) (i + 65); // 대문자로 출력해야하므로 65를 더해준다.
            }
            else if (wordArray[i] == max) {
                ch = '?';
            }
        }

        System.out.println(ch);

    }
}

