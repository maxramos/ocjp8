package ph.mramos.ocjp8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class CollectorTest {

	@Test
	public void testAveraging() {
		List<String> list = Arrays.asList("a", "bb", "ccc", "dddd", "eeeee");
		Double avg = list.stream().collect(Collectors.averagingInt(e -> e.length()));
		System.out.println(avg);
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

}
