import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Set<Integer> set = new HashSet<>();
        
        for (int i=0; i<N; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[M];
        st = new StringTokenizer(br.readLine());

        for (int i=0; i<M; i++){
            if (set.contains(Integer.parseInt(st.nextToken()))){
                sb.append("1").append(" ");
            }else {
                sb.append("0").append(" ");
            }  
        }

        System.out.print(sb.toString());
    }
}