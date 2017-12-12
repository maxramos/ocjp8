package ph.mramos.ocjp8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
	
}
