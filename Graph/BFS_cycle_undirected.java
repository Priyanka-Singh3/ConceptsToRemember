package Graph;

import java.util.*;

public class BFS_cycle_undirected {
    public boolean checkCycle(int src, int V, ArrayList<ArrayList<Integer>> adj, boolean vis[]) {
        vis[src] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, -1});
        while(!q.isEmpty()) {
            int node = q.peek()[0];
            int par = q.peek()[1];

            for(int adjNode: adj.get(node)) {
                if(vis[adjNode] == false) {
                    vis[adjNode] = true;
                    q.add(new int[]{adjNode, node});
                }
                else if(par != adjNode) return true;
            }
        }
        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                if(checkCycle(i, V, adj, vis)) return true;
            }
        }
        return false;
    }
}
