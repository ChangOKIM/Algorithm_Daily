import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int start = A;
        StringBuilder sb = new StringBuilder();
        sb.append(start).append(" ");

        while(true){
            if(start %2 == 1){
                start *= 2;
                if(start >B){
                    break;
                }
                sb.append(start).append(" ");
            }else{
                start += 3;
                if(start >B){
                    break;
                }
                sb.append(start).append(" ");
            }
        }

        System.out.println(sb);


    }
}