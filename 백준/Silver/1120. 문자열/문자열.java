import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] A = st.nextToken().toCharArray();
        char[] B = st.nextToken().toCharArray();
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i <= B.length - A.length; i++) {
            int cnt = 0;
            int k = i;
            for (int j = 0; j < A.length; j++) {
                if (A[j] != B[k + j]) {
                    cnt++;
                }
            }
            answer = Math.min(answer, cnt);
        }
        System.out.println(answer);
    }
}