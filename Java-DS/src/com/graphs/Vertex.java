package com.graphs;

import java.util.ArrayList;

public class Vertex {

	int val;
	ArrayList<Vertex> neighbors;
	
	public Vertex(int val){
		super();
		this.val = val;
		this.neighbors = new ArrayList<>();
	}
	
	public Vertex(int val, ArrayList<Vertex> neighbors){
		super();
		this.val = val;
		this.neighbors = neighbors;
	}
	
	public void addneighbours(Vertex v){
		this.neighbors.add(v);
	}
	
	public ArrayList<Vertex> getneighbours(){
		return this.neighbors;
	}
	
}
