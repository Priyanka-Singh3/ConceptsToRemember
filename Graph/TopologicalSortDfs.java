package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortDfs {
    public boolean dfs(int src, int V, ArrayList<ArrayList<Integer>> adj, boolean vis[], Stack<Integer> st) {
        vis[src] = true;
        
        //traverse for adjacent nodes
        for(int adjNode: adj.get(src)) {

            //if the node is not visited
            if(!vis[adjNode]) {
                dfs(adjNode, V, adj, vis)
            }
        }

        st.push(src);
    }

    public int[] topSort(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                dfs(i, V, adj, vis, st);
            }
        }

        int i = 0;
        int ans[] = new int[V];
        while(!st.isEmpty()) {
            ans[i++] = st.pop();
        }
        return ans;

    }
}
