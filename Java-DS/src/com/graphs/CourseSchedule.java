package com.graphs;

import java.util.*;

public class CourseSchedule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * There are a total of n courses you have to take, labeled from 0 to n - 1.
	 * 
	 * Some courses may have prerequisites, for example to take course 0 you
	 * have to first take course 1, which is expressed as a pair: [0,1]
	 * 
	 * Given the total number of courses and a list of prerequisite pairs, is it
	 * possible for you to finish all courses?
	 * 
	 * For example:
	 * 
	 * 2, [[1,0]]
	 * 
	 * There are a total of 2 courses to take. To take course 1 you should have
	 * finished course 0. So it is possible.
	 * 
	 * 2, [[1,0],[0,1]]
	 * 
	 * There are a total of 2 courses to take. To take course 1 you should have
	 * finished course 0, and to take course 0 you should also have finished
	 * course 1. So it is impossible.
	 * 
	 * Hints:
	 * 
	 * This problem is equivalent to finding if a cycle exists in a directed
	 * graph. If a cycle exists, no topological ordering exists and therefore it
	 * will be impossible to take all courses. Topological Sort via DFS - A
	 * great video tutorial (21 minutes) on Coursera explaining the basic
	 * concepts of Topological Sort. Topological sort could also be done via
	 * BFS.
	 * 
	 * 
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {

		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for(int i= 0;i<numCourses;i++){
            map.put(i , new ArrayList<Integer>());
        }

		for (int[] pre : prerequisites) {
				ArrayList<Integer> valList = map.get(pre[0]);
				valList.add(pre[1]);
				map.put(pre[0], valList);
		}
        
		HashSet<Integer> visited = new HashSet<>();
		HashSet<Integer> recStack = new HashSet<>();
		
		for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            Integer key = entry.getKey();
            if(!visited.contains(key)){
                if(isCyclic(key, map, visited, recStack))
                    return false; //cycle exists so not possible to finish
            }
		
		}
		return true;
	}
	private boolean isCyclic(Integer key, HashMap<Integer, ArrayList<Integer>> map, HashSet<Integer> visited,
			HashSet<Integer> recStack) {

			visited.add(key);
			recStack.add(key);
			
			ArrayList<Integer> values = map.get(key);
            
			for(Integer val : values){
				if(!visited.contains(val)){
                    if(isCyclic(val, map, visited, recStack))
					    return true;
				}
				else if(recStack.contains(val)){
					return true;
				}
			}
	
		recStack.remove(key);
		return false;
	}

	// Hashmap approach --- failing for cycle
	/*public boolean canFinish(int numCourses, int[][] prerequisites) {

		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

		for (int[] pre : prerequisites) {

			if (map.containsKey(pre[0])) {
				ArrayList<Integer> valList = map.get(pre[0]);
				valList.add(pre[1]);
				map.put(pre[0], valList);
			} else {
				ArrayList<Integer> valList = new ArrayList<>();
				valList.add(pre[1]);
				map.put(pre[0], valList);
			}
		}

		for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {

			Integer key = entry.getKey();
			ArrayList<Integer> values = entry.getValue();
			System.out.println(key);
			System.out.println(values);

			for (Integer val : values) {
				if (map.get(val) == null) {
					continue;
				} else if (map.get(val).contains(key)) {
					return false;
				}
			}

		}

		return true;

	}*/
}
