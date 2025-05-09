import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (T-- > 0){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            arr = new int[N];
            Map<Integer, Boolean> board = new HashMap<>();

            for (int i=0; i<N; i++){
                arr[i]= Integer.parseInt(st.nextToken());
                board.put(arr[i], true);
            }

            Arrays.sort(arr);

            int distance = 0, cnt = 0;
            for (int i=0; i<N-2; i++){
                for (int j=i+2; j<N; j++){
                    
                    if ((arr[j] + arr[i])%2 == 0){
                        int target = (arr[j] + arr[i])/2;
                        if (Arrays.binarySearch(arr, i, j, target) >= 0){
                            cnt++;
                        }
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}