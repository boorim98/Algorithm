import java.io.*;

public class Main {
    static int N;
    static int[] arr = {1, 5, 10, 50};
    static int answer = 0;
    static boolean[] check = new boolean[10001];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        back(0,0,0);

        System.out.println(answer);

    }
    public static void back(int depth, int start, int sum) {
        if (depth == N) {
            if (!check[sum]) {
                answer++;
                check[sum] = true;
            }
            return;
        }

        for (int i = start; i < 4; i++) {
            back(depth + 1, i, sum + arr[i]);
        }

    }
}