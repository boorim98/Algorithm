import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        String ant1 = br.readLine();
        char[] tmp1 = new char[n1];
        for (int i = 0; i < n1; i++) {
            tmp1[i]=ant1.charAt(n1-i-1);
        }

        char[] tmp2 = br.readLine().toCharArray();

        char ants[] = new char[n1 + n2];
        int dir[] = new int[n1 + n2];
        for (int i = 0; i < n1; i++) {
            ants[i] = tmp1[i];
            dir[i] = 1;
        }
        for (int i = n1; i < n1 + n2; i++){
            ants[i] = tmp2[i - n1];
            dir[i] = 2;
        }

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            t--;
            for (int i = 0; i < n1 + n2 - 1; i++) {
                if (dir[i] == 1 && dir[i + 1] == 2) {
                    char c = ants[i];
                    ants[i] = ants[i + 1];
                    ants[i + 1] = c;

                    int d = dir[i];
                    dir[i] = dir[i + 1];
                    dir[i + 1] = d;
                    i++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n1 + n2; i++) {
            sb.append(ants[i]);
        }
        System.out.println(sb);
    }
}