import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0){
            char[] charArr = br.readLine().toCharArray();

            if (charArr.length == 1){
                sb.append(charArr[0]).append(charArr[0]).append("\n");
            }else {
                int len = charArr.length;
                sb.append(charArr[0]).append(charArr[len-1]).append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}