package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DFS_cycle_undirected {
    public boolean dfs(int src, int parent, ArrayList<ArrayList<Integer>> adj, boolean vis[]) {
        vis[src] = true;
       
        for(int adjNode: adj.get(src)) {
            if(vis[adjNode] == false) {
                if(dfs(adjNode, src, adj, vis) == true) return true;
            }
            else if(parent != adjNode) return true;
        }
        
        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                if(dfs(i, -1, adj, vis)) return true;
            }
        }
        return false;
    }
}
