import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visit;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        visit = new boolean[N + 1];

        back(0);

    }

    public static void back(int count) {

        if (count == N) {
            for (int j : arr) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        for (int i = 1; i <= N; i++){ //if문에 해당하지 않는다면 아직 배열에 수를 넣어야 함
            if (!visit[i]) { //아직 쓰이지 않은 수이면
                arr[count] = i; //배열에 수 저장
                visit[i] = true; //그 수 쓰였다고 boolean 배열에 저장
                back(count + 1); //count 하나 늘려서 함수 다시 실행
                visit[i] = false; //return 후 다시 원래대로 돌려놓기
            }
        }

    }
}