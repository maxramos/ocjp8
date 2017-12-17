package ph.mramos.ocjp8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class IntStreamTest {
	
	@Test
	public void testComputation() {
		List<String> list = Arrays.asList("a", "bb", "ccc", "dddd", "eeeee", "eeeee");
		
		list.stream().mapToInt(e -> e.length()).average().ifPresent(System.out::println);
		System.out.println(list.stream().mapToInt(e -> e.length()).sum());
		System.out.println(list.stream().mapToInt(e -> e.length()).summaryStatistics());
	}
	
	@Test
	@SuppressWarnings("unused")
	public void testCreation() {
		IntStream stream1 = IntStream.empty();
		IntStream stream2 = IntStream.of(1);
		IntStream stream3 = IntStream.of(1, 2, 3, 4, 5);
		IntStream stream4 = IntStream.generate(() -> 1);
		IntStream stream5 = IntStream.iterate(0, e -> e + 1);
		IntStream stream6 = IntStream.concat(stream2, stream3);
		IntStream stream7 = IntStream.range(0, 5);
		IntStream stream8 = IntStream.rangeClosed(0, 5);
	}

	@Test
	public void testStream() {
		List<String> list = Arrays.asList("a", "bb", "ccc", "dddd", "eeeee", "eeeee");

		System.out.println(list.stream().mapToInt(e -> e.length()).allMatch(e -> e > 0));
		System.out.println(list.stream().mapToInt(e -> e.length()).anyMatch(e -> e > 4));
		System.out.println(list.stream().mapToInt(e -> e.length()).noneMatch(e -> e == 0));

		list.stream().mapToInt(e -> e.length()).findFirst().ifPresent(System.out::println);
		list.stream().mapToInt(e -> e.length()).findAny().ifPresent(System.out::println);

		System.out.println(list.stream().count());
		list.stream().mapToInt(e -> e.length()).max().ifPresent(System.out::println); // max has no comparator param
		list.stream().mapToInt(e -> e.length()).min().ifPresent(System.out::println); // min has no comparator param

		System.out.println(list.stream().mapToInt(e -> e.length()).distinct().collect(ArrayList::new, List::add, List::addAll)); // collect always have 3 params
		System.out.println(list.stream().mapToInt(e -> e.length()).limit(2).collect(ArrayList::new, List::add, List::addAll));
		list.stream().mapToInt(e -> e.length()).peek(System.out::print).collect(ArrayList::new, List::add, List::addAll);
		System.out.println();
		System.out.println(list.stream().mapToInt(e -> e.length()).skip(2).collect(ArrayList::new, List::add, List::addAll));
		System.out.println(list.stream().mapToInt(e -> e.length()).sorted().collect(ArrayList::new, List::add, List::addAll)); // there's no sorted with comparator param
	}

	@Test
	public void testStreamFilter() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		Set<Integer> set1 = list.stream().mapToInt(e -> e).filter(e -> e > 5).collect(LinkedHashSet::new, Set::add, Set::addAll);
		System.out.println(set1);
	}

	@Test
	public void testStreamMap() {
		List<String> list = Arrays.asList("a", "bb", "ccc", "dddd", "eeeee", "ffffff", "ggggggg", "hhhhhhhh", "iiiiiiiii", "jjjjjjjjjj");

		Set<Integer> set1 = list.stream().mapToInt(e -> e.length()).map(e -> e * 2).collect(LinkedHashSet::new, Set::add, Set::addAll);
		System.out.println(set1);
	}

	@Test
	public void testStreamFlatMap() {
		List<String> list = Arrays.asList("a", "bb", "ccc", "dddd");

		List<Integer> list1 = list.stream().mapToInt(e -> e.length()).flatMap(e -> IntStream.iterate(e, i -> i).limit(e)).collect(ArrayList::new, List::add, List::addAll);
		System.out.println(list1);
	}

	@Test
	public void testStreamCollect() {
		List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");

		Set<Integer> set1 = list.parallelStream().mapToInt(e -> e.length()).collect(HashSet::new, Set::add, Set::addAll);
		System.out.println(set1);
	}

	@Test
	public void testStreamReduce() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4);

		OptionalInt opt = list.stream().mapToInt(e -> e).reduce((x, y) -> x + y); // Note that it's OptionalInt and not Optional<Integer>
		opt.ifPresent(System.out::println);

		Integer sum = list.stream().mapToInt(e -> e).reduce(0, (x, y) -> x + y); // Note that there's no reduce method with 3rd param combiner
		System.out.println(sum);
	}
	
}
