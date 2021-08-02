package main.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectBipartiteUsingBFS {

    int vertex;
   ArrayList<ArrayList<Integer>> adjList =  new ArrayList<ArrayList<Integer>>();
//Storing in Adjacent List

    public DetectBipartiteUsingBFS(int vertex) {
        this.adjList = adjList;
        this.vertex = vertex;
        for(int i = 0 ;i<vertex;i++){
            adjList.add(new ArrayList<Integer>());
        }
    }





    public static void main(String[] args) {
        DetectBipartiteUsingBFS graph = new DetectBipartiteUsingBFS(8);
        graph.addEdgesInAdjacentList(1, 2);
        graph.addEdgesInAdjacentList(2, 4);
        graph.addEdgesInAdjacentList(2, 7);
        graph.addEdgesInAdjacentList(4, 5);
        graph.addEdgesInAdjacentList(7, 6);
        graph.addEdgesInAdjacentList(3, 5);
        graph.printGraph();
        System.out.println("Bipartites ? " + graph.isCycle(8, graph.adjList));
//        graph.dfsOnGraph(7,graph.adjList);

  //      System.out.println("BFS::::: " + graph.bfsOnGraph(7, graph.adjList));
    //    System.out.println(":::::: DFS ::::: " + graph.dfsOnGraph(7, graph.adjList));


    }

    private boolean isCycle(int v, ArrayList<ArrayList<Integer>> adjList) {
        int color[] = new int[v];
        for(int i=1;i<v;i++){
            color[i]= -1;
        }
        for(int i=0;i<v;i++){
            if(color[i]==-1){
                if(!checkForBipartites(adjList,i,color))return false;
            }
        }
        return true;
    }

    private boolean checkForBipartites(ArrayList<ArrayList<Integer>> adjList, int node, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node] = 1;
        while (!q.isEmpty()) {
            int currentNode = q.poll();
            for (Integer it : adjList.get(currentNode)) {
                if (color[it] == -1) {
                    color[it] = 1 - color[currentNode];
                    q.add(it);
                } else if (color[it] == color[currentNode]) return false;
            }
        }
        return true;
    }


    private  void printGraph(){
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