package shop.mtcoding.streamstudy.lab;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class StreamEx02Test {

	@Test
	public void ex06() {
		IntStream stream = IntStream.of(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);

		stream.peek(s -> System.out.println("원본 스트림 : " + s))
				.skip(2)
				.peek(s -> System.out.println("skip(2) 실행 후 : " + s))
				.limit(5)
				.peek(s -> System.out.println("limit(5) 실행 후 : " + s))
				.sorted()
				.peek(s -> System.out.println("sorted() 실행 후 : " + s))
				.forEach(n -> System.out.println(n));
	}

	@Test
	public void ex05() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		List<Integer> newList = list.stream()
				.limit(2)
				.skip(1).peek(t -> {
					System.out.println("peek : " + t);
				})
				.collect(Collectors.toList());

		newList.stream().forEach(t -> System.out.println(t));
	}

	@Test
	public void ex04() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		List<Integer> newList = list.stream()
				.limit(2)
				.collect(Collectors.toList());

		newList.stream().forEach(t -> System.out.println(t));
	}

	@Test
	public void ex03() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		List<Integer> newList = list.stream()
				.filter(t -> t != 3)
				.map(t -> {
					Integer r = t * 2;
					return r;
				})
				.collect(Collectors.toList());

		newList.stream().forEach(t -> System.out.println(t));
	}

	@Test
	public void ex02() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		List<Integer> newList = list.stream().filter(t -> t != 3).collect(Collectors.toList());

		newList.stream().forEach(t -> System.out.println(t));
	}

	@Test
	public void ex01() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		List<Integer> newList = list.stream().filter(t -> t % 2 != 0).collect(Collectors.toList());

		newList.stream().forEach(t -> System.out.println(t));
	}

}
