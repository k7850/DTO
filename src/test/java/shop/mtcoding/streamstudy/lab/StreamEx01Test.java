package shop.mtcoding.streamstudy.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class StreamEx01Test {

	@Test
	public void ex06(){

		List<Integer> list = Arrays.asList(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);

		// 스트림으로 중복 제거, 정렬
		List<Integer> newList = list.stream()
				.distinct()
				.sorted(Comparator.naturalOrder())
				.collect(Collectors.toList());

		newList.forEach(i -> System.out.print(i +" "));

	} 





	@Test
	public void ex04() {

		List<Integer> list = Arrays.asList(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);
		List<Integer> newList = new ArrayList<>();
		for (Integer i : list) {
			newList.add(i);
		}
		
		for(int i=0 ; i<newList.size() ; i++){
			for(int j=i+1 ; j<newList.size() ; j++){
				if(newList.get(i) == newList.get(j)){
					newList.remove(j);
				}
			}
		}

		System.out.println(list);
		System.out.println(newList);
		
		List<Integer> newSortList = new ArrayList<>();
		for (Integer i : newList) {
			newSortList.add(i);
		}

        for (int i=0 ; i<newSortList.size()-1 ; i++) {
            for (int j=0 ; j<newSortList.size()-1-i ; j++) {
                if ( newSortList.get(j) > newSortList.get(j+1) ) {
                    Integer temp = newSortList.get(j);
                    newSortList.set(j, newSortList.get(j+1));
                    newSortList.set(j+1, temp);
                }
            }
        }
		System.out.println(newSortList);
		
	}


	@Test
	public void ex02() {

		List<Integer> list = Arrays.asList(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);
		List<Integer> lowList = new ArrayList<>();
		List<Integer> highList = new ArrayList<>();

		// 얕은 복사
		lowList = list;

		// 깊은 복사
		for (Integer i : list) {
			highList.add(i);
		}



		Stream<Integer> stream = list.stream();

	}

	
	@Test
	public void ex01() {

		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(4);
		list.add(2);
		list.add(3);
		list.add(1);

		Stream<Integer> stream = list.stream();
		stream.forEach(t -> {
			System.out.println(t);
		});

		System.out.println("=================");

		// 같은 코드인데 위에꺼로 쓰자
		Stream<Integer> stream2 = list.stream();
		stream2.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				System.out.println(t);
			}
		});

		System.out.println("=================");

		// 문법임
		Stream<Integer> stream3 = list.stream();
		stream3.forEach(System.out::println);

	}
}
