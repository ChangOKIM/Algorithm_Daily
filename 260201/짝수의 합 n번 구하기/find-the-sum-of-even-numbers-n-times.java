import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int tc=0; tc<N; tc++){
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int sum = 0;

            for(int i=A; i<B+1; i++){
                if(i%2==0){
                    sum += i;
                }
            }

            System.out.println(sum);


        }
    }
}