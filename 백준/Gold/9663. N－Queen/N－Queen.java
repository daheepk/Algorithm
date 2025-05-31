import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] queen;
    static int N, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        queen = new int[N+1];

        setQueen(1);

        System.out.println(ans);
    }

    static void setQueen(int rowN){

        if (!isAvailable(rowN-1)) return;

        if (rowN > N){
            ans++;
            return;
        }

        for (int i=1; i<=N; i++){
            queen[rowN] = i;
            setQueen(rowN+1);
        }
    }

    static boolean isAvailable(int rowN){
        
        for (int k=1; k<rowN; k++){
            if (queen[rowN] == queen[k] || rowN-k == Math.abs(queen[rowN]-queen[k])) return false;
        }
        
        return true;
    }
}