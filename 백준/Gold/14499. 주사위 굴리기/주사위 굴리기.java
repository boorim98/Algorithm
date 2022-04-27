import java.util.*;
import java.io.*;

public class Main {
    static int N, M, x, y, K;
    static int[][] map;
    static int[] dice;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[20][20];
        dice = new int[7];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j  < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int m = Integer.parseInt(st.nextToken());
            int next_x = x + dx[m - 1];
            int next_y = y + dy[m - 1];

            if (next_x >= 0 && next_x < N && next_y >= 0 && next_y < M) {
                roll(m);

                if (map[next_x][next_y] == 0) {
                    map[next_x][next_y] = dice[6];
                }
                else {
                    dice[6] = map[next_x][next_y];
                    map[next_x][next_y] = 0;
                }

                x = next_x;
                y = next_y;
                System.out.println(dice[1]);
            }
        }
    }

    public static void roll (int m) {
        int tmp = dice[1];

        switch (m) {
            case 1 :
                dice[1] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[3];
                dice[3] = tmp;
                break;
            case 2 :
                dice[1] = dice[3];
                dice[3] = dice[6];
                dice[6] = dice[4];
                dice[4] = tmp;
                break;
            case 3:
                dice[1] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[2];
                dice[2] = tmp;
                break;
            case 4:
                dice[1] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[5];
                dice[5] = tmp;
                break;
        }
    }
}