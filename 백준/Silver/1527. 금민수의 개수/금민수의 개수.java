import java.util.*;
import java.io.*;

public class Main {
    static int A, B;
    static long count = 0;
    public static void solve (long number) {
        if (number > B) return; //return 조건 달아야함.
        if (number >= A && number <= B) {
            count++;
        }

        solve(number * 10 + 4);
        solve(number *  10 + 7);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        solve(4);
        solve(7);
        System.out.println(count);
       
    }
}