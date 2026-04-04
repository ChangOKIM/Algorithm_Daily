import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] graph;
    static boolean[][] visited;
    static ArrayList<Character> alphabet;
    static StringTokenizer st;
    static int maxMove;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new char[R][C];
        visited = new boolean[R][C];
        alphabet = new ArrayList<>();
        maxMove = 1;

        for(int i = 0; i < R; i++) {
            String s = br.readLine();
            for(int j = 0; j < C; j++) {
                graph[i][j] = s.charAt(j);
            }
        }

        alphabet.add(graph[0][0]);
        visited[0][0] = true;

        dfs(0, 0);
        System.out.println(maxMove);
    }

    static void dfs(int x, int y) {
        if(alphabet.size() > maxMove) {
            maxMove = alphabet.size();
        }

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0 <= nx && nx < R && 0 <= ny && ny < C) {
                if(!visited[nx][ny] && !usedAlpha(graph[nx][ny])) {
                    visited[nx][ny] = true;
                    alphabet.add(graph[nx][ny]);

                    dfs(nx, ny);

                    alphabet.remove(alphabet.size() - 1);
                    visited[nx][ny] = false;
                }
            }
        }
    }

    static boolean usedAlpha(char c) {
        for(int i = 0; i < alphabet.size(); i++) {
            if(alphabet.get(i) == c) {
                return true;
            }
        }
        return false;
    }
}