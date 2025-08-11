import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());

        int[] cal = new int[n+1];

        for(int i=2; i<n+1; i++){
            cal[i] = cal[i-1] + 1;

            if (i%2 == 0){
                cal[i] = Math.min(cal[i], cal[i/2] + 1);
            }

            if (i%3 == 0){
                cal[i] = Math.min(cal[i], cal[i/3] + 1);
            }
        }
        System.out.print(cal[n]);
    }
}