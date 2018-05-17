package com.arrays;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTest {

	ArrayOperations obj = new ArrayOperations();;
	
//	@Test
//	public void test() {
//		obj = new ArrayOperations();
//	}
	
	// valid case
	// invalid case
	// overflow
	// null
	//exception cases -- invalid input
	// integer overflow etc

	@Test
	public void productExceptSelfTest(){
		
		int [] input = {1,2,3,4};
		
		int [] output = obj.productExceptSelf(input);
		int [] expected = {24,12,8,6};
		
		assertEquals(4, output.length);
		
		Assert.assertArrayEquals(expected, output);
		
	}
	
	@Test
	public void topKFrequentTest(){
		
		int [] input = {1,1,1,2,2,3};
		int k = 2;
		List<Integer> actual = Arrays.asList(1,2);
		List<Integer> expected = obj.topKFrequent(input, k);
		
		assertThat(expected, CoreMatchers.hasItems(1,2));
		
	}
	
	
}
