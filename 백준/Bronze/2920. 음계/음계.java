import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());

        if (start == 1){
            for(int i=start+1; i<=8; i++){
                if (i != Integer.parseInt(st.nextToken())){
                    System.out.print("mixed");
                    System.exit(0);
                }
            }
            System.out.print("ascending");
            System.exit(0);
        }else if (start == 8){
            for(int i=start-1; i>0; i--){
                if (i != Integer.parseInt(st.nextToken())){
                    System.out.print("mixed");
                    System.exit(0);
                }
            }
            System.out.print("descending");
            System.exit(0);
            
        }else {
            System.out.print("mixed");
            System.exit(0);
        }
    }
}