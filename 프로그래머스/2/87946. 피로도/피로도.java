class Solution {
    static int[] temp;
    static boolean[] visited;
    static int answer;
    static int dungeonSize;
    static int kGlobal;
    static int[][] dungeonsGlobal;
    
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        dungeonSize = dungeons.length;
        temp = new int[dungeonSize];
        visited = new boolean[dungeonSize];
        kGlobal = k;
        dungeonsGlobal = dungeons.clone();
        
        dfs(0);
        return answer;
    }
    
    static void dfs(int depth){
        if(depth == dungeonSize){
            int dungeonCount = checkDungeon();
            if(dungeonCount > answer){
                answer = dungeonCount;
            }
            return;
        }
        
        for(int i=0; i<dungeonSize; i++){
            if(visited[i]) continue;
            
            visited[i] = true;
            temp[depth] = i;
            dfs(depth+1);
            visited[i] = false;
            
        }
        
    }
    
    static int checkDungeon(){
    int cnt = 0;
    int availK = kGlobal;
    
    for(int i=0; i<dungeonSize; i++){
        int idx = temp[i];
        
        if(dungeonsGlobal[idx][0] <= availK){
            availK -= dungeonsGlobal[idx][1];
            cnt += 1;
        }else{
            break;
        }
    }
    return cnt;
}
}