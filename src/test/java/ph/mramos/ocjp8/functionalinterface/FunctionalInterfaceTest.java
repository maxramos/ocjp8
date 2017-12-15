package ph.mramos.ocjp8.functionalinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongSupplier;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongBiFunction;
import java.util.function.ToLongFunction;
import java.util.function.UnaryOperator;

import org.junit.Test;

public class FunctionalInterfaceTest {

	@Test
	public void testSupplier() { // 5 : 5
		Supplier<List<String>> supplier = ArrayList::new;
		List<String> list = supplier.get();
		System.out.println(list instanceof List);

		BooleanSupplier supplier1 = () -> true;
		boolean bool = supplier1.getAsBoolean();
		System.out.println(bool);

		IntSupplier supplier2 = () -> 1;
		int num1 = supplier2.getAsInt();
		System.out.println(num1);

		LongSupplier supplier3 = () -> 1L;
		long num2 = supplier3.getAsLong();
		System.out.println(num2);

		DoubleSupplier supplier4 = () -> 1D;
		double num3 = supplier4.getAsDouble();
		System.out.println(num3);
	}

	@Test
	public void testConsumer() { // 4 : 9
		Consumer<String> consumer = x -> System.out.println(x.length());
		consumer = consumer.andThen(x -> System.out.println(x.toUpperCase()));
		consumer.accept("test");

		IntConsumer consumer1 = x -> System.out.println(x);
		consumer1 = consumer1.andThen(x -> System.out.println(x + 1));
		consumer1.accept(1);

		LongConsumer consumer2 = x -> System.out.println(x);
		consumer2 = consumer2.andThen(x -> System.out.println(x + 1));
		consumer2.accept(1L);

		DoubleConsumer consumer3 = x -> System.out.println(x);
		consumer3 = consumer3.andThen(x -> System.out.println(x + 1));
		consumer3.accept(1D);
	}

	@Test
	public void testPredicate() { // 4 : 13
		Predicate<String> predicate = x -> "test".equals(x);
		predicate = predicate.and(x -> x.length() == 5).or(x -> true).negate().or(Predicate.isEqual("test"));
		boolean bool = predicate.test("test");
		System.out.println(bool);

		IntPredicate predicate1 = x -> x == 1;
		predicate1 = predicate1.and(x -> x > 1).or(x -> true).negate();
		boolean bool1 = predicate1.test(1);
		System.out.println(bool1);

		LongPredicate predicate2 = x -> x == 1L;
		predicate2 = predicate2.and(x -> x > 1L).or(x -> true).negate();
		boolean bool2 = predicate2.test(1L);
		System.out.println(bool2);

		DoublePredicate predicate3 = x -> x == 1D;
		predicate3 = predicate3.and(x -> x > 1D).or(x -> true).negate();
		boolean bool3 = predicate3.test(1D);
		System.out.println(bool3);
	}

	@Test
	public void testFunction() { // 13 : 26
		Function<String, String> function = x -> x.toUpperCase();
		function = function.andThen(x -> x + "End").andThen(Function.identity()).compose(x -> "Start" + x);
		String result = function.apply("test");
		System.out.println(result);

		// int
		IntFunction<String> function1 = x -> "result: " + x;
		String result1 = function1.apply(1);
		System.out.println(result1);

		IntToLongFunction function2 = x -> x + 1L;
		long result2 = function2.applyAsLong(1);
		System.out.println(result2);

		IntToDoubleFunction function3 = x -> x + 1D;
		double result3 = function3.applyAsDouble(1);
		System.out.println(result3);

		// long
		LongFunction<String> function4 = x -> "result: " + x;
		String result4 = function4.apply(1L);
		System.out.println(result4);

		LongToIntFunction function5 = x -> (int) (x + 1);
		int result5 = function5.applyAsInt(1L);
		System.out.println(result5);

		LongToDoubleFunction function6 = x -> x + 1D;
		double result6 = function6.applyAsDouble(1L);
		System.out.println(result6);

		// double
		DoubleFunction<String> function7 = x -> "result: " + x;
		String result7 = function7.apply(1D);
		System.out.println(result7);

		DoubleToIntFunction function8 = x -> (int) (x + 1);
		int result8 = function8.applyAsInt(1L);
		System.out.println(result8);

		DoubleToLongFunction function9 = x -> (long) (x + 1L);
		long result9 = function9.applyAsLong(1D);
		System.out.println(result9);

		// to
		ToIntFunction<String> function10 = x -> Integer.parseInt(x);
		int result10 = function10.applyAsInt("1");
		System.out.println(result10);

		ToLongFunction<String> function11 = x -> Long.parseLong(x);
		long result11 = function11.applyAsLong("1");
		System.out.println(result11);

		ToDoubleFunction<String> function12 = x -> Double.parseDouble(x);
		double result12 = function12.applyAsDouble("1");
		System.out.println(result12);
	}

	@Test
	public void testBiConsumer() { // 4 : 30
		BiConsumer<String, Integer> consumer = (x, y) -> System.out.println(x.length() == y);
		consumer = consumer.andThen((x, y) -> System.out.println(x.toUpperCase() + ":" + y));
		consumer.accept("test", 4);

		ObjIntConsumer<String> consumer1 = (x, y) -> System.out.println(x + ":" + y);
		consumer1.accept("test", 4);

		ObjLongConsumer<String> consumer2 = (x, y) -> System.out.println(x + ":" + y);
		consumer2.accept("test", 4L);

		ObjDoubleConsumer<String> consumer3 = (x, y) -> System.out.println(x + ":" + y);
		consumer3.accept("test", 4D);
	}

	@Test
	public void testBiPredicate() { // 1 : 31
		BiPredicate<String, Integer> predicate = (x, y) -> x.length() == y;
		predicate = predicate.and((x, y) -> x.length() > y).or((x, y) -> true).negate();
		boolean bool = predicate.test("test", 4);
		System.out.println(bool);
	}

	@Test
	public void testBiFunction() { // 4 : 35
		BiFunction<String, Integer, String> function = (x, y) -> x.toUpperCase() + ":" + y;
		function = function.andThen(x -> x + "End");
		String result = function.apply("test", 4);
		System.out.println(result);

		ToIntBiFunction<String, Integer> function1 = (x, y) -> Integer.parseInt(x) + y;
		int result1 = function1.applyAsInt("1", 1);
		System.out.println(result1);

		ToLongBiFunction<String, Long> function2 = (x, y) -> Long.parseLong(x) + y;
		long result2 = function2.applyAsLong("1", 1L);
		System.out.println(result2);

		ToDoubleBiFunction<String, Double> function3 = (x, y) -> Double.parseDouble(x) + y;
		double result3 = function3.applyAsDouble("1", 1D);
		System.out.println(result3);
	}

	@Test
	public void testUnaryOperator() { // 4 : 39
		UnaryOperator<String> operator = x -> x.toUpperCase();
		Function<String, String> function = operator.andThen(x -> x + "End").andThen(UnaryOperator.identity()).compose(x -> "Start" + x);
		String result = function.apply("test");
		System.out.println(result);

		IntUnaryOperator operator1 = x -> x + 1;
		operator1 = operator1.andThen(x -> x + 1).andThen(IntUnaryOperator.identity()).compose(x -> 1 + x);
		int result1 = operator1.applyAsInt(1);
		System.out.println(result1);

		LongUnaryOperator operator2 = x -> x + 1L;
		operator2 = operator2.andThen(x -> x + 1L).andThen(LongUnaryOperator.identity()).compose(x -> 1L + x);
		long result2 = operator2.applyAsLong(1L);
		System.out.println(result2);

		DoubleUnaryOperator operator3 = x -> x + 1D;
		operator3 = operator3.andThen(x -> x + 1D).andThen(DoubleUnaryOperator.identity()).compose(x -> 1D + x);
		double result3 = operator3.applyAsDouble(1D);
		System.out.println(result3);
	}

	@Test
	public void testBinaryOperator() { // 4 : 43
		BinaryOperator<String> operator = (x, y) -> x + ":" + y;
		BiFunction<String, String, String> function = operator.andThen(x -> x.toUpperCase());
		String result = function.apply("test", "word");
		System.out.println(result);

		BinaryOperator<Integer> operator1 = BinaryOperator.minBy((x, y) -> x - y);
		Integer result1 = operator1.apply(2, 3);
		System.out.println(result1);

		BinaryOperator<Integer> operator2 = BinaryOperator.maxBy((x, y) -> x - y);
		Integer result2 = operator2.apply(2, 3);
		System.out.println(result2);

		IntBinaryOperator operator3 = (x, y) -> x + y;
		int result3 = operator3.applyAsInt(1, 1);
		System.out.println(result3);

		LongBinaryOperator operator4 = (x, y) -> x + y;
		long result4 = operator4.applyAsLong(1L, 1L);
		System.out.println(result4);

		DoubleBinaryOperator operator5 = (x, y) -> x + y;
		double result5 = operator5.applyAsDouble(1D, 1D);
		System.out.println(result5);
	}

}
