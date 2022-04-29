import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, dir, cur_x, cur_y, ans, point;
    static int[][] map;
    static Queue<node23288> queue = new LinkedList<>();
    static boolean[][] visit;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[] dice = {6, 3, 4, 5, 2, 1};

    static class node23288{
        int x,y;

        node23288(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        ans = 0;
        dir = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cur_x = 0;
        cur_y = 0;

        for (int i = 0; i < K; i++) {
            isAvailable();
            move();
            point = 1;
            bfs();
            ans += map[cur_x][cur_y] * point;
        }

        System.out.println(ans);
    }
    public static void isAvailable() {
        int nx = cur_x + dx[dir];
        int ny = cur_y + dy[dir];

        if (nx < 0 && dir == 3) { //서쪽 바라보고 있고 갈 곳 없는 경우 -> 동으로 바꿔야함
            dir = 1;
        }
        else if (nx >= N && dir == 1) {
            dir = 3;
        }
        else if (ny < 0 && dir == 2) {
            dir = 0;
        }
        else if (ny >= M && dir == 0) {
            dir = 2;
        }
    }
    public static void move() {
        cur_x = cur_x + dx[dir];
        cur_y = cur_y + dy[dir];

        dice_change();
        dir_change();
    }
    public static void dice_change() {
        int[] tmp = new int[6];
        for (int i = 0; i < 6; i++) {
            tmp[i] = dice[i];
        }

        if (dir == 0) {
            dice[0] = tmp[1];
            dice[1] = tmp[5];
            dice[2] = tmp[0];
            dice[5] = tmp[2];
        }
        else if (dir == 1) {
            dice[5] = tmp[4];
            dice[3] = tmp[5];
            dice[0] = tmp[3];
            dice[4] = tmp[0];
        }
        else if (dir == 2) {
            dice[0] = tmp[2];
            dice[1] = tmp[0];
            dice[5] = tmp[1];
            dice[2] = tmp[5];
        }
        else if (dir == 3) {
            dice[0] = tmp[4];
            dice[4] = tmp[5];
            dice[3] = tmp[0];
            dice[5] = tmp[3];
        }
    }
    public static void dir_change() {
        if (dice[0] > map[cur_x][cur_y]) {
            dir += 1;
        }
        else if (dice[0] < map[cur_x][cur_y]) {
            dir -= 1;
        }
        if (dir >= 4) {
            dir -= 4;
        }
        else if (dir < 0) {
            dir += 4;
        }
    }
    public static void bfs() {
        visit = new boolean[N][M];
        queue.add(new node23288(cur_x, cur_y));
        visit[cur_x][cur_y] = true;

        while (!queue.isEmpty()) {
            node23288 node = queue.poll();
            int x = node.x;
            int y = node.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] == map[x][y] && !visit[nx][ny]) {
                        point++;
                        visit[nx][ny] = true;
                        queue.offer(new node23288(nx, ny));
                    }
                }
            }
        }
    }
}