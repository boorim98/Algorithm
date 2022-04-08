import java.util.*;
import java.io.*;

public class Main {
    static int T,N;
    static ArrayList<Integer>[] arrayLists;
    static Queue<Integer> queue;
    static boolean[] visitied;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int j = 0; j < T; j++) {
            N = Integer.parseInt(br.readLine());

            arrayLists = new ArrayList[N + 1];
            visitied = new boolean[N + 1];

            for (int i = 1; i <= N; i++){
                arrayLists[i] = new ArrayList<>();
            }

            int vertex;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                vertex = Integer.parseInt(st.nextToken());

                arrayLists[i + 1].add(vertex);
            }

            int answer = 0;
            for (int i = 1; i <= N; i++) {
                if (!visitied[i]) {
                    bfs(i);
                    answer++;
                }
            }

            System.out.println(answer);

        }
    }

    public static void bfs(int i) {
        queue = new LinkedList<>();
        queue.offer(i);
        visitied[i] = true;

        while (!queue.isEmpty()) {
            int start = queue.poll();

            for (int y : arrayLists[start]) {
                if (!visitied[y]) {
                    queue.offer(y);
                    visitied[y] = true;
                }
            }
        }
    }
}