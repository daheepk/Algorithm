import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = N;

        if (N == 0){
            ans = 1;
        }else {
            for (int i=N-1; i>0; i--){
                ans *= i;
            }
        }
        System.out.print(ans);
    }
}