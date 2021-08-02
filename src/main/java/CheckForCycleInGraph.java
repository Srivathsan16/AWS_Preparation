package main.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheckForCycleInGraph {

    int vertex;
   ArrayList<ArrayList<Integer>> adjList =  new ArrayList<ArrayList<Integer>>();
//Storing in Adjacent List

    public CheckForCycleInGraph(int vertex) {
        this.adjList = adjList;
        this.vertex = vertex;
        for(int i = 0 ;i<vertex;i++){
            adjList.add(new ArrayList<Integer>());
        }
    }





    public static void main(String[] args) {
        CheckForCycleInGraph graph = new CheckForCycleInGraph(8);
        graph.addEdgesInAdjacentList(1, 2);
        graph.addEdgesInAdjacentList(2, 4);
        graph.addEdgesInAdjacentList(2, 7);
        graph.addEdgesInAdjacentList(4, 5);
        graph.addEdgesInAdjacentList(7, 6);
        graph.addEdgesInAdjacentList(3, 5);
        graph.printGraph();
        System.out.println("Cyclic ? " + graph.isCycle(7, graph.adjList));
//        graph.dfsOnGraph(7,graph.adjList);

  //      System.out.println("BFS::::: " + graph.bfsOnGraph(7, graph.adjList));
    //    System.out.println(":::::: DFS ::::: " + graph.dfsOnGraph(7, graph.adjList));


    }

    private boolean isCycle(int v, ArrayList<ArrayList<Integer>> adjList) {
        boolean vis[] = new boolean[v+1];
        for(int i=1;i<=v;i++){
            if(vis[i]==false){
                if(checkForCycle(adjList,i,vis)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkForCycle(ArrayList<ArrayList<Integer>> adjList, int n, boolean[] vis) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(n,-1));
        vis[n]=true;

        while (!q.isEmpty()){
            int node = q.peek().first;
            int parent = q.peek().second;
            q.remove();

            for(Integer it: adjList.get(node)){
                if(vis[it]==false){
                    vis[it]=true;
                    q.add(new Node(it,node));
                }
                else if(parent!=it)return true;
            }
        }
        return false;
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