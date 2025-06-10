import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int answer = combination(N, K);

        System.out.print(answer);
        
    }

    static int combination(int n, int k){
        if (n < k) return 0;
        if (n == 0 || n == k) return 1;
        
        if (n-k < k) k = n-k;

        int result = 1;
        
        for (int i=0; i<k; i++){
            result = result * (n-i) / (1+i);
        }
        
        return result;
    }
}