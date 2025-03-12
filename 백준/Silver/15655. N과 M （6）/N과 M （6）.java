import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] intArr;
    static boolean[] visited;
    static int[] result;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        result = new int[M];

        intArr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            intArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(intArr);

        permutation(0, 0);

        bw.write(sb.toString());
        bw.close();
        br.close();
        
    }

    static void permutation(int idx, int start){
        if (idx == M){
            for (int shape:result){
                sb.append(shape).append(" ");
            }
            sb.append("\n");
            return;
        }

        if(idx > M) return;

        for(int i=start; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                result[idx] = intArr[i];                 
                permutation(idx+1, i+1);
                visited[i] = false;
            }
        }
    }
}