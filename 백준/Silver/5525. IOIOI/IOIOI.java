import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        StringBuilder sb = new StringBuilder();
        sb.append('I');
        for (int i = 0; i < N; i++) {
            sb.append("OI");
        }
        String target = sb.toString();

        int windowSize = 2 * N + 1;
        int answer = 0;

        if (windowSize > M) {
            System.out.println(0);
            return;
        }

        int countI = 0;
        int countO = 0;

        for (int i = 0; i < windowSize; i++) {
            if (S.charAt(i) == 'I') countI++;
            else countO++;
        }

        if (countI == N + 1 && countO == N) {
            if (S.substring(0, windowSize).equals(target)) {
                answer++;
            }
        }

        for (int left = 0, right = windowSize; right < M; left++, right++) {
            if (S.charAt(left) == 'I') countI--;
            else countO--;

            if (S.charAt(right) == 'I') countI++;
            else countO++;

            if (countI == N + 1 && countO == N) {
                if (S.substring(left + 1, right + 1).equals(target)) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}