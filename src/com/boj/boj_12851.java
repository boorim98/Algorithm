package com.boj;

import java.util.*;
import java.io.*;

/*
현재 index까지 올 수 있는 방법이 몇개있는지 담는 cnt[index]배열이 필요하다.
check[index] = true 임에도 next위치에 가는 경로가 최단이면 cnt를 늘려주어야 한다.
아직 방문하지 않은 상태
이미 방문 했더라도 이동거리가 같은 경우
dist[next] = dist[now] +1 이라면 queue에 넣어주면 된다.
 */
public class boj_12851 {
    static int n, k;
    static int[] arr, cnt;
    static boolean[] visit;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[100001];
        cnt = new int[100001];
        visit = new boolean[100001];

        bfs();
        System.out.println(arr[k]);
        System.out.println(cnt[k]);
    }

    public static void bfs() {
        Queue<Integer> que = new LinkedList<>();
        que.offer(n);
        cnt[n] = 1;
        visit[n] = true;

        while (!que.isEmpty()) {
            int now = que.poll();
            int[] next = {now - 1, now + 1, now * 2};
            for (int n : next) {
                if (n >= 0 && n <= 100000) {
                    if (!visit[n]) {
                        visit[n] = true;
                        que.offer(n);
                        arr[n] = arr[now] + 1;
                        cnt[n] = cnt[now];
                    }
                    else if (arr[n] == arr[now] + 1) {
                        cnt[n] += cnt[now];
                    }
                }
            }
        }
    }

}
