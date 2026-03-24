import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] temp = new int[progresses.length];
        for(int i=0; i<progresses.length; i++){
            if((100-progresses[i])%speeds[i] != 0){
                temp[i] = (100-progresses[i])/speeds[i] + 1;
            }else{
                temp[i] = (100-progresses[i])/speeds[i];
            }
        }
        ArrayList<Integer> ansList = new ArrayList<>();
        
        int jump = 0;
        
        while(jump <progresses.length){
            int check = temp[jump];
            int cnt = 1;
            while(jump+1<progresses.length && check >=temp[jump+1]){
                jump += 1;
                cnt += 1;
            }
            
            ansList.add(cnt);
            jump +=1;
        }
        
        int[] answer = new int[ansList.size()];
        for(int i=0; i<ansList.size(); i++){
            answer[i] = ansList.get(i);
        }
        return answer;
    }
}