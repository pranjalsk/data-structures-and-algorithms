package com.oop.hashmap;

import java.util.*;

public class FlattenListIterator  implements Iterator<Integer> {

	List<Integer> _nestedList;
    int currentCount = 0;
		
    public FlattenListIterator(List<NestedInteger> nestedList) {
        _nestedList = new ArrayList<>();
        flattenNestedHelper(nestedList);
    }

   // You can simplify this to a single line , keeping this into 3 lines is for readability purposes
    @Override
    public Integer next() {
        int number = _nestedList.get(currentCount);
        currentCount++;
        return number;
    }
    
    public void flattenNestedHelper(List<NestedInteger> nestedList) {
        for(NestedInteger number: nestedList) {
            if(number.isInteger()) {
                _nestedList.add(number.getInteger());
            } else {
               flattenNestedHelper(number.getList()); 
            }
        }
    }

  // Can simplify this to a single line too but just for readability
    @Override
    public boolean hasNext() {
        if(currentCount == _nestedList.size()) {
            return false;
        }
        return true;
    }
}


 interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
     // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

     // @return the nested list that this NestedInteger holds, if it holds a nested list
     // Return null if this NestedInteger holds a single integer
     public List<NestedInteger> getList();
 }