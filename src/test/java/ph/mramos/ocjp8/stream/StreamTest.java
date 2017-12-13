package ph.mramos.ocjp8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamTest {

	@Test
	public void testStream() {
		List<String> list = Arrays.asList("a", "bb", "ccc", "dddd", "eeeee", "eeeee");

		System.out.println(list.stream().allMatch(e -> e.length() > 0));
		System.out.println(list.stream().anyMatch(e -> e.length() > 4));
		System.out.println(list.stream().noneMatch(e -> e.length() == 0));

		list.stream().findFirst().ifPresent(System.out::println);
		list.stream().findAny().ifPresent(System.out::println);

		System.out.println(list.stream().count());
		list.stream().max(String::compareTo).ifPresent(System.out::println);
		list.stream().min(String::compareTo).ifPresent(System.out::println);

		System.out.println(list.stream().distinct().collect(Collectors.toList()));
		System.out.println(list.stream().limit(2).collect(Collectors.toList()));
		list.stream().peek(System.out::print).collect(Collectors.toList());
		System.out.println();
		System.out.println(list.stream().skip(2).collect(Collectors.toList()));
		System.out.println(list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
	}

	@Test
	public void testStreamFilter() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		Set<Integer> set1 = list.stream().filter(e -> e > 5).collect(Collectors.toSet());
		System.out.println(set1);
	}

	@Test
	public void testStreamMap() {
		List<String> list = Arrays.asList("a", "bb", "ccc", "dddd", "eeeee", "ffffff", "ggggggg", "hhhhhhhh", "iiiiiiiii", "jjjjjjjjjj");

		Set<Integer> set1 = list.stream().map(e -> e.length()).collect(Collectors.toSet());
		System.out.println(set1);
	}

	@Test
	public void testStreamFlatMap() {
		List<String> list = Arrays.asList("a", "bb", "ccc", "dddd");

		List<Integer> list1 = list.stream().flatMap(e -> Stream.iterate(e.length(), i -> i).limit(e.length())).collect(Collectors.toList());
		System.out.println(list1);
	}

	@Test
	public void testStreamCollect() {
		List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");

		Set<String> set1 = list.stream().collect(Collectors.toSet());
		System.out.println(set1);

		Set<String> set2 = list.parallelStream().collect(HashSet::new, (s,e) -> s.add(e), (s1, s2) -> s1.addAll(s2));
		System.out.println(set2);
	}

	@Test
	public void testStreamReduce() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4);

		Optional<Integer> opt = list.stream().reduce((x, y) -> x + y);
		opt.ifPresent(System.out::println);

		Integer sum = list.stream().reduce(0, (x, y) -> x + y);
		System.out.println(sum);

		Integer sumParallel = list.parallelStream().reduce(0, (x, y) -> x + y, (x, y) -> x + y);
		System.out.println(sumParallel);
	}

}
