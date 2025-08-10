import java.io.*;
import java.util.*;

class Main {

    static class Edge {
        int from, to, w;
        Edge(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }
    }

    static final long INF = Long.MAX_VALUE;
    static int N, M;
    static List<Edge> edges;
    static long[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>(M);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            edges.add(new Edge(A, B, C));
        }

        dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        if (bellmanFord()) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(dist[i] == INF ? -1 : dist[i]).append('\n');
        }
        System.out.print(sb);
    }

    public static boolean bellmanFord() {
        for (int i = 1; i <= N - 1; i++) {
            boolean updated = false;
            for (Edge e : edges) {
                if (dist[e.from] == INF) continue;
                long nd = dist[e.from] + e.w;
                if (nd < dist[e.to]) {
                    dist[e.to] = nd;
                    updated = true;
                }
            }
            if (!updated) break;
        }

        for (Edge e : edges) {
            if (dist[e.from] == INF) continue;
            if (dist[e.from] + e.w < dist[e.to]) {
                return true; 
            }
        }
        return false;
    }
}
