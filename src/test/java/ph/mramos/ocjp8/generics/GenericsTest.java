package ph.mramos.ocjp8.generics;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GenericsTest {

	@Test
	public void testGenerics() {
		List<Integer> intList = new ArrayList<>();
		intList.add(10);
		addNumber(intList);
		System.out.println(getNumber(intList));
		System.out.println(getNumberWildcard(intList));
		
		List<? extends Integer> numList = new ArrayList<>();
//		numList.add(20); compile error
		System.out.println(getNumber(numList));
	}
	
	private Number getNumber(List<? extends Number> list) {
//		list.add(1); compile error
		return list.isEmpty() ? null : list.get(0);
	}
	
	private void addNumber(List<? super Integer> list) {
		list.add(30);
		Object obj = list.get(0);
//		Integer num = list.get(0); compile error
	}
	
	private Object getNumberWildcard(List<?> list) {
//		list.add(new Object()); compile error
		return list.isEmpty() ? null : list.get(0);
	}
	
}
