import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0; i<N; i++){
            String cmd = br.readLine();
            StringTokenizer st = new StringTokenizer(cmd);

            String check_cmd = st.nextToken();

            if(check_cmd.equals("push")) stack.push(Integer.parseInt(st.nextToken()));
            else if(check_cmd.equals("size")) System.out.println(stack.size());
            else if(check_cmd.equals("pop")) System.out.println(stack.pop());
            else if(check_cmd.equals("top")) System.out.println(stack.peek());
            else if(check_cmd.equals("empty")){
                if(stack.isEmpty()){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }
        }
    }
}
