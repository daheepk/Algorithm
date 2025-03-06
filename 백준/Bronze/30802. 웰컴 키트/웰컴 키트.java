import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] size = new int[6];
        for(int i=0; i<6; i++){
            size[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int tCnt = 0;
        int pCnt = 0;
        int pLeft = 0;
        
        for (int i=0; i<6; i++){
            if (size[i]%T==0) tCnt+=size[i]/T;
            else tCnt+=size[i]/T+1;
        }


        pCnt = N/P;
        pLeft = N%P;

        System.out.println(tCnt);
        System.out.print(pCnt + " " + pLeft);
    }
}