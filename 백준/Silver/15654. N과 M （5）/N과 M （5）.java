import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] intArr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        intArr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            intArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(intArr);

        permutation(new int[M], new boolean[N], 0);

        bw.write(sb.toString());
        bw.close();
        br.close();
        
    }

    static void permutation(int[] result, boolean[] visited, int idx){
        if (idx == M){
            for (int shape:result){
                sb.append(shape).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=0; i<N; i++){
            if (visited[i] == false){
                visited[i] = true;
                result[idx] = intArr[i]; 
                permutation(result, visited, idx+1);
                visited[i] = false;
            }
        }
    }
}