package com.boj;

import java.util.Scanner;

public class boj_2941 {
    public static void main(String[] args) {

        /*Scanner scanner = new Scanner(System.in);
        StringBuffer buffer = new StringBuffer(scanner.nextLine());

        String[] alphabet = {"dz=", "c=", "c-", "d-", "lj", "nj", "s=", "z="};
        int answer = 0;
        int leng = 0;

        for (int i = 0; i < alphabet.length; i++) {
            int start = 0;
            //int inx = buffer.indexOf(alphabet[i], start);

            while (buffer.indexOf(alphabet[i], start) != -1) {
                System.out.println("start = " + start);
                answer++;
                start = buffer.indexOf(alphabet[i], start) + alphabet[i].length();
                leng += alphabet[i].length();
            }
        }

        answer += buffer.length() - leng;
        System.out.println(answer);*/

        Scanner scanner = new Scanner(System.in);

        String alphabet[] = {"c=", "c-", "dz=", "d-", "lj", "nj","s=", "z="};

        String alph = scanner.next();


        for(int i=0;i<alphabet.length;i++) {
            alph = alph.replace(alphabet[i], "a");
        }

        System.out.println(alph.length());

    }
}
