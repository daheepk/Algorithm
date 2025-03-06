import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] library = new int[N+1];
        st = new StringTokenizer(br.readLine());

        int dist = 0;
        int zeroIdx = -1;
        
        for (int i=0; i<N; i++){
            library[i] = Integer.parseInt(st.nextToken());
        }
        library[N] = 0;

        Arrays.sort(library);
        
        for (int i=0; i<=N; i++){
            if (library[i] == 0){
                zeroIdx = i;
            }
        }

        int start = 0;
        int end = library.length-1;

        int startValue = Math.abs(library[start]);
        int endValue = Math.abs(library[end]);

        if (startValue >= endValue){
            if (start + M > zeroIdx) start = zeroIdx;
            else start += M;
            dist += startValue;
        } 
        else{
            if (end - M < zeroIdx) end = zeroIdx;
            else end -= M;
            dist += endValue;
        }

        while (start != end){
            startValue = Math.abs(library[start]);
            endValue = Math.abs(library[end]);

            if (startValue >= endValue){
                if (start + M > zeroIdx) start = zeroIdx;
                else start += M;
                dist += startValue*2;
            } 
            else{
                if (end - M < zeroIdx) end = zeroIdx;
                else end -= M;
                dist += endValue*2;
            }
        }

        System.out.print(dist);
    }
}