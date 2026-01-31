import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];


        String str = br.readLine();

        StringTokenizer st = new StringTokenizer(str);

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int j=(N-1); j>=0; j--){
            if(arr[j]%2 == 0){
                System.out.printf(arr[j] + " ");
            }
        }
    }
}