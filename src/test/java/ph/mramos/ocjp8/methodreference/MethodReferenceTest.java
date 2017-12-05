package ph.mramos.ocjp8.methodreference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MethodReferenceTest {

	@Test
	public void testStaticMethodReference() {
		ListSupplier<Integer> listSupplier = CollectionUtil::newList;
		List<Integer> list = listSupplier.get();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list);
		
		ListSupplierWithParam<Character> sizedListSupplier = CollectionUtil::newList;
		List<Character> sizedList = sizedListSupplier.get(Arrays.asList('1', '2', '3'));
		sizedList.add('a');
		sizedList.add('b');
		sizedList.add('c');
		System.out.println(sizedList);
	}
	
	@Test
	public void testInstanceMethodReference() {
		CollectionFactory<Integer> factory = new CollectionFactory<>();
		
		ListSupplier<Integer> listSupplier = factory::newList;
		List<Integer> list = listSupplier.get();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list);
		
		ListSupplierWithParam<Integer> sizedListSupplier = factory::newList;
		List<Integer> sizedList = sizedListSupplier.get(Arrays.asList(1, 2, 3));
		sizedList.add(4);
		sizedList.add(5);
		sizedList.add(6);
		System.out.println(sizedList);
	}
	
	@Test
	public void testArbitraryInstanceMethodReference() {
		CollectionFactory<Integer> factory = new CollectionFactory<>();

		FactoryBasedListSupplier<Integer> listSupplier = CollectionFactory::newList;
		List<Integer> list = listSupplier.get(factory);
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list);
		
		FactoryBasedListSupplierWithParam<Integer> sizedListSupplier = CollectionFactory::newList;
		List<Integer> sizedList = sizedListSupplier.get(factory, Arrays.asList(1, 2, 3));
		sizedList.add(4);
		sizedList.add(5);
		sizedList.add(6);
		System.out.println(sizedList);
	}
	
	@Test
	public void testConstructorMethodReference() {
		StringListSupplier strListSupplier = ArrayList::new;
		List<String> strList = strListSupplier.get();
		strList.add("a");
		strList.add("b");
		strList.add("c");
		System.out.println(strList);
		
		ListSupplier<Integer> listSupplier = ArrayList::new;
		List<Integer> list = listSupplier.get();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list);
		
		ListSupplierWithParam<Character> sizedListSupplier = ArrayList<Character>::new;
		List<Character> sizedList = sizedListSupplier.get(Arrays.asList('1', '2', '3'));
		sizedList.add('a');
		sizedList.add('b');
		sizedList.add('c');
		System.out.println(sizedList);
	}
	
}
