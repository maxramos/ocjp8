package ph.mramos.ocjp8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.junit.Test;

public class CollectorTest {

	@Test
	public void testAveraging() {
		List<String> list = Arrays.asList("a", "bb", "ccc", "dddd", "eeeee");
		
		Double avg1 = list.stream().collect(Collectors.averagingInt(e -> e.length()));
		System.out.println(avg1);
		
		Double avg2 = list.stream().collect(Collectors.averagingLong(e -> e.length()));
		System.out.println(avg2);
		
		Double avg3 = list.stream().collect(Collectors.averagingDouble(e -> e.length()));
		System.out.println(avg3);
	}

	@Test
	public void testCollectingAndThen() {
		List<String> list = Arrays.asList("a", "bb", "ccc", "dddd", "eeeee");
		
		Double result = list.stream().collect(Collectors.collectingAndThen(Collectors.averagingInt(e -> e.length()), avg -> avg * 2));
		System.out.println(result);
	}

	@Test
	public void testCounting() {
		List<String> list = Arrays.asList("a", "bb", "ccc", "dddd", "eeeee");
		
		Long count = list.stream().collect(Collectors.counting());
		System.out.println(count);
	}

	@Test
	public void testGroupingBy() {
		List<String> list = Arrays.asList("a", "b", "c", "dd", "ee", "ff", "ggg", "hhh", "iii");
		
		Map<Integer, List<String>> map1 = list.stream().collect(Collectors.groupingBy(e -> e.length()));
		System.out.println(map1);
		
		Map<Integer, String> map2 = list.stream().collect(Collectors.groupingBy(e -> e.length(), Collectors.joining("-")));
		System.out.println(map2);
		
		Map<Integer, String> map3 = list.stream().collect(Collectors.groupingBy(e -> e.length(), LinkedHashMap::new, Collectors.joining("-")));
		System.out.println(map3);
		
		Map<Integer, List<String>> map4 = list.stream().collect(Collectors.groupingByConcurrent(e -> e.length()));
		System.out.println(map4);
		
		Map<Integer, String> map5 = list.stream().collect(Collectors.groupingByConcurrent(e -> e.length(), Collectors.joining("-")));
		System.out.println(map5);
		
		Map<Integer, String> map6 = list.stream().collect(Collectors.groupingByConcurrent(e -> e.length(), ConcurrentHashMap::new, Collectors.joining("-")));
		System.out.println(map6);
	}
	
	@Test
	public void testJoining() {
		List<String> list = Arrays.asList("a", "bb", "ccc", "dddd", "eeeee");
		
		String str1 = list.stream().collect(Collectors.joining());
		System.out.println(str1);
		
		String str2 = list.stream().collect(Collectors.joining("-"));
		System.out.println(str2);
		
		String str3 = list.stream().collect(Collectors.joining("-", "start", "end"));
		System.out.println(str3);
	}
	
	@Test
	public void testMapping() {
		List<String> list = Arrays.asList("a", "bb", "ccc", "dddd", "eeeee");
		
		String str = list.stream().collect(Collectors.mapping(e -> Integer.toString(e.length()), Collectors.joining()));
		System.out.println(str);
	}
	
	@Test
	public void testMaxBy() {
		List<String> list = Arrays.asList("a", "bb", "ccc", "dddd", "eeeee");
		
		Optional<String> opt = list.stream().collect(Collectors.maxBy((x, y) -> x.length() - y.length()));
		opt.ifPresent(System.out::println);
	}
	
	@Test
	public void testMinBy() {
		List<String> list = Arrays.asList("a", "bb", "ccc", "dddd", "eeeee");
		
		Optional<String> opt = list.stream().collect(Collectors.minBy((x, y) -> x.length() - y.length()));
		opt.ifPresent(System.out::println);
	}
	
	@Test
	public void testPartitioningBy() {
		List<Character> list = Arrays.asList('1', '2', '3', 'a', 'b', 'c');
		
		Map<Boolean, List<Character>> map1 = list.stream().collect(Collectors.partitioningBy(Character::isDigit));
		System.out.println(map1);
		
		Map<Boolean, Long> map2 = list.stream().collect(Collectors.partitioningBy(Character::isDigit, Collectors.counting()));
		System.out.println(map2);
	}
	
	@Test
	public void testReducing() {
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
		
		Optional<Integer> opt1 = list1.stream().collect(Collectors.reducing((x, y) -> x + y));
		opt1.ifPresent(System.out::println);
		
		Integer result1 = list1.stream().collect(Collectors.reducing(0, (x, y) -> x + y));
		System.out.println(result1);
		
		List<String> list2 = Arrays.asList("a", "bb", "ccc", "dddd", "eeeee");
		
		Integer result2 = list2.stream().collect(Collectors.reducing(0, e -> e.length(), (x, y) -> x + y));
		System.out.println(result2);
	}
	
	@Test
	public void testSummarizing() {
		List<String> list = Arrays.asList("a", "bb", "ccc", "dddd", "eeeee");
		
		IntSummaryStatistics stat1 = list.stream().collect(Collectors.summarizingInt(e -> e.length()));
		System.out.println(stat1);
		
		LongSummaryStatistics stat2 = list.stream().collect(Collectors.summarizingLong(e -> e.length()));
		System.out.println(stat2);
		
		DoubleSummaryStatistics stat3 = list.stream().collect(Collectors.summarizingDouble(e -> e.length()));
		System.out.println(stat3);
	}
	
	@Test
	public void testSumming() {
		List<String> list = Arrays.asList("a", "bb", "ccc", "dddd", "eeeee");
		
		Integer result1 = list.stream().collect(Collectors.summingInt(e -> e.length()));
		System.out.println(result1);
		
		Long result2 = list.stream().collect(Collectors.summingLong(e -> e.length()));
		System.out.println(result2);
	
		Double result3 = list.stream().collect(Collectors.summingDouble(e -> e.length()));
		System.out.println(result3);
	}
	
	@Test
	public void testToCollection() {
		List<String> list = Arrays.asList("a", "bb", "ccc", "dddd", "eeeee");
		
		List<String> result1 = list.stream().collect(Collectors.toList());
		System.out.println(result1);
		
		Set<String> result2 = list.stream().collect(Collectors.toSet());
		System.out.println(result2);
		
		List<String> result3 = list.stream().collect(Collectors.toCollection(ArrayList::new));
		System.out.println(result3);
	}
	
	@Test
	public void testToMap() {
		List<String> list = Arrays.asList("a", "b", "c", "dd", "ee", "ff", "ggg", "hhh", "iii");
		
		Map<String, Integer> result1 = list.stream().collect(Collectors.toMap(String::toString, String::length));
		System.out.println(result1);
		
		Map<Integer, String> result2 = list.stream().collect(Collectors.toMap(String::length, String::toString, (x, y) -> x + y));
		System.out.println(result2);
		
		Map<Integer, String> result3 = list.stream().collect(Collectors.toMap(String::length, String::toString, (x, y) -> x + y, LinkedHashMap::new));
		System.out.println(result3);
		
		Map<String, Integer> result4 = list.stream().collect(Collectors.toConcurrentMap(String::toString, String::length));
		System.out.println(result4);
		
		Map<Integer, String> result5 = list.stream().collect(Collectors.toConcurrentMap(String::length, String::toString, (x, y) -> x + y));
		System.out.println(result5);
		
		Map<Integer, String> result6 = list.stream().collect(Collectors.toConcurrentMap(String::length, String::toString, (x, y) -> x + y, ConcurrentHashMap::new));
		System.out.println(result6);
	}
	
}
