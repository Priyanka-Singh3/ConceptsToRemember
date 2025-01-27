import java.util.ArrayList;
import java.util.Stack;

public class KosarajuAlgorithm {

    public void dfs(int curr, ArrayList<Integer> adj[], Stack<Integer> st, boolean vis[]) {
        vis[curr] = true;

        for(int i = 0; i < adj[curr].size(); i++) {
            int node = adj[curr].get(i);
            if(!vis[node]) {
                dfs(node, adj, st, vis);
            }
        }
        st.push(curr);
    }
    
    public void dfs2(int curr, ArrayList<Integer> adj[], boolean vis[]) {
        vis[curr] = true;

        for(int i = 0; i < adj[curr].size(); i++) {
            int node = adj[curr].get(i);
            if(!vis[node]) {
                dfs2(node, adj, vis);
            }
        }
    }

    public int kosaraju(ArrayList<Integer> adj[], int n) {
        Stack<Integer> st = new Stack<>();
        boolean vis[] = new boolean[n];

        //sorting according to finishing time
        //the node that takes larger time to finish is at the top
        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                dfs(i, adj, st, vis);
            }
        }

        //reverse the graph
        ArrayList<Integer> adjT[] = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adjT[i] = new ArrayList<>();
        }
        for(int i = 0; i < n; i++) {
            vis[i] = true;
            for(int nodes = 0; nodes < adj[i].size(); nodes++) {
                int node = adj[i].get(nodes);
                adjT[node].add(i);
            }
        }

        //dfs on reversed graph
        int scc = 0;
        while(!st.isEmpty()) {
            int node = st.pop();
            if(!vis[node]) {
                scc++;
                dfs2(node, adjT, vis);
            }
        }
        return scc;

    }
}
