import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static String s;
    static int cmd;
    static Deque<Character> left;
    static Deque<Character> right;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        N = s.length();
        cmd = Integer.parseInt(br.readLine());
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();

        for(int i=0; i<s.length(); i++){
            left.add(s.charAt(i));
        }


        for(int i=0; i<cmd; i++){
            st = new StringTokenizer(br.readLine());
            char cmd1 = st.nextToken().charAt(0);

            if(cmd1 == 'L'){
                if(left.isEmpty()){
                    continue;
                }else{
                    char temp = left.pollLast();
                    right.addFirst(temp);
                }
            }else if(cmd1 == 'D'){
                if(right.isEmpty()){
                    continue;
                }else{
                    char temp = right.pollFirst();
                    left.addLast(temp);
                }
            }else if(cmd1 == 'B'){
                if(left.isEmpty()){
                    continue;
                }else{
                    left.pollLast();
                }
            }else if(cmd1 == 'P'){
                char cmd2 = st.nextToken().charAt(0);
                left.addLast(cmd2);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(char x : left){
            sb.append(x);
        }

        for(char y : right){
            sb.append(y);
        }

        System.out.println(sb);
    }
}
