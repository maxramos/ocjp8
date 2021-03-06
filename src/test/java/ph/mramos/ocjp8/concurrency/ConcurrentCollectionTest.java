package ph.mramos.ocjp8.concurrency;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

import org.junit.Test;

public class ConcurrentCollectionTest {

	@Test
	public void testIteration() {
		List<Integer> l1 = Arrays.asList(1,2,3);
		List<Integer> l2 = new CopyOnWriteArrayList<>(l1);
		Set<Integer> s3 = new ConcurrentSkipListSet<>();
		s3.addAll(l1);
		for(Integer item: l2) {
			System.out.println("CopyOnWriteArrayList: " + item);
			l2.add(4);
		}
		for(Integer item: s3) {
			System.out.println("ConcurrentSkipListSet: " + item);
			s3.add(5);
		}
		System.out.println(l1.size()+" "+l2.size()+" "+s3.size());
	}
	
	@Test
	public void testCopyOnWriteArraySet() {
		Set<String> set1 = new CopyOnWriteArraySet<>();
		set1.add("c");
		set1.add("b");
		set1.add("a");
		System.out.println(set1);
		
		Set<String> set2 = new HashSet<>();
		set2.add("c");
		set2.add("b");
		set2.add("a");
		System.out.println(set2);
	}

}
