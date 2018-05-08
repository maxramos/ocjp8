package ph.mramos.ocjp8.collections;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

public class CollectionFrameworkTest {

	private LocalTime start;
	private LocalTime end;

	@Before
	public void init() {
		// condition JVM
		Integer[] intArray = new Integer[12_000_000];
		for (int i = 0; i < 12_000_000 ; i++) {
			intArray[i] = i;
		}
	}

	@Test
	public void testList() {
		display("ArrayList.add(Integer)", computeAdd(new ArrayList<>()));
		display("LinkedList.add(Integer)", computeAdd(new LinkedList<>()));
		System.out.println();
		display("ArrayList.add(0, Integer)", computeAdd(new ArrayList<>(), 0));
		display("LinkedList.add(0, Integer)", computeAdd(new LinkedList<>(), 0));
		System.out.println();
		display("ArrayList.get(500_000)", computeGet(new ArrayList<>(), 1_500_000));
		display("LinkedList.get(500_000)", computeGet(new LinkedList<>(), 1_500_000));
		System.out.println();
		display("ArrayList.get(0)", computeGet(new ArrayList<>(), 0));
		display("LinkedList.get(0)", computeGet(new LinkedList<>(), 0));
	}

	@Test
	public void testSet() {
		display("HashSet.add(Integer)", computeAdd(new HashSet<>()));
		display("LinkedHashSet.add(Integer)", computeAdd(new LinkedHashSet<>()));
		display("TreeSet.add(Integer)", computeAdd(new TreeSet<>()));
		System.out.println();
		display("HashSet.contains(Integer)", computeContains(new HashSet<>()));
		display("LinkedHashSet.contains(Integer)", computeContains(new LinkedHashSet<>()));
		display("TreeSet.contains(Integer)", computeContains(new TreeSet<>()));
	}

	@Test
	public void testMap() {
		display("HashMap.put(Integer, Integer)", computeAdd(new HashMap<>()));
		display("LinkedHashMap.put(Integer, Integer)", computeAdd(new LinkedHashMap<>()));
		display("TreeMap.put(Integer, Integer)", computeAdd(new TreeMap<>()));
		System.out.println();
		display("HashMap.get(Integer)", computeGet(new HashMap<>()));
		display("LinkedHashMap.get(Integer)", computeGet(new LinkedHashMap<>()));
		display("TreeMap.get(Integer)", computeGet(new TreeMap<>()));
	}

	private void display(String label, long duration) {
		System.out.format("%s: %,d\n", label, duration);
	}

	private long computeAdd(List<Integer> list) {
		for (int i = 0; i < 100_000; i++) {
			list.add(i);
		}
		start = LocalTime.now();
		for (int i = 100_000; i < 600_000; i++) {
			list.add(i);
		}
		end = LocalTime.now();
		return ChronoUnit.NANOS.between(start, end);
	}

	private long computeAdd(List<Integer> list, int index) {
		for (int i = 0; i < 100_000; i++) {
			list.add(index, i);
		}
		start = LocalTime.now();
		for (int i = 100_000; i < 200_000; i++) {
			list.add(index, i);
		}
		end = LocalTime.now();
		return ChronoUnit.NANOS.between(start, end);
	}

	private long computeGet(List<Integer> list, int index) {
		for (int i = 0; i < 3_000_000; i++) {
			list.add(i);
		}
		start = LocalTime.now();
		list.get(0);
		list.get(index);
		end = LocalTime.now();
		return ChronoUnit.NANOS.between(start, end);
	}

	private long computeAdd(Set<Integer> set) {
		for (int i = 0; i < 100_000; i++) {
			set.add(i);
		}
		start = LocalTime.now();
		for (int i = 100_000; i < 6_100_000; i++) {
			set.add(i);
		}
		end = LocalTime.now();
		return ChronoUnit.NANOS.between(start, end);
	}

	private long computeContains(Set<Integer> set) {
		for (int i = 0; i <= 6_000_000; i++) {
			set.add(i);
		}
		start = LocalTime.now();
		set.contains(0);
		set.contains(6_000_000);
		end = LocalTime.now();
		return ChronoUnit.NANOS.between(start, end);
	}

	private long computeAdd(Map<Integer, Integer> map) {
		for (int i = 0; i <= 100_000; i++) {
			map.put(i, i);
		}
		start = LocalTime.now();
		for (int i = 100_000; i <= 6_100_000; i++) {
			map.put(i, i);
		}
		end = LocalTime.now();
		return ChronoUnit.NANOS.between(start, end);
	}

	private long computeGet(Map<Integer, Integer> map) {
		for (int i = 0; i <= 6_000_000; i++) {
			map.put(i, i);
		}
		start = LocalTime.now();
		map.get(0);
		map.get(6_000_000);
		end = LocalTime.now();
		return ChronoUnit.NANOS.between(start, end);
	}

}
