import java.util.*;
import java.io.*;


public class Main{
    public static void main(String args[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] graph1 = new int[N][M];
        int[][] graph2 = new int[N][M];
        int[][] result = new int[N][M];

        for(int x = 0; x<N; x++){
            st = new StringTokenizer(br.readLine());
            for(int y = 0; y<M; y++){
                graph1[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        for(int x = 0; x<N; x++){
            st = new StringTokenizer(br.readLine());
            for(int y = 0; y<M; y++){
                graph2[x][y] = Integer.parseInt(st.nextToken());
            }
        }


        for(int x = 0; x<N; x++){
            for(int y = 0; y<M; y++){
                result[x][y] = graph1[x][y] + graph2[x][y];
            }
        }


                for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                System.out.print(result[x][y] + " ");
            }
            System.out.println();
        }

        

    }
}

