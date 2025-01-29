import java.util.*;
public class KahnAlgorithm {
    int[] toposort(ArrayList<ArrayList<Integer>> adj, int V) {
        int indegree[] = new int[V];
        for(int i = 0; i < V; i++) {
            for(int adjNode: adj.get(i)) {
                indegree[adjNode]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        int topo[] = new int[V];
        int i = 0;
        while(!q.isEmpty()) {
            int node = q.remove();
            topo[i++] = node;
            for(int adjNode: adj.get(node)) {
                if(--indegree[adjNode] == 0) {
                    q.add(adjNode);
                }
                
            }
        }
        return topo;
    }
}
