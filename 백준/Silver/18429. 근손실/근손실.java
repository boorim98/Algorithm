import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] work;
    static int[] weight;
    static boolean[] visit;
    static int ans = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        work = new int[N];
        weight = new int[N];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            work[i] = Integer.parseInt(st.nextToken());
        }

        back(0, 500);
        System.out.println(ans);

    }
    public static void back(int depth, int sum) {
        if (depth == N) {
            ans++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i] && sum + work[i] - K >= 500) {
                weight[depth] = work[i];
                visit[i] = true;
                back(depth + 1, sum + work[i] - K);
                visit[i] = false;
            }
        }
    }
}