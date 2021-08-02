package main.java;

import java.util.ArrayList;

public class BipartiteDfsCheck {

    int vertex;
   ArrayList<ArrayList<Integer>> adjList =  new ArrayList<ArrayList<Integer>>();
//Storing in Adjacent List

    public BipartiteDfsCheck(int vertex) {
        this.adjList = adjList;
        this.vertex = vertex;
        for(int i = 0 ;i<vertex;i++){
            adjList.add(new ArrayList<Integer>());
        }
    }

    public static void main(String[] args) {
        BipartiteDfsCheck graph = new BipartiteDfsCheck(8);
        graph.addEdgesInAdjacentList(1, 2);
        graph.addEdgesInAdjacentList(2, 4);
        graph.addEdgesInAdjacentList(2, 7);
        graph.addEdgesInAdjacentList(4, 5);
        graph.addEdgesInAdjacentList(7, 6);
        graph.addEdgesInAdjacentList(3, 5);
        graph.addEdgesInAdjacentList(3, 7);
        graph.printGraph();
        System.out.println("Bipartite DFS ? " + graph.isCycle(7, graph.adjList));
//        graph.dfsOnGraph(7,graph.adjList);

  //      System.out.println("BFS::::: " + graph.bfsOnGraph(7, graph.adjList));
    //    System.out.println(":::::: DFS ::::: " + graph.dfsOnGraph(7, graph.adjList));


    }

    private boolean isCycle(int v, ArrayList<ArrayList<Integer>> adjList) {
        int vis[] = new int[v+1];
        for(int i=1;i<=v;i++){
            if(vis[i]==-1){
                if(!checkForCycle(adjList,-1,i,vis)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkForCycle(ArrayList<ArrayList<Integer>> adjList, int parent, int n, int[] vis) {
        vis[n]=1;
        for(Integer it: adjList.get(n)){
            if(vis[it]==-1){
                vis[it]=1-vis[n];
                if(!checkForCycle(adjList,n,it,vis))return false;
            }
            else if(vis[it] ==vis[n]) return false;
        }
        return true;
    }


    private  void printGraph() {
        for (int i = 0; i< this.vertex;i++){
            for(int j=0 ; j< adjList.get(i).size();j++){
                System.out.print("i points to ::::: " + i +"::::   "+ adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    private void addEdgesInAdjacentList(int source, int destination) {
        adjList.get(source).add(destination);
        adjList.get(destination).add(source);
    }

}