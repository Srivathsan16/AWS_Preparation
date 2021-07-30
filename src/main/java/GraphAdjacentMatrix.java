package main.java;


//Graph Using Map
//https://algorithms.tutorialhorizon.com/implement-graph-using-map-java/

public class GraphAdjacentMatrix {
    int vertex;
    int matrix[][];

    public GraphAdjacentMatrix(int vertex) {
        this.vertex = vertex;
        this.matrix = new int[vertex][vertex];
    }


    //Adding edges for undirected graph
    public void addEdge(int source, int destination){
        matrix[source][destination]=1;
        matrix[destination][source]=1;

    }

    public static void main(String[] args) {
        GraphAdjacentMatrix graph =  new GraphAdjacentMatrix(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.printGraph();
    }

    public void printGraph() {
        System.out.println("Graph: (Adjacency Matrix)");
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j <vertex ; j++) {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
        for (int i = 0; i < vertex; i++) {
            System.out.print("Vertex " + i + " is connected to:");
            for (int j = 0; j <vertex ; j++) {
                if(matrix[i][j]==1){
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }
}
