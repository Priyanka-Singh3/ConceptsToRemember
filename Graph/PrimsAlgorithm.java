import java.util.PriorityQueue;

public class PrimsAlgorithm {
    class Pair {
        int node;
        int wt;

        public Pair(int n, int w) {
            this.node = n;
            this.wt = w;
        }
    }
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

    public int primsMST(ArrayList<Edge> adj[], int V) {

        boolean vis[] = new boolean[V];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.add(new Pair(0, 0));

        int sum = 0; 

        // then overall ElogE + ElogE -> O(ElogE) will be the time complexity
        while(!pq.isEmpty()) { // E times 
            Pair curr = pq.poll();  //max it can take logE
            int node = curr.node;
            int wt = curr.wt;

            if(vis[node]) continue;

            vis[node] = true;
            sum += wt;

            // therefore ElogE overall for below
            for(Edge e: adj[node]) { // if all nodes are visited then E times
                int adjNode = e.v;
                int eWt = e.wt;
                if(!vis[adjNode]) {
                    pq.offer(new Pair(adjNode, eWt));  // logE
                }
            }

        }
        return sum;

    }
}
