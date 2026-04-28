import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] graph;
    static List<int[]> list;
    static int[] temp;
    static int total;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        graph = new char[5][5];
        list = new ArrayList<>();
        temp = new int[7];

        for(int i=0; i<5; i++){
            String str = br.readLine();
            for(int j=0; j<5; j++){
                graph[i][j] = str.charAt(j);
                list.add(new int[] {i, j});
            }
        }

        dfs(0, 0, 0, 0);

        System.out.println(total);
    }

    static void dfs(int startIdx, int depth, int cnt_s, int cnt_y){
        if (cnt_y >= 4) return;
        if (7 - depth < 4 - cnt_s) return;
        if (depth == 7){
            if (bfs(temp)) total++;
            return;
        }

        for(int i=startIdx; i<25; i++){
            temp[depth] = i;
            int x = list.get(i)[0];
            int y = list.get(i)[1];

            if(graph[x][y] == 'S') dfs(i+1, depth+1, cnt_s+1, cnt_y);
            else                   dfs(i+1, depth+1, cnt_s,   cnt_y+1);
        }
    }
    
    static boolean bfs(int[] temp){
        boolean[][] avail = new boolean[5][5];

        for(int i=0; i<7; i++){
            int idx = temp[i];
            int x = list.get(idx)[0];
            int y = list.get(idx)[1];
            avail[x][y] = true;
        }

        int sx = list.get(temp[0])[0];
        int sy = list.get(temp[0])[1];

        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[5][5];

        q.add(new int[]{sx, sy});
        vis[sx][sy] = true;

        int cnt = 1;

        while(!q.isEmpty()){
            int[] cur = q.pollFirst();
            int cx = cur[0], cy = cur[1];

            for(int d=0; d<4; d++){
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if(nx<0 || nx>=5 || ny<0 || ny>=5) continue;
                if(!avail[nx][ny] || vis[nx][ny]) continue;

                vis[nx][ny] = true;
                q.add(new int[]{nx, ny});
                cnt++;
            }
        }

        return cnt == 7;
    }
}