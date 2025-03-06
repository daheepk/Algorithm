import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a==0 && b==0 && c==0) break;

            if (a >= b && a >= c){
                String answer = (Math.pow(a,2) == Math.pow(b,2)+Math.pow(c,2)) ? "right" : "wrong";
                sb.append(answer).append("\n");
            }else if (b >= a && b >= c){
                String answer = (Math.pow(b,2) == Math.pow(a,2)+Math.pow(c,2)) ? "right" : "wrong";
                sb.append(answer).append("\n");
            }else if (c >= a && c >= b){
                String answer = (Math.pow(c,2) == Math.pow(b,2)+Math.pow(a,2)) ? "right" : "wrong";
                sb.append(answer).append("\n");
            }
            
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}