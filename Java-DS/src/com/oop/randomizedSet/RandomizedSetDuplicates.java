package com.oop.randomizedSet;

import java.util.*;
/**
 * Design a data structure that supports all following operations in average
 * O(1) time. Note: Duplicate elements are allowed.
 * 
 * insert(val): Inserts an item val to the collection. remove(val): Removes an
 * item val from the collection if present. getRandom: Returns a random element
 * from current collection of elements. The probability of each element being
 * returned is linearly related to the number of same value the collection
 * contains.
 * 
 */
public class RandomizedSetDuplicates {

	// key and Position map
	HashMap<Integer, HashSet<Integer>> positionMap;
	List<Integer> numberList;
		
	public RandomizedSetDuplicates() {
		positionMap = new HashMap<>();
		numberList = new ArrayList<>();
	}
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean exists = positionMap.containsKey(val);
        if(!exists)
        	positionMap.put(val, new HashSet<>());
        
        numberList.add(val);
        positionMap.get(val).add(numberList.size()-1);
        
        return !exists;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        boolean exists = positionMap.containsKey(val);
        if(!exists) return false;
    	
        int loc = positionMap.get(val).iterator().next();
        positionMap.get(val).remove(loc);
        if(loc < numberList.size()-1){
        	int lastElem = numberList.get(numberList.size()-1);
        	numberList.set(loc, lastElem);
        	positionMap.get(lastElem).remove(numberList.size()-1);
        	positionMap.get(lastElem).add(loc);
        }
    	numberList.remove(numberList.size()-1);
    	
    	if(positionMap.get(val).isEmpty()) positionMap.remove(val);
    	
    	return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
    	Random random = new Random();
    	int key = random.nextInt(numberList.size()); //get random index
    	return numberList.get(key);
    }
}
