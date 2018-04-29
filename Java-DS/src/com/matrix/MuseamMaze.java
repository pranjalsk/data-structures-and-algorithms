package com.matrix;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Given a maze with cells being: gates, walls or empty spaces.

INPUT maze:

_ W G _
_ _ _ W
_ W _ W
G W _ _

W = 1, _ =0, G=2
RESULT should be:

3 W G 1
2 2 1 W
1 W 2 W
G W 3 4

 
 */
public class MuseamMaze {

	public static void main(String[] args) {
		
		int[][] maze = new int [][]{
			{0,1,2,0},
			{0,0,0,1},
			{0,1,0,1},
			{2,1,0,0}
		};
		
		int [][] distance = new int[maze.length][maze[0].length];
		for(int[] dist:distance){
			Arrays.fill(dist, Integer.MAX_VALUE);
		}
		
		for (int i = 0; i < maze.length; i++) {
			for(int j =0;j<maze[0].length;j++){
				if(maze[i][j] == 2){
					distance[i][j] = 0;
					bfs(maze, i, j, distance);
				}
			}
		}

		
		//just to represent blocker by -1...better representation
		for (int i = 0; i < distance.length; i++) {
			for(int j =0;j<distance[0].length;j++){
				if(distance[i][j] == Integer.MAX_VALUE){
					distance[i][j] = -1;
				}
			}
		}
				
		for(int [] dist:distance){
			System.out.println(Arrays.toString(dist));
		}
		
	}

	private static void bfs(int[][] maze, int i, int j, int[][] distance) {
		
		boolean visited[][] = new boolean[maze.length][maze[0].length];
		Node [] directions = new Node[]{new Node(0, 1),new Node(0, -1),new Node(1, 0),new Node(-1, 0)};
		
		Node start = new Node(i, j);
		
		ArrayDeque<Node> q = new ArrayDeque<>();
		
		q.add(start);
		visited[start.Pos_X][start.Pos_Y] = true;
		distance[start.Pos_X][start.Pos_Y] = 0;

		while(!q.isEmpty()){
			
			Node curr = q.poll();
			
			for(Node dir : directions){
				int x = curr.Pos_X + dir.Pos_X;
				int y = curr.Pos_Y + dir.Pos_Y;
				int count = 0;
				while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
					
					// note steps during entire traversal
					count++;
					distance[x][y] = Math.min(distance[x][y], distance[curr.Pos_X][curr.Pos_Y] + count);

					x = x + dir.Pos_X;
					y = y + dir.Pos_Y;
					
				}

				x = x - dir.Pos_X;
				y = y - dir.Pos_Y;
				Node endr = new Node(x, y);

				if (!visited[x][y]) {
					visited[x][y] = true;
					q.offer(endr);
				}
			}
		}
	}
	
}



class Node{
	
	public int Pos_X;
	public int Pos_Y;
	public Node(int pos_X, int pos_Y) {
		Pos_X = pos_X;
		Pos_Y = pos_Y;
	}
	public boolean deepEquals(MazeNode obj){
		if(this.Pos_X == obj.Pos_X && this.Pos_Y==obj.Pos_Y)
			return true;
		return false;
	}

}

