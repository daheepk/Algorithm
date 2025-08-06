import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int V, E, start;
    static int[] dist;
    static boolean[] visited;
    static List<List<Node>> graph;
    static final int INF = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(br.readLine());
        int u, v, w;

        dist = new int[V+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        
        visited = new boolean[V+1];

        graph = new ArrayList<>();

        for (int i=0; i<V+1; i++){
            graph.add(new ArrayList<>());
        }
        
        while (E-- > 0){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
            
        }

        dijkstra();

        for (int i=1; i<V+1; i++){
            
            if (dist[i] == INF){
                System.out.println("INF");
            }else {
                System.out.println(dist[i]);
            }
        }
    }

    public static void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()){
            Node now = pq.poll();
            int to = now.to;
            int cost = now.weight;

            if (cost > dist[to]) continue;

            for (Node next : graph.get(to)){
                int newCost = next.weight + dist[to];
                if (newCost < dist[next.to]){
                    dist[next.to] = newCost;
                    pq.offer(new Node(next.to, newCost));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
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