import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st; 

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int answer = combination(M, N);
            System.out.println(answer);

        }
    }

    static int combination(int n, int m){
        if (n < m) return 0;
        if (n==0 || n==m) return 1;

        if (n-m < m) m = n-m;

        int result = 1;
        
        for (int i=0; i<m; i++){
            result = result * (n-i) / (i+1);
        }
        return result;
    }
}