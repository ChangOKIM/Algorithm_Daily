import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = i+1;
        }

        int cnt = 0;

        for(int j=0; j<N; j++){
            if(arr[j]%2==0 || arr[j]%3==0 || arr[j]%5==0){
                cnt +=1;
            }
        }

        System.out.println(N-cnt);

    }
}