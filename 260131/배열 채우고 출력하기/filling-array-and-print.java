import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        String[] arr = new String[10];
        String[] arr_reverse = new String[10];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringTokenizer st = new StringTokenizer(str);

        for(int k=0; k<10; k++){
            arr[k] = st.nextToken();
        }

        for(int i=0; i<10; i++){
            arr_reverse[9-i] = arr[i];
        }

        for(int j=0; j<10; j++){

            System.out.print(arr_reverse[j]);

        }
    }
}