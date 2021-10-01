package com.boj;

import java.util.*;
import java.io.*;

public class boj_15683 {
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int n, m, map[][], copyMap[][];
    static boolean[][] visit;
    static List<Pair> cctv;

    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
     }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        copyMap = new int[n][m];
        visit = new boolean[n][m];
        cctv = new ArrayList<>();

        int min = 0;
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0 && map[i][j] != 6){
                    cctv.add(new Pair(i,j));
                }
                if (map[i][j] == 0){ //빈 칸의 개수
                    min++;
                }
            }
        }

        for (int tmp = 0; tmp < 1<<(2 * cctv.size()); tmp++){

            for (int i = 0; i < n; i++){ //map copymap에 복사
                for (int j = 0; j < m; j++){
                    copyMap[i][j] = map[i][j];
                }
            }

            int brute = tmp;
            for (int i = 0; i < cctv.size(); i++){ //cctv 사이즈만큼 방향이 존재할테니 그 방향 하나하나를 찾아야하므로
                int dir = brute % 4; //4로 나눈 나머지가 cctv 하나의 방향
                brute /= 4; //다음 cctv 방향 구하기 위하여 몫만 남겨줌
                int x = cctv.get(i).x;
                int y = cctv.get(i).y;
                if (map[x][y] == 1){
                    upd(x, y, dir);
                }
                else if (map[x][y] == 2) {
                    upd(x, y, dir);
                    upd(x, y, dir + 2);
                }
                else if (map[x][y] == 3) {
                    upd(x, y, dir);
                    upd(x, y, dir + 1);
                }
                else if (map[x][y] == 4) {
                    upd(x, y, dir);
                    upd(x, y, dir + 1);
                    upd(x, y, dir + 2);
                }
                else {
                    upd(x, y, dir);
                    upd(x, y, dir + 1);
                    upd(x, y, dir + 2);
                    upd(x, y, dir + 3);
                }
            }

            int val = 0;
            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    if (copyMap[i][j] == 0){
                        val++;
                    }
                }
            }
            min = Math.min(min, val);
        }
        System.out.println(min);
    }
    static void upd (int x, int y, int dir){
        dir %= 4;
        while (true){
            x += dx[dir];
            y += dy[dir];
            if (Out(x, y) || copyMap[x][y] == 6) //index 벗어난 범위거나 벽일경우
                return;
            if (copyMap[x][y] != 0) // cctv일 경우
                continue;
            copyMap[x][y] = 7; //0인 부분 (빈칸) 7로 채워주기
        }
    }
    static boolean Out(int x, int y){
        return (x < 0 || x >= n || y < 0 || y >= m);
    }
}
