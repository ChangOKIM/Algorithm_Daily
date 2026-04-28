import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int arr[];
    static int check[];
    static Deque<int []> stack;
    static StringTokenizer st;
   public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    arr = new int[N];
    check = new int[N];
    for(int i=0; i<N; i++){
        arr[i] = Integer.parseInt(st.nextToken());
    }

    stack = new ArrayDeque<>();
    
    for(int i=0; i<arr.length; i++){
        if(stack.isEmpty()){
            check[i] = 0;
            stack.add(new int[] {arr[i], i+1}); //높이, 위치값
        }else{
            
            while(!stack.isEmpty() && stack.peekLast()[0] < arr[i]){
                stack.pollLast();
            }

            if(stack.isEmpty()){
                check[i] = 0;
                stack.add(new int[] {arr[i], i+1});
            }else{
                check[i] = stack.peekLast()[1];
                stack.add(new int[] {arr[i], i+1});
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
