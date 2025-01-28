package Graph;
import java.utils.DisjointSet;
import java.util.*;

public class KruskalAlgorithm {

    class Edge {
        int wt;
        int u;
        int v;

        public Edge(int wt, int u, int v) {
            this.wt = wt;
            this.u = u;
            this.v = v;
        }
    }

    public int minimumSpanningTree(ArrayList<Edge> edges, int n) {
        DisjointSet ds = new DisjointSet(n);
        for(Edge e: edges) {
            int wt = e.wt;
            int u = e.u;
            int v = e.v;
        }

        Collections.sort(edges, (a, b) -> {
            return Integer.compare(a.wt, b.wt);
        });

        int mst = 0;
        for(Edge e: edges) {
            int wt = e.wt;
            int u = e.u;
            int v = e.v;

            if(ds.findUPar(u) != ds.findUPar(v)) {
                mst += wt;
                ds.unionBySize(u, v);
            }
        }
        return mst;
    }
}
