class Solution {
    public int solution(int[][] sizes) {
        int maxVal = 0;
        int minVal = 0;
        for(int i=0; i<sizes.length; i++){
            int check1 = sizes[i][0];
            int check2 = sizes[i][1];
            
            if(check1 > check2){
                if(check1>maxVal){
                    maxVal = check1;
                }
                if(check2>minVal){
                    minVal = check2;
                }
            }else{
                if(check2>maxVal){
                    maxVal = check2;
                }
                if(check1>minVal){
                    minVal = check1;
                }
            }
        }
        return maxVal * minVal;
    }
}