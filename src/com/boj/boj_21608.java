package com.boj;

import java.util.*;
import java.io.*;

public class boj_21608 {
    static int N;
    static int[][] arr, empty;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Map<Integer, Student> list = new HashMap<>();

    static class Student{
        int x;
        int y;
        int[] friends;

        public Student(int x, int y, int[] friends){
            this.x = x;
            this.y = y;
            this.friends = friends;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        int answer = 0;

        findEmpty();
        for (int i = 0; i < N * N; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());
            int s3 = Integer.parseInt(st.nextToken());
            int s4 = Integer.parseInt(st.nextToken());

            findSeat(num, new int[]{s1, s2, s3, s4});
        }

        for(int i=1; i<=N * N; i++) {
            Student student = list.get(i);
            int cnt = 0;
            for(int friend : student.friends) {
                if(Math.abs(list.get(friend).x -student.x) + Math.abs(list.get(friend).y - student.y) == 1) {
                    cnt++;
                }
            }

            if(cnt==1) answer+=1;
            else if(cnt==2) answer+=10;
            else if(cnt==3) answer+=100;
            else if(cnt==4) answer+=1000;
        }
        System.out.println(answer);
    }

    public static void findEmpty(){
        empty = new int[N][N];

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                int emp = 4; //4방향이니 빈 자리가 4개가 최대이지만 끝부분에 위치한 자리는 4개보다 적을테니
                if (i == 0 || i == N - 1)
                    emp--;
                if (j == 0 || j == N - 1)
                    emp--;
                empty[i][j] = emp;
            }
        }
    }

    public static void findSeat(int num, int[] f) {
        int[][] nearScore = new int[N][N]; //주변에 친한 친구가 많은 위치를 찾기 위한 배열
        for(int friend : f) {
            if(list.containsKey(friend)) {
                Student student = list.get(friend);
                int x = student.x;
                int y = student.y;

                for(int i=0; i<4; i++) {
                    int nx = x+dx[i];
                    int ny = y+dy[i];
                    if(nx>=0 && nx <N && ny >=0 && ny < N && arr[nx][ny] == 0) {
                        nearScore[nx][ny]++;
                    }
                }
            }
        }
        int emptyCntMax = -1;
        int nearScoreMax = -1;
        int choiceX = -1;
        int choiceY = -1;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(arr[i][j] != 0) continue;
                if(nearScoreMax < nearScore[i][j]) {
                    choiceX = i;
                    choiceY = j;
                    nearScoreMax = nearScore[i][j];
                    emptyCntMax = empty[i][j];
                } else if(nearScoreMax == nearScore[i][j] && emptyCntMax < empty[i][j]) {
                    emptyCntMax = empty[i][j];
                    choiceX = i;
                    choiceY = j;
                }
            }
        }

        arr[choiceX][choiceY] = num; //num = 학생 번호
        list.put(num, new Student(choiceX,choiceY, f));

        for(int i=0; i<4; i++) {
            int nx = choiceX+dx[i];
            int ny = choiceY+dy[i];
            if(nx>=0 && nx <N && ny >=0 && ny < N && arr[nx][ny] == 0) {
                empty[nx][ny]--;
            }
        }
    }
}
