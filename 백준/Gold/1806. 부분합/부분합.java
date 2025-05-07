import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] numArr = new int[N];

        for (int i=0; i<N; i++){
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        int left=0, right=0, total=numArr[0], cnt=1, minCnt=Integer.MAX_VALUE;
        boolean flag = false;
        while (left<N && right<N){
            if (total < S){
                right++;
                if (right<N){
                    total+=numArr[right];
                    cnt++;
                }
            }else if (total > S){
                flag = true;
                minCnt = Math.min(minCnt, cnt);
                if (left != right){
                    total-=numArr[left];
                    left++;
                    cnt--;
                }else {
                    right++;
                    if (right<N){
                        total+=numArr[right];
                        cnt++;
                    }
                }
            }else {
                flag = true;
                minCnt = Math.min(minCnt, cnt);
                right++;
                if (right<N){
                    total+=numArr[right];
                    cnt++;
                }
            }
        }
        if (flag){
            System.out.print(minCnt);
        }else {
            System.out.print("0");
        }
        
    }
}