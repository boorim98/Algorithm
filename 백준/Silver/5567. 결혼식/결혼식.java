import java.util.*;
import java.io.*;

public class Main{
    static int n,m;
    static ArrayList<Integer>[] arr;
    static Queue<Integer> queue;
    static int[] visit;
    static int num = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        arr = new ArrayList[n + 1];
        visit = new int[n + 1];

        for(int i = 1; i < n+1; i++) {
            arr[i] = new ArrayList<>();
            //인접리스트 구현
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        bfs(1);
        System.out.println(num);
    }
    public static void bfs(int i) {
        queue = new LinkedList<>();

        queue.offer(i);
        visit[i]++;

        while(!queue.isEmpty()) {
            int start = queue.poll();

            if (visit[start] >= 3) {
                break;
            }

            for (int j : arr[start]) {
                if (visit[j] == 0) {
                    queue.offer(j);
                    visit[j] = visit[start] + 1; //이 부분이 핵심
                    num++;
                }
            }
        }
    }
}