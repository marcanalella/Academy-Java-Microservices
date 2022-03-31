package com.acme.apples;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class Main {
	public static void main(String[] args) {
		
		List<Apple> apples = Arrays.asList(
				new Apple("red", 10, 50),
				new Apple("red",  7, 30),
				new Apple("yellow", 10, 50),
				new Apple("green", 7, 30),
				new Apple("green", 14, 100)
				);
		
		List<Apple> redApples = new ArrayList<>();
		
		for (Apple apple : apples) {
			if (apple.getColour().equals("red")) {
				redApples.add(apple);
			}
		}
		
		System.out.println("Red apples " + redApples);
		
		List<Double> redApplesSize = new ArrayList<>();
		
		for (Apple apple : redApples) {
			redApplesSize.add(apple.getSize());
		}
		
		System.out.println("Red apples size: " + redApplesSize);
		
		/////////////////////////////////////////////////////////////////////
	
		List<Double> sizes = redApples.stream()
							          .filter(a -> a.getColour().equals("red"))
//							          .map(a -> a.getSize())
							          .map(Apple::getSize)
							          .collect(Collectors.toList());
		System.out.println("Red apples size: " + sizes);
		
		Function<Apple, Double> f = Apple::getSize;
		Apple ap1 = new Apple("red", 1, 1);
		Supplier<Double> s = ap1::getSize;
		
		BiFunction<Apple, Object, Boolean> e = Apple::equals;
		Function<Object, Boolean> e2 = ap1::equals;
		
		Function<String, Apple> c1 = Apple::new;
		BiFunction<String, Double, Apple> c2 = Apple::new;
		TriFunction<String, Double, Double, Apple> c3 = Apple::new;
		
		System.out.println("Trif: " + c3.apply("red", 1.0, 2.0));
		
		/////////////////////////////////////////////////////////////////////
		
//		Comparator<Apple> cmp = (a1, a2) ->
//			 a1.getColour().compareTo(a2.getColour());
		
//		Function<Apple, Double> size = Apple::getSize;
		List<Apple> sortedApples =
			apples.stream()
				  .sorted(comparing(Apple::getColour)
						  	.thenComparing(Apple::getSize)
//						  	.thenComparing( size.andThen(ss -> ss * ss) )
				  			.thenComparing(Apple::getWeight))
				  .collect(toList());
		System.out.println("Sorted apples " + sortedApples);
		
		/////////////////////////////////////////////////////////////////////
		
		double w = apples.stream().mapToDouble(Apple::getWeight).reduce(0, (x,y) -> x + y);
		System.out.println("Total weight: " + w);
		
		OptionalDouble lw = apples.stream().mapToDouble(Apple::getWeight).reduce(Math::min);
		System.out.println("Min weight: " + lw);
		
		Optional<Apple> lwa =
   		   apples.stream().reduce((a1, a2) -> a1.getWeight() < a2.getWeight() ? a1 : a2);
		System.out.println("Lighter apple: " + lwa);
		
		/////////////////////////////////////////////////////////////////////

		Map<String, List<Apple>> applesByColour = new HashMap<>();
		
		for (Apple apple : apples) {
			String colour = apple.getColour();
			List<Apple> colApples = applesByColour.get(colour);
			
			if (colApples == null) {
				colApples = new ArrayList<>();
				applesByColour.put(colour, colApples);
			}
			colApples.add(apple);
		}
		
		System.out.println("Grouped by colour: " + applesByColour);
		applesByColour = apples.stream().collect(groupingBy(Apple::getColour));
		System.out.println("Grouped by colour: " + applesByColour);
		applesByColour = apples.stream()
				.collect(groupingBy(Apple::getColour, TreeMap::new, toList()));
		System.out.println("Grouped by colour sorted: " + applesByColour);
	}
}
