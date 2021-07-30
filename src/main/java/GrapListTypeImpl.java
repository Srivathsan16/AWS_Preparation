package main.java;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GrapListTypeImpl {

    int vertex;
   ArrayList<ArrayList<Integer>> adjList =  new ArrayList<ArrayList<Integer>>();
//Storing in Adjacent List

    public GrapListTypeImpl( int vertex) {
        this.adjList = adjList;
        this.vertex = vertex;
        for(int i = 0 ;i<vertex;i++){
            adjList.add(new ArrayList<Integer>());
        }
    }





    public static void main(String[] args) {
        GrapListTypeImpl graph = new GrapListTypeImpl(5);
        graph.addEdgesInAdjacentList(0, 1);
        graph.addEdgesInAdjacentList(0, 4);
        graph.addEdgesInAdjacentList(1, 2);
        graph.addEdgesInAdjacentList(1, 3);
        graph.addEdgesInAdjacentList(1, 4);
        graph.addEdgesInAdjacentList(2, 3);
        graph.addEdgesInAdjacentList(3, 4);
        graph.printGraph();
        graph.bfsOnGraph(5, graph.adjList);
    }

    private ArrayList<Integer> bfsOnGraph(int i, ArrayList<ArrayList<Integer>> adjList) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean vis[] =  new boolean[i];
        for
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