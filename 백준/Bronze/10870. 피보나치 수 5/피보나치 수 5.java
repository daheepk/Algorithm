import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] fibo = new long[n+1];
        
        if (n >= 2){
            fibo[0] = 0;
            fibo[1] = 1;
            for (int i=2; i<=n; i++){
                fibo[i] = fibo[i-1] + fibo[i-2];
            }
            System.out.println(fibo[n]);
        }else if (n<2){
            System.out.print(n);
        }
    }
}