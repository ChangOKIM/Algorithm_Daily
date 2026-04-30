import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        // Please write your code here.
        HashMap<Integer, Integer> m = new HashMap<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(str.equals("add")){
                int k = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                m.put(k, v);
            }else if(str.equals("find")){
                int findV = Integer.parseInt(st.nextToken());
                if(m.containsKey(findV)){
                    System.out.println(m.get(findV));
                }else{
                    System.out.println("None");
                }
            }else if(str.equals("remove")){
                int removeV = Integer.parseInt(st.nextToken());
                m.remove(removeV);
            }
        }

    }
}