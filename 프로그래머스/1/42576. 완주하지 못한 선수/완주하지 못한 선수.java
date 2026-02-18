import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0; i<participant.length; i++){
            map.put(participant[i],  map.getOrDefault(participant[i], 0) + 1);
        }
        
        for(int i=0; i<completion.length; i++){
            if(map.containsKey(completion[i])){
                map.put(completion[i], map.getOrDefault(completion[i], 0) -1);
            }
        }
        String answer = "";
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() >=1){
                answer = entry.getKey();
            }
        }
        
        
        return answer;
    }
}