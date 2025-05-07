import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arrA = new int[N];
        int[] arrB = new int[M];

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++){
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<M; i++){
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrA);
        Arrays.sort(arrB);

        int i=0, j=0;
        while (i<N && j<M){
            if(arrA[i]<=arrB[j]){
                sb.append(arrA[i++]).append(" ");
            }else {
                sb.append(arrB[j++]).append(" ");
            }
        }

        while (i<N){
            sb.append(arrA[i++]).append(" ");
        }

        while (j<M){
            sb.append(arrB[j++]).append(" ");
        }

        System.out.print(sb.toString());
        
    }
}