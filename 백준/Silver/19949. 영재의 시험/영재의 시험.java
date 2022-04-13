import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] yj;
    static boolean[] visit;
    static int ans = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[10];
        yj = new int[10];
        visit = new boolean[10];

        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        back(0);
        System.out.println(ans);
    }

    public static void back(int depth) {
        if (depth == 10) {
            int score = 0;
            for (int i = 0; i < 10; i ++) {
                if (arr[i] == yj[i]) {
                    score++;
                }
            }
            if (score >= 5)
                ans++;
            return;
        }

        for (int i = 1; i <= 5; i++) {
            if (depth >= 2) {
                if (yj[depth - 1] == i && yj[depth - 2] == i)
                    continue;
            }
            yj[depth] = i;
            back(depth + 1);
        }
    }
}
