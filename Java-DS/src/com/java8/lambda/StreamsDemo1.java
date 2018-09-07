package com.java8.lambda;

import java.util.*;
import java.util.Optional;

/**
 * Notes: https://www.geeksforgeeks.org/stream-in-java/
 * 
 * Each intermediate operation is lazily executed and returns a stream as a
 * result, hence various intermediate operations can be pipelined. Terminal
 * operations mark the end of the stream and return the result. Intermediate
 * Operations: map: The map method is used to map the items in the collection to
 * other objects according to the Predicate passed as argument. filter: The
 * filter method is used to select elements as per the Predicate passed as
 * argument. sorted: The sorted method is used to sort the stream. Terminal
 * Operations: collect: The collect method is used to return the result of the
 * intermediate operations performed on the stream. forEach: The forEach method
 * is used to iterate through every element of the stream. reduce: The reduce
 * method is used to reduce the elements of a stream to a single value.
 * 
 * 
 */
public class StreamsDemo1 {

	public static void main(String[] args) {

		// reduce operation --reduce operation applies a binary operator to each element
		// in the stream where the first argument to the operator is the return value of
		// the previous application and second argument is the current stream element.
		List<String> words = Arrays.asList("yappie", "zappie", "crappie", "nappies");

		Optional<String> longestString = words.stream().reduce((w1, w2) ->
			w1.length() > w2.length() ? w1 : w2);

		longestString.ifPresent(System.out::println);
		

        // Creating list of integers 
        List<Integer> array = Arrays.asList(-2, 0, 4, 6, 8); 
  
        // Finding sum of all elements 
        int sum = array.stream().reduce(0, 
                (element1, element2) -> element1 + element2); 
  
        // Displaying sum of all elements 
        System.out.println("The sum of all elements is " + sum); 
		
	}

}
