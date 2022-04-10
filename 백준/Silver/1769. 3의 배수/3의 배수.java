import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();

        int cnt = 0;

        while (true) {
            long sum = 0;
            if (num.length() == 1) {
                break;
            }
            for (int i = 0; i < num.length(); i++) {
                sum += Integer.parseInt(String.valueOf(num.charAt(i)));
            }
            cnt++;
            num = String.valueOf(sum);
        }
        System.out.println(cnt);
        if (Integer.parseInt(num) % 3 != 0) {
            System.out.println("NO");
        }
        else System.out.println("YES");
    }
}
