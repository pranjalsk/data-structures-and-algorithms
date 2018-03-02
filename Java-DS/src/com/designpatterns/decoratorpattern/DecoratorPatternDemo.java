//credits:http://www.waytoeasylearn.com

package com.designpatterns.decoratorpattern;

public class DecoratorPatternDemo {

	public static void main(String[] args) {
		Car sportscar = new SportsCar(new BasicCar());
		sportscar.assemble();

		Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
		sportsLuxuryCar.assemble();
	}

}

// Suppose we want to implement different kinds of cars – we can create
// interface Car to define the assemble method and then we can have a Basic car,
// further more we can extend it to Sports car and Luxury Car.

interface Car {
	public void assemble();
}

class BasicCar implements Car {
	@Override
	public void assemble() {
		System.out.println("Inside basic car");
	}
}

// --------Decorator class
class CarDecorator implements Car {

	protected Car car;

	public CarDecorator(Car c) {
		this.car = c;
	}

	@Override
	public void assemble() {
		this.car.assemble();
	}

}

// ------------Sub classes------------------
class SportsCar extends CarDecorator {

	public SportsCar(Car c) {
		super(c);
	}

	@Override
	public void assemble() {
		super.assemble();
		System.out.println("Adding sports car features");
	}
}

class LuxuryCar extends CarDecorator {

	public LuxuryCar(Car c) {
		super(c);
	}

	@Override
	public void assemble() {
		super.assemble();
		System.out.println("Adding LuxuryCar  features");
	}
}