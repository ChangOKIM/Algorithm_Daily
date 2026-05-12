import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static ArrayDeque<Integer> queue;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        queue = new ArrayDeque<>();

        for(int i=1; i<=N; i++){
            queue.add(i);
        }

        while(queue.size() >1){
            queue.pollFirst();
            queue.add(queue.pollFirst());
        }

        System.out.println(queue.pollFirst());

    }
}