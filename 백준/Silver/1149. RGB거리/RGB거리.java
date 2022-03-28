import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[][] rgb = new int[N][3];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                rgb[i][j] = scanner.nextInt();
            }
        }

        for (int i = 1; i < N; i++){
            rgb[i][0] += Math.min(rgb[i - 1][1], rgb[i - 1][2]);
            rgb[i][1] += Math.min(rgb[i - 1][0], rgb[i - 1][2]);
            rgb[i][2] += Math.min(rgb[i - 1][0], rgb[i - 1][1]);
        }

        System.out.println(Math.min(Math.min(rgb[N - 1][0], rgb[N - 1][1]), rgb[N - 1][2]));

    }
}