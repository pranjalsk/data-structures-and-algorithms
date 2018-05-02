package com.oop.hashmap;

import java.util.*;

/**
 * implement a list<character> iterator that only iterates through the uppercase
 * characters and ignores the lowercase ones.
 */
class MyIteratorDriver {

	public static void main(String[] args) {

		List<Character> givenList = new ArrayList<Character>() {
			{
				add('D');
				add('v');
				add('R');
				add('f');
				add(';');
				add('O');
				add('0');
				add('Q');
				add(' ');
			}
		};

		MyIteartor it = new MyIteartor(givenList);

		while (it.hasNext()) {
			Character character = (Character) it.next();
			System.out.println(character);
		}
	}
}

public class MyIteartor implements Iterator<Character> {

	private List<Character> charList;
	int counter = 0;

	public MyIteartor(List<Character> givenList) {
		this.charList = new ArrayList<>();
		ignoreCaseHelper(givenList);
	}

	@Override
	public boolean hasNext() {
		if (counter == charList.size()) {
			return false;
		}
		return true;
	}

	@Override
	public Character next() {
		Character ch = charList.get(counter);
		counter++;
		return ch;
	}

	private void ignoreCaseHelper(List<Character> givenList) {
		for (Character c : givenList) {
			if (Character.isUpperCase(c)) {
				charList.add(c);
			}
		}

	}

}
