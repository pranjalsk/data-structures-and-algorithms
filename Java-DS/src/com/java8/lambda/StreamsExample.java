package com.java8.lambda;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.math.BigInteger;
import java.util.*;

/**
 * https://www.baeldung.com/java-8-functional-interfaces
 * 
 * https://www.baeldung.com/java-8-lambda-expressions-tips
 * 
 * Don’t Treat Lambda Expressions as Inner Classes Despite our previous example,
 * where we essentially substituted inner class by a lambda expression, the two
 * concepts are different in an important way: scope.
 * 
 * When you use an inner class, it creates a new scope. You can overwrite local
 * variables from the enclosing scope by instantiating new local variables with
 * the same names. You can also use the keyword this inside your inner class as
 * a reference to its instance.
 * 
 * However, lambda expressions work with enclosing scope. You can’t overwrite
 * variables from the enclosing scope inside the lambda’s body. In this case,
 * the keyword this is a reference to an enclosing instance.
 * 
 * @author p0k00a0
 *
 */
public class StreamsExample {

	// demonstrate the use of Streams filter(), collect(), findAny() and orElse()

	public static void main(String[] args) {

		// Creating Stream of strings
		Stream<String> streamOfStrings = Stream.of("yappie", "zappie", "krappie", "nappie");

		streamOfStrings.forEach(System.out::println);

		// Filter Operation
		List<String> lines = Arrays.asList("spring", "node", "mkyong");

		List<String> result = lines.stream() // convert list to stream
				.filter(line -> !"mkyong".equals(line)) // we dont like mkyong
				.collect(Collectors.toList()); // collect the output and convert streams to a List

		result.forEach(System.out::println); // output : spring, node

		// findAny() and orElse()
		List<Developer> listdevs = new ArrayList<Developer>() {
			{
				add(new Developer("Yappie", 24, new BigInteger("150000")));
				add(new Developer("Sappie", 23, new BigInteger("160000")));
				add(new Developer("Zappie", 24, new BigInteger("130000")));
				add(new Developer("Gappie", 25, new BigInteger("140000")));
			}
		};

		Developer yappieDev = listdevs.stream().filter(d -> {
			if ("Yappie".equalsIgnoreCase(d.getName()) && d.getAge() == 24)
				return true;
			return false;
		}).findAny().orElse(null);

		System.out.println(yappieDev.toString());

		// map()

	}

}
