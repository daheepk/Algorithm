import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, M, K, X;
    static List<List<Node>> graph;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[X] = 0;

        graph = new ArrayList<>();
        
        for (int i=0; i<N+1; i++){
            graph.add(new ArrayList<>());
        }

        int A, B;
        while (M-- > 0){
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            graph.get(A).add(new Node(B, 1));
        }

        dijkstra();

        boolean flag = false;
        for (int i=1; i<N+1; i++){
            if (dist[i] == K){
                flag = true;
                System.out.println(i);
            }
        }

        if (!flag) System.out.print(-1);
    }

    static void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(X, 0));

        while (!pq.isEmpty()){
            Node now = pq.poll();
            int idx = now.to;
            int cost = now.weight;

            if (cost > dist[idx]) continue;

            for (Node next : graph.get(idx)){
                int newCost = dist[idx] + next.weight;
                if (newCost < dist[next.to]){
                    dist[next.to] = newCost;
                    pq.offer(new Node(next.to, newCost));
                }
            }
        }
        
    }

    public static class Node implements Comparable<Node>{
        int to, weight;

        Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other){
            return this.weight - other.weight;
        }
    }
}