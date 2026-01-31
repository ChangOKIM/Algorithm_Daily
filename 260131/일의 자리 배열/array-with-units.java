import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        StringTokenizer st = new StringTokenizer(str1);

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] arr = new int[10];
        arr[0] = a;
        arr[1] = b;

        for(int i=2; i<10; i++){
            arr[i] = (arr[i-1] + arr[i-2])%10;
        }

        for(int j=0; j<10; j++){
            System.out.print(arr[j] + " ");
        }
    }
}