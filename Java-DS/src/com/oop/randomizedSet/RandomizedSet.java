package com.oop.randomizedSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Design a data structure that supports all following operations in average
 * O(1) time.
 * 
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present. getRandom: Returns
 * a random element from current set of elements. Each element must have the
 * same probability of being returned.
 * 
 * Followup: Duplicates allowed
 */
public class RandomizedSet {

	// key and Position map
	HashMap<Integer, Integer> positionMap;
	List<Integer> numberList;
	
	
	/** Initialize your data structure here. */
    public RandomizedSet() {
        positionMap = new HashMap<>();
        numberList = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        
    	boolean exists = positionMap.containsKey(val);
    	if(exists)
    		return false;
    	
    	numberList.add(val);
    	positionMap.put(val, numberList.size()-1);
    	return true;    	
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    	boolean exists = positionMap.containsKey(val);
    	if(!exists)
    		return false;
    	
    	/*say list is [1,2,5,6,8] and map is as
    	 key	pos
    	-------------
		 1   	0
		 2  	1
		 5   	2
		 6   	3
    	 8   	4
    	val = 5 to be removed*/
    	int locOfval = positionMap.get(val); //2
    	if(locOfval < numberList.size()-1){
        	int lastElem = numberList.get(numberList.size()-1); //8
        	positionMap.put(lastElem, locOfval);
        	numberList.set(locOfval, lastElem);        	
    	}
    	positionMap.remove(val);
    	numberList.remove(numberList.size());
    	return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
    	Random random = new Random();
    	int key = random.nextInt(numberList.size()); //get random index
    	return numberList.get(key);
    }
}
