import java.io.*;
import java.util.*;

public class Main {
    static int[][] materials;
    static boolean[] visited;
    static int N, min;
    public static void solve(int start) {
        if (start == materials.length) {
            int sour = 1;
            int bit = 0;
            int count = 0;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    count++;
                    sour *= materials[i][0];
                    bit += materials[i][1];
                }
            }
            if (count == 0) {
                return;
            }
            if (min > Math.abs(sour - bit)) {
                min = Math.abs(sour - bit);
            }
            return;
        }
        visited[start] = true;
        solve(start + 1);
        visited[start] = false;
        solve(start + 1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        materials = new int[N][2];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            materials[i][0] = Integer.parseInt(st.nextToken());
            materials[i][1] = Integer.parseInt(st.nextToken());
        }

        min = Integer.MAX_VALUE;
        solve(0);
        System.out.println(min);
    }
}
