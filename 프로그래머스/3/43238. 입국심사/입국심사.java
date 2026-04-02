import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long start = 1;
        long end = 0;
        
        for(int time : times){
            end = Math.max(end, (long)time * n);
        }
        
        long answer = end;
        
        while(start <= end){
            long mid = (start + end) /2;
            long count = 0;
            
            for(int time : times){
                count += mid/time;
                
                if(count >= n){
                    break;
                }
            }
            if(count >= n){
                answer = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return answer;
    }
    
}