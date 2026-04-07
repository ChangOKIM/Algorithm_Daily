import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static int[][] state;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        state = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (state[i][j] == 0) {
                    dfs(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    static void dfs(int x, int y) {
        state[x][y] = 1; // 현재 탐색 중

        int nx = x;
        int ny = y;

        if (map[x][y] == 'U') nx--;
        else if (map[x][y] == 'D') nx++;
        else if (map[x][y] == 'L') ny--;
        else if (map[x][y] == 'R') ny++;

        if (state[nx][ny] == 0) {
            dfs(nx, ny);
        } else if (state[nx][ny] == 1) {
            answer++;
        }

        state[x][y] = 2; // 탐색 완료
    }
}