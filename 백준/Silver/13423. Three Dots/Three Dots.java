import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (T-- > 0){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];

            for (int i=0; i<N; i++){
                arr[i]= Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            
            Map<Integer, Boolean> board = new HashMap<>();
            
            for (int i=0; i<N; i++){
                board.put(arr[i], true);
            }

            int distance = 0, cnt = 0;
            
            for (int i=0; i<N-2; i++){
                for (int j=i+1; j<N-1; j++){
                    distance = arr[j] - arr[i];
                    boolean flag = board.getOrDefault(arr[j]+distance, false);
                    if (flag){
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}