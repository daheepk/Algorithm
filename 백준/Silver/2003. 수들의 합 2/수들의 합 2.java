import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] numArr = new int[N];
        
        st = new StringTokenizer(br.readLine());

        int num=0;
        
        for (int i=0; i<N; i++){
            num = Integer.parseInt(st.nextToken());
            numArr[i] = num;
        }

        int left = 0;
        int right = 0;
        int cnt = 0;
        int total = numArr[0];
        
        while (left <= N-1 && right <= N-1){
            if (total < M){
                right++;
                if (right < N) total += numArr[right];
            }else if (total > M){
                if (left == right){
                    right++;
                    if (right < N) total += numArr[right];
                }else {
                    if (left < N) total -= numArr[left];
                    left++;
                }
            }else {
                cnt++;
                right++;
                if (right < N) total += numArr[right];
            }
        }
        System.out.print(cnt);
    }
}