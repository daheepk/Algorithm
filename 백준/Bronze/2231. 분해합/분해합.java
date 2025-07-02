import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        int len = N.length();

        int targetNum = Integer.parseInt(N);
        int startNum = ((targetNum - (len)*9) < 0) ? 0 : targetNum - (len)*9;

        int answer = Integer.MAX_VALUE;
       
        for (int i=startNum; i<targetNum; i++){
            int compareNum = 0;
            compareNum += i;
            char[] n = Integer.toString(i).toCharArray();
            for (int j=0; j<n.length; j++){
                compareNum += (Character.digit(n[j], 10));
            }

            if (compareNum == targetNum) {
                answer = Math.min(answer, i);
            }
        }

        if (answer != Integer.MAX_VALUE){
            System.out.print(answer);
        }else {
            System.out.print(0);
        }
    }
}