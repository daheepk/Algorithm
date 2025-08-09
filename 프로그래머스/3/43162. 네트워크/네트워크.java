import java.io.*;
import java.util.*;

class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {

        visited = new boolean[n];
        boolean[][] graph = new boolean[n][n];
       
        int cnt = 0;
        for (int i=0; i<n; i++){
            if (!visited[i]){
                cnt+=1;
                visited[i] = true;
                BFS(computers, n, i);
            }
        }
        System.out.println(Arrays.deepToString(computers));
        System.out.println(cnt);
        return cnt;
    }
    
    static void BFS(int[][] computers, int n, int x){
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(x);
        
        while (!dq.isEmpty()){
            int cur = dq.poll();
            visited[cur] = true;
            
            if (cur<0 || cur>=n) continue;
            
            for (int i=0; i<n; i++){
                if (!visited[i] && computers[cur][i]==1){
                    dq.offer(i);
                }
            }
        }
        
    }
}