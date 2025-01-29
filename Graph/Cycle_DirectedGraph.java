import java.util.*;
public class Cycle_DirectedGraph {
    //dfs
    public boolean checkCycle(int src, int V, ArrayList<ArrayList<Integer>> adj, boolean vis[], boolean pathVis[]) {
        vis[src] = true;
        pathVis[src] = true;

        //traverse for adjacent nodes
        for(int adjNode: adj.get(src)) {

            //if the node is not visited
            if(!vis[adjNode]) {
                if(checkCycle(adjNode, V, adj, vis, pathVis)) return true;
            }
            
            //if node is already visited then it has to be visited on the same path
            else if(pathVis[adjNode]) return true;
        }

        pathVis[src] = false;
        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        boolean pathVis[] = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                if(checkCycle(i, V, adj, vis, pathVis)) return true;
            }
        }
        return false;
    }
}
