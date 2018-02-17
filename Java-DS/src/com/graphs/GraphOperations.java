package com.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphOperations {

	//Graph traversals
	
	//DFS
	public void DFS(Vertex node,HashSet<Vertex> visited){
			
			visited.add(node);
            System.out.print(node.val +" ");
            
            ArrayList<Vertex> neighbours = node.getneighbours();
            
            for(Vertex neighbour : neighbours){
            	if(neighbour!=null && !visited.contains(neighbour)){
                    DFS(neighbour,visited);
                }	
            }
        
    }
	
	
	//DFSIterative
	public void DFSiterative(Vertex node,HashSet<Vertex> visited){
		
		Stack<Vertex> stack = new Stack<>();
		stack.push(node);
		visited.add(node);
		
		while(!stack.isEmpty()){
			Vertex v = stack.pop();
			ArrayList<Vertex> neighbours = v.getneighbours();
			
			System.out.print(v.val + " ");
			
			for(Vertex neighbour : neighbours){
				
				if(neighbour!=null && !visited.contains(neighbour)){
					stack.push(neighbour);
					visited.add(neighbour);
				}
			}
		}
	}
	
	
	//BFS
	public void BFSiterative(Vertex node,HashSet<Vertex> visited){
		Queue<Vertex> q = new LinkedList<>();	
		q.add(node);
		visited.add(node);

		while(!q.isEmpty()){
			
			Vertex v = q.poll();
			ArrayList<Vertex> neighbours = v.getneighbours();
			
			System.out.print(v.val + " ");
			
			for(Vertex neighbour : neighbours){
				if(neighbour!=null && !visited.contains(neighbour)){
					q.add(neighbour);
					visited.add(neighbour);
				}	
			}	
		}	
	}

	//topological sort .. https://www.youtube.com/watch?v=ddTC4Zovtbc&list=PLrmLmBdmIlpu2f2g8ltqaaCZiq6GJvl1j
	public void topologicalSort(Vertex node, HashSet<Vertex> visited, Stack<Vertex> stack) {
		visited.add(node);
		ArrayList<Vertex> neighbours = node.getneighbours();
		
		for(Vertex neighbour : neighbours){
			
			if(visited.contains(neighbour)){
				continue;
			}
			topologicalSort(neighbour, visited, stack);
		}
		
		stack.push(node);
	}
	
	//Detect cycle in DAG using DFS
	//https://www.youtube.com/watch?v=rKQaZuoUR4M&list=PLrmLmBdmIlpu2f2g8ltqaaCZiq6GJvl1j&index=11
	
	public boolean hasCycle(HashSet<Vertex> whiteSet,HashSet<Vertex> graySet,HashSet<Vertex> blackSet) {
        
        while (whiteSet.size() > 0) {
            Vertex current = whiteSet.iterator().next();
            if(hasCycleDFS(current, whiteSet, graySet, blackSet)) {
                return true;
            }
        }
        return false;
	}
	
	public boolean hasCycleDFS(Vertex current, HashSet<Vertex> whiteSet,HashSet<Vertex> graySet,HashSet<Vertex> blackSet){
		
		moveVertex(current, whiteSet, graySet);
		
		ArrayList<Vertex> neighbours = current.getneighbours();
		for(Vertex neighbour : neighbours){
			
			//if in black set means already explored so continue.
            if (blackSet.contains(neighbour)) {
                continue;
            }
            //if in gray set then cycle found.
            if (graySet.contains(neighbour)) {
                return true;
            }
            if(hasCycleDFS(neighbour, whiteSet, graySet, blackSet)) {
                return true;
            }	
		}
		//move vertex from gray set to black set when done exploring.
        moveVertex(current, graySet, blackSet);
        return false;
	}
	
	private void moveVertex(Vertex vertex, HashSet<Vertex> sourceSet, HashSet<Vertex> destinationSet) {
			sourceSet.remove(vertex);
			destinationSet.add(vertex);
	}
	
	//----------------------------------------------
	
	
	
	
	
}
