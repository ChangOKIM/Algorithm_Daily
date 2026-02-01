import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=1; i<N+1; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<i; j++){
                sb.append(i).append(" ");
            }
            System.out.println(sb);
        }
    }
}