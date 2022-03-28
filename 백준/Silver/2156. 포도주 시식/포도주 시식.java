import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] wines = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }
        
        if (n < 3) {
            int answer = 0;
            for (int i = 1; i <= n; i++) {
                answer += wines[i];
            }
            System.out.println(answer);
            return;
        }

        dp[1] = wines[1];
        dp[2] = wines[1] + wines[2];
        dp[3] = Math.max(dp[2], Math.max(wines[2] + wines[3], dp[1] + wines[3])); //여기 이유 왜?

        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + wines[i], dp[i - 3] + wines[i - 1] + wines[i]);
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }

        System.out.println(dp[n]);
    }
}