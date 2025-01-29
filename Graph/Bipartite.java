import java.util.*;

public class Bipartite {

    //bfs method
    boolean isBipartite(ArrayList<Integer> adj[], int V) {
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
}
