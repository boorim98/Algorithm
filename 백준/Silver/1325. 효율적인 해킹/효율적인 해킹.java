import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static ArrayList<Integer>[] arr;
    static Queue<Integer> queue;
    static boolean[] visit;
    static int[] rank;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N + 1];
        rank = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());

            arr[vertex1].add(vertex2);
        }

        for (int i = 1; i <= N; i++) {
            bfs(i);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, rank[i]);
        }

        for (int i = 1; i <= N; i++) {
            if (max == rank[i]) {
                System.out.print(i + " ");
            }
        }

    }

    public static void bfs (int i) {
        queue = new LinkedList<>();
        visit = new boolean[N + 1];
        
        queue.offer(i);
        visit[i] = true;

        while (!queue.isEmpty()) {
            int start = queue.poll();

            for (int j : arr[start]) {
                if(!visit[j]) {
                    queue.offer(j);
                    visit[j] = true;
                    rank[j] = rank[j] + 1;
                }
            }
        }
    }
}