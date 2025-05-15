import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] island;

    static int find(int v){
        if (v == island[v]) return v;
        else return island[v] = find(island[v]);
    }

    static boolean union(int a, int b){
        a = find(a);
        b = find(b);

        if (a==b) return false;
        else if (a <= b){
            island[b] = a;
            return true;
        }else {
            island[a] = b;
            return true;
        }
        
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());

        island = new int[N+1];

        for (int i=1; i<N+1; i++){
            island[i] = i;
        }

        for (int i=0; i<N-2; i++){
            st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());

            union(i1, i2);
        }
        
        int root1 = island[1], root2 = -1;

        for (int i=2; i<N+1; i++){
            int rootI = find(i);
            if (root1 == rootI) continue;
            else root2 = rootI;
        }

        System.out.println(root1 + " " + root2);
    }
}