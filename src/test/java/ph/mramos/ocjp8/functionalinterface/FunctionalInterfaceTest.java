package ph.mramos.ocjp8.functionalinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongSupplier;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

import org.junit.Test;

public class FunctionalInterfaceTest {

	@Test
	public void testSupplier() {
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
	public void testConsumer() {
		Consumer<String> consumer = x -> System.out.println(x.length());
		consumer = consumer.andThen(x -> System.out.println(x.toUpperCase()));
		consumer.accept("test");
		
		IntConsumer consumer1 = x -> System.out.println(x);
		consumer1.accept(1);
		
		LongConsumer consumer2 = x -> System.out.println(x);
		consumer2.accept(1L);
		
		DoubleConsumer consumer3 = x -> System.out.println(x);
		consumer3.accept(1D);
	}
	
	@Test
	public void testPredicate() {
		Predicate<String> predicate = x -> "test".equals(x);
		predicate = predicate.and(x -> x.length() == 5).or(x -> true).negate().or(Predicate.isEqual("test"));
		boolean bool = predicate.test("test");
		System.out.println(bool);
		
		Predicate<String> predicate0 = Predicate.isEqual("test");
		boolean bool0 = predicate0.test("test");
		System.out.println(bool0);
		
		IntPredicate predicate1 = x -> x == 1;
		boolean bool1 = predicate1.test(1);
		System.out.println(bool1);
		
		LongPredicate predicate2 = x -> x == 1L;
		boolean bool2 = predicate2.test(1L);
		System.out.println(bool2);
		
		DoublePredicate predicate3 = x -> x == 1D;
		boolean bool3 = predicate3.test(1D);
		System.out.println(bool3);
	}
	
	@Test
	public void testFunction() {
		Function<String, String> function = x -> x.toUpperCase();
		function = function.andThen(x -> x + "End").andThen(Function.identity()).compose(x -> "Start" + x);
		String result = function.apply("test");
		System.out.println(result);
		
		Function<String, String> function0 = Function.identity();
		String result0 = function0.apply("test");
		System.out.println(result0);
		
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

}
