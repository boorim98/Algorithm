package com.boj;

import java.io.*;
import java.util.*;

public class boj_5014 {
    static int F, S, G, U, D;
    static int[] building;
    static boolean[] visit;
    static Queue<Integer> queue = new LinkedList<>();
    static int ans;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        ans = 0;

        building = new int[F + 1];
        visit = new boolean[F + 1];

        building[S] = 0;
        queue.offer(S);
        visit[S] = true;
        bfs();
    }
    public static void bfs() {
        while (!queue.isEmpty()) {

            int floor = queue.poll();

            if (floor == G) {
                System.out.println(building[floor]);
                return;
            }

            for (int i = 0; i < 2; i++) {
                int next;
                if (i == 0) {
                    next = floor + U;
                }
                else {
                    next = floor - D;
                }

                if (next > 0 && next <= F) {
                    if (!visit[next]) {
                        visit[next] = true;
                        queue.offer(next);
                        building[next]  = building[floor] + 1;
                    }
                }
            }
        }
        System.out.println("use the stairs");
    }
}
