import java.io.*;
import java.util.*;

public class Main {
    static int K;
    static String N;
    static int[] arr;
    static StringTokenizer st;
    static int[] selected;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = st.nextToken();
        K = Integer.parseInt(st.nextToken());

        arr = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        selected = new int[N.length()];
        if (makeSameLength(0, false)) {
            StringBuilder sb = new StringBuilder();
            for (int num : selected) {
                sb.append(num);
            }
            System.out.println(sb);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N.length() - 1; i++) {
            sb.append(arr[K - 1]);
        }
        System.out.println(sb);
    }

    static boolean makeSameLength(int idx, boolean alreadySmall) {
        if (idx == N.length()) {
            return true;
        }

        int limit = alreadySmall ? 9 : N.charAt(idx) - '0';

        for (int i = K - 1; i >= 0; i--) {
            if (arr[i] > limit) continue;

            selected[idx] = arr[i];

            boolean nextSmall = alreadySmall || (arr[i] < limit);

            if (makeSameLength(idx + 1, nextSmall)) {
                return true;
            }
        }

        return false;
    }
}