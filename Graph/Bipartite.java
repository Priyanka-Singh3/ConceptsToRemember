import java.util.*;

public class Bipartite {

    //bfs method
    boolean isBipartiteBfs(ArrayList<Integer> adj[], int V) {
        int col[] = new int[V];
        Arrays.fill(col, -1);
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++) {
            if(col[i] == -1) {
                col[i] = 0;
                q.add(i);
                while(!q.isEmpty()) {
                    int curr = q.remove();
                    for(int adjNode: adj[curr]) {
                        if(col[adjNode] == -1) {
                            col[adjNode] = 1 - col[curr];
                            q.add(adjNode);
                        }
                        else if(col[adjNode] == col[curr]) return false;
                    }
                }
            }
        }
        return true;
    }

    boolean isBipartiteDfs(ArrayList<Integer> adj[], int V) {
        int col[] = new int[V];
        Arrays.fill(col, -1);
        for(int i = 0; i < V; i++) {
            if(col[i] == -1) {
                if(dfs(i, 0, col, adj) == false) return false;
            }
        }
        return true;
    }
    boolean dfs(int node, int color, int[]col, ArrayList<Integer> adj[]) {
        col[node] = color;
        for(int adjNode: adj[i]) {
            if(col[adjNode] == -1) {
                if(dfs(adjNode, 1-color, col, adj) == false) return false;
            }
            else if(col[adjNode] == col[node]) return false;
        }
        return true;
    }
}
