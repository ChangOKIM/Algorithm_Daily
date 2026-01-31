import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String str = br.readLine();

        int[] arr = new int[3];
        StringTokenizer st = new StringTokenizer(str);
        
        for(int i=0; i<N; i++){
           arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int j=0; j<N; j++){
            arr[j] *= arr[j];
        }

        for(int k=0; k<N; k++){

            System.out.print(arr[k] + " ");

        }
    }
}