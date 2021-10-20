package com.boj;

import java.io.*;
import java.util.*;

public class boj_13335 {
    static int n, w, l;
    static int time, weight = 0;
    static int[] truck;
    static Queue<Integer> bridge;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        truck = new int[n];
        bridge = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            truck[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            while (true) {
                if (bridge.isEmpty()) {
                    bridge.offer(truck[i]);
                    weight += truck[i];
                    time++;
                    break;
                }
                else if (bridge.size() == w) {
                    weight -= bridge.remove();
                }
                else {
                    if (weight + truck[i] > l) {
                        bridge.offer(0);
                        time++;
                    }
                    else {
                        bridge.offer(truck[i]);
                        time++;
                        weight += truck[i];
                        break;
                    }
                }
            }

        }
        System.out.println(time + w);
    }
}
