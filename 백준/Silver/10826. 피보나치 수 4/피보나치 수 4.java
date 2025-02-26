import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

class Main {
    static BigInteger[] memo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if (n >= 2){
            memo = new BigInteger[n+1];
            Arrays.fill(memo, BigInteger.valueOf(-1));
            memo[0] = BigInteger.ZERO;
            memo[1] = BigInteger.ONE;
    
            BigInteger ans = fibo(n);
            System.out.print(ans);
        }else if (n<2){
            System.out.print(n);
        }
    }

    static BigInteger fibo(int n){
        for (int i=2; i<=n; i++){
            if (memo[i] == BigInteger.valueOf(-1)){
                memo[i] = memo[i-1].add(memo[i-2]);
            }
        }
        return memo[n];
    }
}