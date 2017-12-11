package ph.mramos.ocjp8.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.junit.Test;

public class CollectionTest {

	@Test
	public void testIterableForEach() {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("bb");
		list.add("ccc");
		list.add("dddd");
		list.add("eeeee");
		list.add("ffffff");

		list.forEach(System.out::println);
	}
	
	@Test
	public void testCollectionRemoveIf() {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("bb");
		list.add("ccc");
		list.add("dddd");
		list.add("eeeee");
		list.add("ffffff");
		System.out.println(list);
		
		list.removeIf(e -> e.length() <= 3);
		System.out.println(list);
	}
	
	@Test
	public void testListReplaceAll() {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("bb");
		list.add("ccc");
		list.add("dddd");
		list.add("eeeee");
		list.add("ffffff");
		System.out.println(list);
		
		list.replaceAll(String::toUpperCase);
		System.out.println(list);
	}
	
	@Test
	public void testListSort() {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("bb");
		list.add("ccc");
		list.add("dddd");
		list.add("eeeee");
		list.add("ffffff");
		System.out.println(list);
		
		list.sort((a, b) -> b.compareTo(a));
		System.out.println(list);
	}
	
	@Test
	public void testMapForEach() {
		Map<String, String> map = new HashMap<>();
		map.put("a", "a");
		map.put("bb", "bb");
		map.put("ccc", "ccc");
		map.put("dddd", "dddd");
		map.put("eeeee", "eeeee");
		map.put("ffffff", "ffffff");
		
		map.forEach((k, v) -> System.out.println(k + ":" + v));
	}
	
	@Test
	public void testMapReplaceAll() {
		Map<String, String> map = new HashMap<>();
		map.put("a", "a");
		map.put("bb", "bb");
		map.put("ccc", "ccc");
		map.put("dddd", "dddd");
		map.put("eeeee", "eeeee");
		map.put("ffffff", "ffffff");
		System.out.println(map);
		
		map.replaceAll((k, v) -> v.toUpperCase());
		System.out.println(map);
	}
	
	@Test
	public void testMap() {
		Map<String, String> hashMap = new HashMap<>();
		
		System.out.println("*** merge ***");
		hashMap.put("hasValue", "Put Value");
		hashMap.put("hasNoValue", null);
		hashMap.put("delete", "For Deletion");
		System.out.println("Size: " + hashMap.size());
		System.out.println(hashMap);
		hashMap.merge("merge", "Merge Value 1", (x,y) -> x + "/" + y);
		hashMap.merge("hasNoValue", "Merge Value 2", (x,y) -> x + "/" + y);
		hashMap.merge("hasValue", "Merge Value 3", (x,y) -> x + "/" + y); // x = old value, y = new value
		hashMap.merge("delete", "Merge Value 4", (x,y) -> null);
		hashMap.merge("notInMap", "Merge Value 5", (x,y) -> null); // Tricky: key not in map and mapping result to null. Result: add key to map.
		System.out.println("Size: " + hashMap.size());
		System.out.println(hashMap);
		System.out.println();
		hashMap.clear();
		
		System.out.println("*** compute ***");
		hashMap.put("hasValue", "Put Value");
		hashMap.put("hasNoValue", null);
		hashMap.put("delete", "For Deletion");
		System.out.println("Size: " + hashMap.size());
		System.out.println(hashMap);
		hashMap.compute("compute", (x,y) -> x + "/" + y);
		hashMap.compute("hasNoValue", (x,y) -> x + "/" + y);
		hashMap.compute("hasValue", (x,y) -> x + "/" + y); // x = key, y = old value
		hashMap.compute("delete", (x,y) -> null);
		System.out.println("Size: " + hashMap.size());
		System.out.println(hashMap);
		System.out.println();
		hashMap.clear();
		
		System.out.println("*** computeIfAbsent ***");
		hashMap.put("hasValue", "Put Value");
		hashMap.put("hasNoValue", null);
		hashMap.put("delete", "For Deletion");
		System.out.println("Size: " + hashMap.size());
		System.out.println(hashMap);
		hashMap.computeIfAbsent("computeAbsent", x -> x);
		hashMap.computeIfAbsent("hasNoValue", x -> x);
		hashMap.computeIfAbsent("hasValue", x -> x); // x = key
		hashMap.computeIfAbsent("delete", x -> null);
		hashMap.computeIfAbsent("notInMap", x -> null); // Tricky: key not in map and mapping result to null. Result: do not change map.
		System.out.println("Size: " + hashMap.size());
		System.out.println(hashMap);
		System.out.println();
		hashMap.clear();
		
		System.out.println("*** computeIfPresent ***");
		hashMap.put("hasValue", "Put Value");
		hashMap.put("hasNoValue", null);
		hashMap.put("delete", "For Deletion");
		System.out.println("Size: " + hashMap.size());
		System.out.println(hashMap);
		hashMap.computeIfPresent("computePresent", (x,y) -> x + "/" + y);
		hashMap.computeIfPresent("hasNoValue", (x,y) -> x + "/" + y);
		hashMap.computeIfPresent("hasValue", (x,y) -> x + "/" + y); // x = key, y = old value
		hashMap.computeIfPresent("delete", (x,y) -> null);
		System.out.println("Size: " + hashMap.size());
		System.out.println(hashMap);
		System.out.println();
		hashMap.clear();
	}
	
}
