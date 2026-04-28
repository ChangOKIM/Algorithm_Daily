import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] check;
    static Deque<Integer> stack;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        check = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        stack = new ArrayDeque<>();

        for(int i=arr.length-1; i>=0; i--){
            if(stack.isEmpty()){
                check[i] = -1;
                stack.addLast(arr[i]);
            }else{
                while(!stack.isEmpty() && stack.peekLast() <= arr[i]){
                    stack.pollLast();
                }

                if(stack.isEmpty()){
                    check[i] = -1;
                    stack.addLast(arr[i]);
                }else{
                    check[i] = stack.peekLast();
                    stack.addLast(arr[i]);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<check.length; i++){
            sb.append(check[i]).append(" ");
        }

        System.out.println(sb);
    }
}
