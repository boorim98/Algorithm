package com.boj;

import java.util.*;
import java.io.*;

public class boj_15649 {
    static int n, m;
    static int[] arr;
    static boolean[] check;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[10]; //만든 조합을 저장하는 배열
        check = new boolean[10]; //중복이 허용 안되므로 수가 사용되었는지 확인하는 boolean 배열

        back(0); //배열의 길이로 인자
    }
    public static void back(int count){
        if (count == m) { //count가 m이랑 같으면 배열 출력
            for (int i = 0; i < m; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++){ //if문에 해당하지 않는다면 아직 배열에 수를 넣어야 함
            if (!check[i]) { //아직 쓰이지 않은 수이면
                arr[count] = i; //배열에 수 저장
                check[i] = true; //그 수 쓰였다고 boolean 배열에 저장
                back(count + 1); //count 하나 늘려서 함수 다시 실행
                check[i] = false; //return 후 다시 원래대로 돌려놓기
            }
        }
    }
}
