import java.io.*;
import java.util.*;

public class Main {

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;
            do {
                c = readByte();
                if (c == -1) throw new EOFException();
            } while (c <= ' ');

            long sign = 1;
            if (c == '-') {
                sign = -1;
                c = readByte();
            }

            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int N = fs.nextInt();
        long[] a = new long[N];
        for (int i = 0; i < N; i++) a[i] = fs.nextLong();

        Arrays.sort(a);

        int l = 0, r = N - 1;
        long bestAbs = Long.MAX_VALUE;
        long ans1 = a[l], ans2 = a[r];

        while (l < r) {
            long sum = a[l] + a[r];
            long abs = Math.abs(sum);

            if (abs < bestAbs) {
                bestAbs = abs;
                ans1 = a[l];
                ans2 = a[r];
                if (bestAbs == 0) break;
            }

            if (sum < 0) l++;
            else r--;
        }

        if (ans1 <= ans2) System.out.println(ans1 + " " + ans2);
        else System.out.println(ans2 + " " + ans1);
    }
}
