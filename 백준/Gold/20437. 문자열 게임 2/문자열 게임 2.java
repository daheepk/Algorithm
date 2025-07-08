import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0){
            String S = br.readLine();

            int K = Integer.parseInt(br.readLine());
            

            solve(S, K);
        }

    }

    private static void solve(String s, int k){
        StringBuilder sb = new StringBuilder();

        if (k==1){
            sb.append("1 1");
            System.out.println(sb.toString());
            return;
        }
        
        int[] alpha = new int[26];

        boolean flag = false;

        for (int i=0; i<s.length(); i++){
            alpha[s.charAt(i) - 'a'] += 1;
        }
        
        int min = Integer.MAX_VALUE;
        int max = -1;
        
        for (int i=0; i<s.length()-1; i++){
            int cnt = 1;
            if (alpha[s.charAt(i)-'a'] < k){
                continue;
            }

            flag = true;
            for (int j=i+1; j<s.length(); j++){
                if (s.charAt(i) == s.charAt(j)){
                    cnt++;
                }

                if (cnt == k){
                    min = Math.min(min, j-i+1);
                    max = Math.max(max, j-i+1);
                    break;
                }
            }
        }

        if (flag){
            sb.append(min).append(" ").append(max);
            System.out.println(sb.toString());
        }else {
            System.out.println(-1);
        }
    }
}