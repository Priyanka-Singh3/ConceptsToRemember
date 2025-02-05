import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
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
    class Pair {
        int node;
        int wt;

        public Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }

    }
    public int[] dijkstra(ArrayList<Edge> graph[], int src) {
        int V = graph.length;

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> a.wt - b.wt);
        pq.add(new Pair(src, 0));

        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        while(!pq.isEmpty()) {  // max V times
            Pair curr = pq.remove(); // log(heap_size)
            int node = curr.node;
            int wt = curr.wt;

            for(Edge adjNode: graph[node]) { // ne -> total edges -> one can have atmost V-1 edges
                int u = adjNode.u;
                int v = adjNode.v;
                int w = adjNode.wt;

                if(wt > dist[v]) continue; //out-dated node

                if(w + wt < dist[v]) {
                    dist[v] = w + wt;
                    pq.add(new Pair(v, dist[v])); // log(heap_size)
                }

            }
        }
        return dist;
    }

    // time complexity = E logV
    // O(V * ({log(heap_size) + ne * log(heap_size)}))
    // O(V * ({log(heap_size) * (ne + 1)}))
    // O(V * ({log(V^2) * (V - 1 + 1)}))
    // O(V^2 * log(V^2)) now total nodes are V and for one node we can have V-1 edges hence V*(V-1) = total edges = E
    // O(E * 2logV)
    // hence, O(E logV) is the time complexity
}
