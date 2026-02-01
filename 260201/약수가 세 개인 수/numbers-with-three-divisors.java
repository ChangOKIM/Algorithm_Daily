import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        StringTokenizer st = new StringTokenizer(str);
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int result = 0;

        for(int check =start; check<end+1; check++){
            int cnt = 0;
            for(int j=1; j<check+1; j++){
                if(check%j == 0){
                    cnt +=1;
                }
            }
            if (cnt ==3){
                result +=1;
            }
        }

        System.out.println(result);
    }
}