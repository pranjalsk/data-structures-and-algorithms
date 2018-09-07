package com.java8.lambda;

import java.util.function.Function;
import java.util.stream.Stream;
import java.util.*;

/**
 * Notes:
 * 
 * Any interface with a SAM(Single Abstract Method) is a functional interface,
 * and its implementation may be treated as lambda expressions.
 * 
 * The most simple and general case of a lambda is a functional interface with a
 * method that receives one value and returns another. This function of a single
 * argument is represented by the Function interface which is parameterized by
 * the types of its argument and a return value:
 * 
 * 
 * 
 * 
 * 
 * @author p0k00a0
 */
public class FunctionalInterfaceExamples {

	public static void main(String[] args) {

		// Composite Function
		Function<Integer, String> intToString = Object::toString;
		Function<String, String> quote = s -> "'" + s + "'";

		Function<Integer, String> quoteIntToString = quote.compose(intToString);
		System.out.println(quoteIntToString.apply(5));

		// BiFunction implementation
		// Map.replaceAll method, which allows replacing all values in a map with some
		// computed value.
		Map<String, Integer> salaries = new HashMap<>();
		salaries.put("John", 40000);
		salaries.put("Freddy", 30000);
		salaries.put("Samuel", 50000);

		salaries.replaceAll((name, oldValue) -> name.equals("Freddy") ? oldValue : oldValue + 10000);

		salaries.forEach((k, v) -> System.out.println(k + "-" + v));

		// The Supplier functional interface is yet another Function specialization that
		// does not take any arguments.
		int[] fibs = { 0, 1 };
		Stream<Integer> fibonacci = Stream.generate(() -> {
			int result = fibs[1];
			int fib3 = fibs[0] + fibs[1];
			fibs[0] = fibs[1];
			fibs[1] = fib3;
			return result;
		});

	}

}
