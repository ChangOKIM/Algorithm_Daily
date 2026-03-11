import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static String S;
    static int len;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        S = br.readLine();

        len = 2 * N + 1;
        answer = 0;

        if (len > M) {
            System.out.println(0);
            return;
        }

        for (int start = 0; start + len <= M; start++) {
            if (S.charAt(start) != 'I') continue;

            if (check(start)) {
                answer++;
            }
        }

        System.out.println(answer);
    }
    
    static boolean check(int start) {
        int end = start + len - 1;

        if (S.charAt(start) != 'I' || S.charAt(end) != 'I') {
            return false;
        }

        int left = start;
        int right = end;
        int lOffset = 0;
        int rOffset = len - 1;

        while (left <= right) {
            char leftExpected = (lOffset % 2 == 0) ? 'I' : 'O';
            char rightExpected = (rOffset % 2 == 0) ? 'I' : 'O';

            if (S.charAt(left) != leftExpected) return false;
            if (S.charAt(right) != rightExpected) return false;

            left++;
            right--;
            lOffset++;
            rOffset--;
        }

        return true;
    }
}