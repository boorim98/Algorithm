package com.boj;

import java.io.*;
import java.util.*;

public class boj_1697 {
    static int K;
    static int N;
    static int[] board;
    static Queue<Integer> que;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[100001];
        que = new LinkedList<>();

        if (N == K) {
            System.out.println(0);
        } else {
            que.add(N);
            board[N] = 1;
            BFS();
        }
    }

    public static void BFS() {
        while (!que.isEmpty()) {
            int t = que.remove();

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0){
                    next = t + 1;
                }
                else if (i == 1) {
                    next = t - 1;
                }
                else {
                    next = t * 2;
                }

                if (next == K) {
                    System.out.println(board[t]);
                    return;
                }

                if (next >= 0 && next < board.length && board[next] == 0) {
                    que.add(next);
                    board[next] = board[t] + 1;
                }
            }
        }
    }
}
