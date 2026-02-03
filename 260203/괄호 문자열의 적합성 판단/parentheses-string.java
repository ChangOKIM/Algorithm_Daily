import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> stack = new ArrayDeque<>();

        String check = br.readLine();

        boolean is_ok = true;

        for(int i=0; i<check.length(); i++){
            if(check.charAt(i) == '('){
                stack.push(1);
            }else if(check.charAt(i) == ')'){
                if(stack.isEmpty() == true){
                    is_ok = false;
                    break;
                }else{
                    stack.pop();
                }
            }
        }

        if(stack.isEmpty() && is_ok){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}