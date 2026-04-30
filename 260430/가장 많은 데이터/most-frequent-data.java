import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static HashMap<String, Integer> check;
    public static void main(String[] args) throws Exception{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        check = new HashMap<>();

        for(int i=0; i<N; i++){
            String str = br.readLine();
            if(check.containsKey(str)){
                check.put(str, check.get(str) + 1);
            }else{
                check.put(str, 1);
            }
        }

        int answer = -1;

        for(int value : check.values()){
            if(value > answer){
                answer = value;
            }
        }

        System.out.println(answer);

    }
}