public class PrimsMST {

    static int V = 5;

    static int findMinVertex(int[] key,boolean[] visited) {
        int min=Integer.MAX_VALUE;
        int vertex=-1;
        for(int i=0;i<V;i++) {
            if(!visited[i] && key[i]<min) {
                vertex=i;
                min=key[i];
            }
        }
        return vertex;
    }
    static void printMST(int parent[], int key[]) {

        int total = 0;

        System.out.println("Edge \tWeight");

        for (int i = 1; i < V; i++) {

            System.out.println(parent[i] + " - " + i +
                    "\t" + key[i]);

            total += key[i];
        }

        System.out.println("Total Weight = " + total);
    }

    static void prims(int graph[][]) {
        int parent[]=new int[V];
        int key[]=new int[V];
        boolean visited[]=new boolean[V];

        for(int i=0;i<V;i++) {
            key[i]=Integer.MAX_VALUE;
            visited[i]=false;
        }

        key[0]=0;
        parent[0]=-1;

        for(int count=0;count<V-1;count++) {
            int u=findMinVertex(key,visited);

            visited[u]=true;
            for(int v=0;v<V;v++) {
                if(graph[u][v] !=0 && !visited[v] && graph[u][v]<key[v]) {
                    parent[v]=u;
                    key[v]=graph[u][v];
                }
            }
        }
        printMST(parent,key);

    }

    public static void main(String[] args) {

        int graph[][] = {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };

        prims(graph);
    }
}