package com.boj;

import java.util.*;

public class boj_4949 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;
        while (true) {
            s = scanner.nextLine();
            if (s.equals(".")) {
                break;
            }
            System.out.println(solve(s));
        }
    }

    public static String solve(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(' || s.charAt(i) == '[') {
                    stack.push(s.charAt(i));
                }
                else if (s.charAt(i) == ')') {
                    if (stack.empty() || stack.peek() != '(') {
                        return ("no");
                    }
                    else stack.pop();
                }
                else if (s.charAt(i) == ']') {
                    if (stack.empty() || stack.peek() != '[') {
                        return ("no");
                    }
                    else stack.pop();
                }
            }

            if (stack.isEmpty()) {
                return ("yes");
            }
            else  return ("no");
        }
}
