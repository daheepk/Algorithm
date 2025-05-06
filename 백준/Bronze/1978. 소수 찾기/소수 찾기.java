import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> numArr = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++){
            numArr.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(numArr);

        int lastNum = numArr.get(N-1);
        for (int i=2; i<=Math.sqrt(lastNum); i++){
            for (int j=i*i; j<=lastNum; j+=i){
                numArr.remove(Integer.valueOf(j));
            }
        }
        numArr.remove(Integer.valueOf(1));
        System.out.print(numArr.size());
    }
}