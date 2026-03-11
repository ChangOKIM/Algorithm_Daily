import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static String S;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		S = br.readLine();
		
		int answer = 0;
        int count = 0;

        for (int i = 1; i < M - 1; i++) {
            if (S.charAt(i - 1) == 'I' && S.charAt(i) == 'O' && S.charAt(i + 1) == 'I') {
                count++;

                if (count >= N) {
                    answer++;
                }

                i++;
            } else {
                count = 0;
            }
        }

        System.out.println(answer);
		
	}
}

