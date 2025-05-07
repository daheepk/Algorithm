import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Integer> numArr = new ArrayList<>();

        boolean[] isNotPrimeNumber = new boolean[N+1];
    
        isNotPrimeNumber[0] = isNotPrimeNumber[1] = true;

        for (int i=2; i<=Math.sqrt(N); i++){
            for (int j=i*i; j<=N; j+=i){
                isNotPrimeNumber[j] = true;
            }
        }

        for (int i=2; i<=N; i++){
            if (!isNotPrimeNumber[i]) numArr.add(i);
        }

        int len = numArr.size();

        if (len == 0) {
            System.out.print(0);
            System.exit(0);
        }

        int left=0, right=0, total=numArr.get(0), cnt=0;
        

    
        while (left<len && right<len){
            if (total > N){
                if (left!=right){
                    total-=numArr.get(left);
                    left++;
                }else {
                    right++;
                    if (right<len){
                        total+=numArr.get(right);
                    }
                }
            }else if (total < N){
                right++;
                if (right<len){
                    total+=numArr.get(right);
                }
            }else {
                cnt++;
                right++;
                if (right<len){
                    total+=numArr.get(right);
                }
            }
        }
        System.out.print(cnt);
    }
}