public class FloydWarshallAlgorithm {

    // the matrix given in function is having distances from each and every node 
    // if a node is not reachable from another node, then mat[i][j] = -1
    // so we will change it Integer.MAX_VALUE and then after finding min distance , if a node is not reachable ,
    // we will change its value to -1;

    // The problem is to find the shortest distances between every pair of vertices in a given
    // edge-weighted directed graph. The graph is represented as an adjacency matrix. mat[i][j] denotes 
    // the weight of the edge from i to j. If mat[i][j] = -1, it means there is no edge from i to j.
    // Note: Modify the distances for every pair in place.

    public void floydWarshall(int mat[][]) {
        int n = mat.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == -1) {
                    mat[i][j] = Integer.MAX_VALUE;
                }
                if(i == j) mat[i][j] = 0;
            }
        }
        
        for(int via = 0; via < n; via++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(mat[i][via] == Integer.MAX_VALUE || mat[via][j] == Integer.MAX_VALUE) continue;
                    mat[i][j] = Math.min(mat[i][j], mat[i][via] + mat[via][j]);
                }
            }
        }


        // to find negative cycle , just check if cost of any node to reach itself is not zero , that is
        // if its less than zero, then there is -ve cycle.
        
        for(int i = 0; i < n; i++) {
            if(mat[i][i] < 0) {
                System.out.println("Negative Cycle Detected");
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == Integer.MAX_VALUE) {
                    mat[i][j] = -1;
                }
            }
        }
    }
}
