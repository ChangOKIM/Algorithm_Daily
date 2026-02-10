import java.util.*;
import java.io.*;

public class Solution {
    public int[] solution(int []arr) throws Exception{
        int[] answer = {};
        Deque<Integer> temp = new ArrayDeque<>();
        
        for(int i=0; i<arr.length; i++){
            if(temp.isEmpty() || temp.peekLast() != arr[i]) {
            	temp.add(arr[i]);
            }
        }
        
        answer = new int[temp.size()];
        
        for(int i=0; i<answer.length; i++) {
        	answer[i] = temp.pollFirst();
        }
        
        return answer;
    }
}