import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.next());

        

        while (T-- > 0){
            int k = Integer.parseInt(sc.next());
            int n = Integer.parseInt(sc.next());

            int[][] apartment = new int[k+1][n+1];

            for (int i=1; i<n+1; i++){
                apartment[0][i] = i;
            }

            for (int i=1; i<k+1; i++){
                for (int j=1; j<n+1; j++){
                    int sum = 0;
                    for (int m=1; m<=j; m++){
                        sum += apartment[i-1][m];
                    }
                    apartment[i][j] = sum;
                }
            }
            System.out.println(apartment[k][n]);
        
        }
    }
}