package com.acme.apples;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

public class FlatMapExample {

	public static void main(String[] args) {
		String s = "Nel mezzo del cammin di nostra vita del poeta";
		String[] words = s.split(" ");
		System.out.println(Arrays.toString(words));
	
		List<String> result = Stream.of(words).sorted().distinct().collect(toList());
		System.out.println(result);
		
		///////////////////////////////////////////////////////////////////////////////
		
		String[] strings = new String[] { "La vispa teresa", "avea tra l'erbetta" };
		
		List<String> result2 = 
				Stream.of(strings).flatMap(str -> Stream.of(str.split(" ")))
								  .sorted()
								  .distinct()
							      .collect(toList());
		System.out.println(result2);
		
		///////////////////////////////////////////////////////////////////////////////
		
		IntStream.range(0, 10) .parallel()
							   .mapToObj(i -> "String #" + i)
						       .peek(o -> System.out.println("1: " + o))
							   .sorted(Comparator.reverseOrder())
							   .collect(toList())
							   .stream()
//							   .sequential()
							   .peek(o -> System.out.println("2: " + o))
							   .distinct()
							   .forEach(System.out::println);
		
		//////////////////////////////////////////////////////////////////////////////
		
		IntStream.iterate(0, x -> x + 3).limit(20).forEach(System.out::println);
		
		//////////////////////////////////////////////////////////////////////////////
		
		// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
		// (0, 1) (1, 1) (1, 2) (2, 3) (3, 5)
		
		Stream.iterate(new int[] {0, 1}, a -> new int[] { a[1], a[0] + a[1] })
		      .limit(10)
		      .map(a -> a[0])
		      .forEach(System.out::println);
		
		//////////////////////////////////////////////////////////////////////////////
		
		int sum = IntStream.rangeClosed(1, 100).reduce(0, (x, y) -> x + y);
		System.out.println("sum(1..100) = " + sum);
		
		//////////////////////////////////////////////////////////////////////////////
		
		String numbers = 
				IntStream.rangeClosed(1, 10).mapToObj(Integer::toString)
								            .collect(joining(", "));
		System.out.println("numbers : " + numbers);
	}

}
