import java.util.*;
import java.io.*;

public class Main {
    static int[] dist;
    static boolean[] visited;
    static int[][] map;
    static int s, t, n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        dist = new int[n + 1];
        map = new int[n + 1][n + 1];

       
        for (int i = 0; i <= n; i++) {
            Arrays.fill(map[i], Integer.MAX_VALUE);
        }

        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[a][b] = Math.min(map[a][b], c); 
            map[b][a] = Math.min(map[b][a], c);
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());


        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        dijkstra(s);

        System.out.print(dist[t] == Integer.MAX_VALUE ? -1 : dist[t]); 
    }

    public static void dijkstra(int start) {
        for (int i = 1; i <= n; i++) {
            int u = getMinVertex();
            if (u == -1) break;
            visited[u] = true;

            if (u == t) return;

            for (int v = 1; v <= n; v++) {
                if (!visited[v] && map[u][v] != Integer.MAX_VALUE && dist[u] != Integer.MAX_VALUE) {
                    dist[v] = Math.min(dist[v], dist[u] + map[u][v]);
                }
            }
        }
    }

    private static int getMinVertex() {
        int min = Integer.MAX_VALUE;
        int idx = -1;

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && dist[i] < min) {
                min = dist[i];
                idx = i;
            }
        }
        return idx;
    }
}
