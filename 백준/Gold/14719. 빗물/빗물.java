import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int[] leftMax, rightMax, world;
    static int H, W;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken()); 
        W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        world = new int[W];
        leftMax = new int[W];
        rightMax = new int[W];
        
        for (int i=0; i<W; i++){
            world[i] = Integer.parseInt(st.nextToken());
        }

        solve();

    }

    private static void solve(){
        int lMax = Integer.MIN_VALUE;
        int rMax = Integer.MIN_VALUE;

        for (int i=0; i<W; i++){
            lMax =  Math.max(world[i], lMax);
            leftMax[i] = lMax;
        }

        for (int i=W-1; i>=0; i--){
            rMax = Math.max(world[i], rMax);
            rightMax[i] = rMax;
        }
        int rainwater = Integer.MAX_VALUE;
        
        int answer = 0;
        boolean flag = false;
        for (int i=1; i<W-1; i++){
            flag = true;
            rainwater = Math.min(leftMax[i], rightMax[i]);
            if (rainwater > world[i]){
                answer += rainwater - world[i];
            }
        }

        if (flag){
            System.out.print(answer);
        }else {
            System.out.print(0);
        }
        
    }
}