package com.graphs;

import java.util.HashSet;
import java.util.Stack;

public class Driver {

	public static void main(String[] args) {
		 	Vertex node10 = new Vertex(10);
	        Vertex node20 = new Vertex(20);
	        Vertex node30 = new Vertex(30);
	        Vertex node40 = new Vertex(40);
	        Vertex node50 = new Vertex(50);
	        Vertex node60 = new Vertex(60);
	        Vertex node70 = new Vertex(70);

	        node40.addneighbours(node10);
	        node40.addneighbours(node20);
	        node10.addneighbours(node30);
	        node20.addneighbours(node10);
	        node20.addneighbours(node30);
	        
	        node20.addneighbours(node60);
	        //node60.addneighbours(node20); //to create cycle
	        
	        node20.addneighbours(node50);
	        node30.addneighbours(node60);
	        node60.addneighbours(node70);
	        node50.addneighbours(node70);

	        GraphOperations obj = new GraphOperations();
	        System.out.print("\nDFS recursive: ");
	        HashSet<Vertex> visitedDFS = new HashSet<>();
	        obj.DFS(node40,visitedDFS);
	        
	        System.out.print("\nDFS iterative: ");
	        HashSet<Vertex> visitedDFSiterative = new HashSet<>();
	        obj.DFSiterative(node40,visitedDFSiterative);
	        
	        System.out.print("\nBFS iterative: ");
	        HashSet<Vertex> visitedBFSiterative = new HashSet<>();
	        obj.BFSiterative(node40,visitedBFSiterative);
	        
	        //Topological Sort
	        Stack<Vertex> stackTopo = new Stack<>();
	        HashSet<Vertex> visitedTopo = new HashSet<>();
	        obj.topologicalSort(node40,visitedTopo,stackTopo);
	        System.out.print("\nTopological sort: ");
	        while(!stackTopo.isEmpty()){
	        	System.out.print(stackTopo.pop().val+" ");
	        }
	        
	      
	        // detect cycle in DAG
	        HashSet<Vertex> whiteSet = new HashSet<>();
	        whiteSet.add(node10);whiteSet.add(node20);whiteSet.add(node30);
	        whiteSet.add(node60);whiteSet.add(node50);whiteSet.add(node40);
	        whiteSet.add(node70);
	        HashSet<Vertex> graySet = new HashSet<>();
	        HashSet<Vertex> blackSet = new HashSet<>();
	        boolean hasCycle = obj.hasCycle(whiteSet, graySet, blackSet);
	        System.out.print("\nHas cycle: "+ hasCycle);
	}

}
