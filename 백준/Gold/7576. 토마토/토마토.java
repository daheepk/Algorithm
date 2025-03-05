import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] tomatoArr;
    static int[][] visited;
    static int M, N;
    static ArrayDeque<Node> dq = new ArrayDeque<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomatoArr = new int[N][M];
        visited = new int[N][M];

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++){
                tomatoArr[i][j] = Integer.parseInt(st.nextToken());
                if (tomatoArr[i][j] == 1){
                    dq.offer(new Node(i, j));
                    visited[i][j] = 1;
                }
            }
        }

        boolean flag = false;
        
        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                // 전체가 다 익은 토마토가 아닐 때 flag = true
                if (tomatoArr[i][j] == 0) flag = true;
                // 익은 토마토 찾기
                if (tomatoArr[i][j] == 1){
                    BFS(i, j);
                }
            }
        }

        

        int maxValue = Integer.MIN_VALUE;
        boolean isZero = false;
        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if (tomatoArr[i][j] == 0 && visited[i][j] == 0) isZero = true;
                maxValue = Math.max(maxValue, visited[i][j]);
            }
        }
        if (flag == false) System.out.println(0);
        else if (isZero == true) System.out.println(-1);
        else System.out.println(maxValue-1);
    }
    

    static void BFS(int i, int j){
        while (!dq.isEmpty()){
            Node now = dq.poll();
            for (int k=0; k<4; k++){
                int r = now.x + dr[k];
                int c = now.y + dc[k];
                if ( r<N && r>=0 && c<M && c>=0 && visited[r][c] == 0 && tomatoArr[r][c] == 0){
                    visited[r][c] = visited[now.x][now.y] + 1;
                    dq.offer(new Node(r, c));
                }
            }
        }
    }

    public static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}