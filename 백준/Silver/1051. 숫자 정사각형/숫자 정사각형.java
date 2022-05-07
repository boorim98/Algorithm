import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] sqare;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sqare = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                sqare[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        int answer = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 1; i + k < N && j + k < M; k++) {
                    if (sqare[i][j] == sqare[i + k][j] && sqare[i][j] == sqare[i][j + k] && sqare[i][j] == sqare[i + k][j + k]) {
                        if ( (k + 1) * (k + 1) > answer) {
                            answer = (k + 1) * (k + 1) ;
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}