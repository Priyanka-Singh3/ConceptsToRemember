import java.util.Arrays;

public class BellmanFord {
    class Edge {
        int u;
        int v;
        int wt;

        public Edge(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }
    public void bellmanFord(ArrayList<Edge> edges, int S, int V) {
        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;
        // V-1 times relaxation
        for (int i = 0; i < V-1; i++) {
            for(Edge e: edges) {
                int u = e.u;
                int v = e.v;
                int wt = e.wt;
                if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // Nth relaxation for detecting -ve cycle
        for(Edge e: edges) {
            int u = e.u;
            int v = e.v;
            int wt = e.wt;
            if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                System.out.println("Negative Cycle Detected");
                break;
            }
        }

        //else dist will have shortest distances from source s

    }
}
