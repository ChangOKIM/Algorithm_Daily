import java.util.*;
import java.io.*;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N  = Integer.parseInt(br.readLine());

        ArrayList<Integer> arrlist = new ArrayList<>();

        for(int i=0; i<N; i++){
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);

            String check = st.nextToken();

            if(check.equals("push_back")){
                arrlist.add(Integer.parseInt(st.nextToken()));
            }else if(check.equals("get")){
                System.out.println(arrlist.get(Integer.parseInt(st.nextToken())-1));
            }else if(check.equals("size")){
                System.out.println(arrlist.size());
            }else if(check.equals("pop_back")){
                arrlist.remove(arrlist.size()-1);
            }
        }

    }
}