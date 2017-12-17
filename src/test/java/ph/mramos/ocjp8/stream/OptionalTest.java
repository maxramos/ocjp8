package ph.mramos.ocjp8.stream;

import java.util.Optional;

import org.junit.Test;

public class OptionalTest {

	@Test
	public void testCreation() {
		Optional<String> opt1 = Optional.empty();
		opt1.ifPresent(System.out::println);

		Optional<String> opt2 = Optional.of("test");
		opt2.ifPresent(System.out::println);

		Optional<String> opt3 = Optional.ofNullable(null);
		opt3.ifPresent(System.out::println);
	}

	@Test
	public void testFilter() {
		Optional<String> opt1 = Optional.of("test").filter(e -> e.length() == 4);
		opt1.ifPresent(System.out::println);

		Optional<String> opt2 = Optional.of("test1").filter(e -> e.length() == 4);
		opt2.ifPresent(System.out::println);
	}

	@Test
	public void testMap() {
		Optional<Integer> opt1 = Optional.of("test").map(e -> e.length());
		opt1.ifPresent(System.out::println);

		Optional<String> opt2 = Optional.of("test1").flatMap(e -> Optional.of(e + "test2"));
		opt2.ifPresent(System.out::println);
	}

	@Test
	public void testGet() {
		Optional<String> opt1 = Optional.of("test");
		String result1 = opt1.isPresent() ? opt1.get() : null;
		System.out.println(result1);

		Optional<String> opt2 = Optional.empty();
		String result2 = opt2.isPresent() ? opt1.get() : null;
		System.out.println(result2);
	}

	@Test
	public void testOrElse() {
		Optional<String> opt1 = Optional.of("test");
		String result1 = opt1.orElse("test1");
		System.out.println(result1);

		Optional<String> opt2 = Optional.empty();
		String result2 = opt2.orElse("test2");
		System.out.println(result2);

		Optional<String> opt3 = Optional.empty();
		String result3 = opt3.orElseGet(() -> "test3");
		System.out.println(result3);
	}

	@Test(expected = RuntimeException.class)
	public void testOrElseThrow() {
		Optional<String> opt1 = Optional.empty();
		String result1 = opt1.orElseThrow(RuntimeException::new);
		System.out.println(result1);
	}

	@Test
	public void testObjectMethods() {
		Optional<String> opt1 = Optional.of("test");
		System.out.println(opt1);

		Optional<String> opt2 = Optional.of("test");
		System.out.println(opt1.equals(opt2));

		System.out.println("test".hashCode() + ":" + opt1.hashCode());
	}
}
