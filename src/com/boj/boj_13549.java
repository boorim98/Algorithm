package com.boj;

import java.util.*;
import java.io.*;

class node13549 {
    int x, time;

    node13549 (int x, int time) {
        this.x = x;
        this.time = time;
    }
}

public class boj_13549 {
    static int n, k;
    static int[] board;
    static boolean[] visit;
    static Queue<node13549> que;
    static int time = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new int[100001];
        visit = new boolean[100001];
        que = new LinkedList<>();

        que.offer(new node13549(n, 0));
        visit[n] = true;
        solve();
        System.out.println(time);
    }

    public static void solve() {
        while (!que.isEmpty()) {
            node13549 sb = que.poll();

            if (sb.x == k) {
                time = Math.min(time, sb.time);
            }

            // *2의 경우 time 이 증가하지 않으므로 다른 이동보다 먼저 계산되어야함.
            if (sb.x * 2 <= 100000 && !visit[sb.x * 2]) {
                que.offer(new node13549(sb.x * 2, sb.time));
                visit[sb.x * 2] = true;
            }
            if (sb.x - 1 >= 0 &&  !visit[sb.x - 1]) {
                que.offer(new node13549(sb.x - 1, sb.time + 1));
                visit[sb.x - 1] = true;
            }
            if (sb.x + 1 <= 100000 && !visit[sb.x + 1]) {
                que.offer(new node13549(sb.x + 1, sb.time + 1));
                visit[sb.x + 1] = true;
            }

        }
    }
}
