package com.boj;

import java.util.*;
import java.io.*;

public class boj_15686 {
    static int N, M;
    static int[][] arr;
    static boolean[] visit;
    static ArrayList<Node> chicken;
    static ArrayList<Node> house;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        chicken = new ArrayList<>();
        house = new ArrayList<>();

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 1){
                    house.add(new Node(i, j));
                }
                else if (arr[i][j] == 2) {
                    chicken.add(new Node(i, j));
                }
            }
        }

        visit = new boolean[chicken.size()];
        check(0, 0);
        System.out.println(min);
    }

    static public void check(int idx, int count){
        if (count == M) {
            int total = 0;
            for (int i = 0; i < house.size(); i++){
                int sum = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++){
                    if (visit[j]){
                        int dist = Math.abs(house.get(i).x - chicken.get(j).x) + Math.abs(house.get(i).y - chicken.get(j).y);
                        sum = Math.min(sum, dist);
                    }
                }
                total += sum;
            }
            min = Math.min(min, total);
            return;
        }

        for (int i = idx; i < chicken.size(); i++){
            visit[i] = true;
            check(i + 1, count + 1);
            visit[i] = false;
        }
    }

    static class Node{
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
