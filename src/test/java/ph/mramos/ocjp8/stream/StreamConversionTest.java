package ph.mramos.ocjp8.stream;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamConversionTest {

	@Test
	@SuppressWarnings("unused")
	public void testStreamToNumericStream() {
		IntStream stream1 = Stream.of("test").mapToInt(e -> e.length());
		IntStream stream2 = Stream.of("test").flatMapToInt(e -> IntStream.of(e.length()));
		
		LongStream stream3 = Stream.of("test").mapToLong(e -> e.length());
		LongStream stream4 = Stream.of("test").flatMapToLong(e -> LongStream.of(e.length()));
		
		DoubleStream stream5 = Stream.of("test").mapToDouble(e -> e.length());
		DoubleStream stream6 = Stream.of("test").flatMapToDouble(e -> DoubleStream.of(e.length()));
	}
	
	@Test
	@SuppressWarnings("unused")
	public void testNumericStreamToStream() {
		Stream<Integer> stream1 = IntStream.of(1).boxed();
		Stream<Long> stream2 = LongStream.of(1).boxed();
		Stream<Double> stream3 = DoubleStream.of(1).boxed();
		
		Stream<String> stream4 = IntStream.of(1).mapToObj(e -> Integer.toString(e));
		Stream<String> stream5 = LongStream.of(1).mapToObj(e -> Long.toString(e));
		Stream<String> stream6 = DoubleStream.of(1).mapToObj(e -> Double.toString(e));
	}
	
	@Test
	@SuppressWarnings("unused")
	public void testNumericStreamtoNumericStream() {
		LongStream stream1 = IntStream.of(1).asLongStream();
		DoubleStream stream2 = IntStream.of(1).asDoubleStream();
		DoubleStream stream3 = LongStream.of(1).asDoubleStream();
		
		LongStream stream4 = IntStream.of(1).mapToLong(e -> e);
		DoubleStream stream5 = IntStream.of(1).mapToDouble(e -> e);
		IntStream stream6 = LongStream.of(1).mapToInt(e -> (int) e);
		DoubleStream stream7 = LongStream.of(1).mapToDouble(e -> e);
		IntStream stream8 = DoubleStream.of(1).mapToInt(e -> (int) e);
		LongStream strea97 = DoubleStream.of(1).mapToLong(e -> (long) e);
	}
	
}
