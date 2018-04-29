package com.matrix;

import java.util.*;
public class Maze {

	public static void main(String[] args) {
		
		Maze obj = new Maze();
		
		int [][] maze = new int [][]
				{{0, 0, 1, 0, 0},
				 {0, 0, 0, 0, 0},
				 {0, 0, 0, 1, 0},
				 {1, 1, 0, 1, 1},
				 {0, 0, 0, 0, 0}};

		
		MazeNode start = new MazeNode(0, 4);		 
		MazeNode dest = new MazeNode(4, 4);		 
				 
		boolean exists = obj.hasPath(maze, start, dest);
		int shortest = obj.shortestDist(maze, start, dest);
		System.out.println(exists);
		System.out.println(shortest);

	}

	/**
	 * There is a ball in a maze with empty spaces and walls. The ball can go
	 * through empty spaces by rolling up, down, left or right, but it won't
	 * stop rolling until hitting a wall. When the ball stops, it could choose
	 * the next direction.
	 * 
	 * Given the ball's start position, the destination and the maze, determine
	 * whether the ball could stop at the destination.
	 * 
	 * The maze is represented by a binary 2D array. 1 means the wall and 0
	 * means the empty space. You may assume that the borders of the maze are
	 * all walls. The start and destination coordinates are represented by row
	 * and column indexes.
	 * 
	 */

	/**
	 * Example 1
	 * 
	 * Input 1: a maze represented by a 2D array
	 * 
		0 0 0 0 0
		0 0 0 1 0
		1 1 0 1 1
		0 0 0 0 0* 
	 * Input 2: start coordinate (rowStart, colStart) = (0, 4) Input 3:
	 * destination coordinate (rowDest, colDest) = (4, 4)
	 * 
	 * Output: true Explanation: One possible way is : left -> down -> left ->
	 * down -> right -> down -> right.
	 * 
	
	 * Note:
	 * 
	 * There is only one ball and one destination in the maze. Both the ball and
	 * the destination exist on an empty space, and they will not be at the same
	 * position initially. The given maze does not contain border (like the red
	 * rectangle in the example pictures), but you could assume the border of
	 * the maze are all walls. The maze contains at least 2 empty spaces, and
	 * both the width and height of the maze won't exceed 100.
	 * 
	 */

	
	
	
	//BFS approach
	public boolean hasPath(int[][] maze, MazeNode start, MazeNode destination){
		
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        MazeNode[] dirs={new MazeNode(0,1),new MazeNode(0,-1),new MazeNode(1,0),new MazeNode(-1,0)};
		
		ArrayDeque<MazeNode> q= new ArrayDeque<>();
		
		q.offer(start);
        visited[start.Pos_X][start.Pos_Y] = true;
		
		while(!q.isEmpty()){
			
			MazeNode curr = q.poll();
			
			if(curr.deepEquals(destination)){
				return true;
			}
				
			for(MazeNode dir:dirs){
				
				int x = curr.Pos_X + dir.Pos_X;
				int y = curr.Pos_Y + dir.Pos_Y;
				 	
				while (x < maze.length && x >= 0 && y < maze[0].length && y >= 0 && maze[x][y] == 0) {
					x = x + dir.Pos_X;
					y = y + dir.Pos_Y;
				}
				
				//now we reached one step ahead...due to incremental..come back one step to point to end point
				x = x - dir.Pos_X;
				y = y - dir.Pos_Y;
				MazeNode endr = new MazeNode(x, y);
				
				if(visited[x][y] == false){
					visited[x][y] = true;
					q.offer(endr);
				}
			}
		}
		return false;
	}
	
	
	
	
	//MAZE 2
	// FIND SHORTEST DISTANCE TO DEST
	public int shortestDist(int[][] maze, MazeNode start, MazeNode destination){
	
		boolean[][] visited = new boolean[maze.length][maze[0].length];
		
		//distance array
		int[][] distance = new int[maze.length][maze[0].length];
		for(int [] dist:distance){
			Arrays.fill(dist, Integer.MAX_VALUE);
		}
		
		
        MazeNode[] dirs={new MazeNode(0,1),new MazeNode(0,-1),new MazeNode(1,0),new MazeNode(-1,0)};
		
		ArrayDeque<MazeNode> q= new ArrayDeque<>();
		
		q.offer(start);
        visited[start.Pos_X][start.Pos_Y] = true;
        distance[start.Pos_X][start.Pos_Y] = 0;
		
		while(!q.isEmpty()){
			
			MazeNode curr = q.poll();
			
				
			for(MazeNode dir:dirs){
				
				int x = curr.Pos_X + dir.Pos_X;
				int y = curr.Pos_Y + dir.Pos_Y;
				int count = 0;
				while (x < maze.length && x >= 0 && y < maze[0].length && y >= 0 && maze[x][y] == 0) {
					
					count++;
					distance[x][y] = Math.min(distance[x][y], distance[curr.Pos_X][curr.Pos_Y]+count);

					x = x + dir.Pos_X;
					y = y + dir.Pos_Y;
				}
				
				//now we reached one step ahead...due to incremental..come back one step to point to end point
				x = x - dir.Pos_X;
				y = y - dir.Pos_Y;
				MazeNode endr = new MazeNode(x, y);
								
				if(visited[x][y] == false){
					visited[x][y] = true;
					q.offer(endr);
				}
			}
		}
        return distance[destination.Pos_X][destination.Pos_Y] == Integer.MAX_VALUE ? -1 : distance[destination.Pos_X][destination.Pos_Y];
	}
}
















































class MazeNode{
	
	public int Pos_X;
	public int Pos_Y;
	public MazeNode(int pos_X, int pos_Y) {
		super();
		Pos_X = pos_X;
		Pos_Y = pos_Y;
	}
	public boolean deepEquals(MazeNode obj){
		if(this.Pos_X == obj.Pos_X && this.Pos_Y==obj.Pos_Y)
			return true;
		return false;
	}

}

