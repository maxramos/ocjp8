package ph.mramos.ocjp8.collections;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
		Map<String, String> map = new LinkedHashMap<>();
		map.put("a", "aa");
		map.put("b", "bb");
		map.put("c", "cc");
		map.put("d", "dd");
		map.put("e", "ee");
		map.put("f", "ff");

		map.forEach((k, v) -> System.out.println(k + ":" + v));
	}

	@Test
	public void testMapReplaceAll() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("a", "aa");
		map.put("b", "bb");
		map.put("c", "cc");
		map.put("d", "dd");
		map.put("e", "ee");
		map.put("f", "ff");
		System.out.println(map);

		map.replaceAll((k, v) -> v.toUpperCase());
		System.out.println(map);
	}

	@Test
	public void testMapMerge() {
		System.out.println("1. [key:absent] [value:n/a] [function:null] [result:add key and set value to 2nd param]");
		Map<String, String> map = new LinkedHashMap<>();
		map.put("a", "aa");
		System.out.println(map);
		map.merge("b", "bb", (k, v) -> null);
		System.out.println(map);

		System.out.println("\n2. [key:absent] [value:n/a] [function:non-null] [result:add key and set value to 2nd param]");
		map = new LinkedHashMap<>();
		map.put("a", "aa");
		System.out.println(map);
		map.merge("b", "bb", (k, v) -> v.toUpperCase());
		System.out.println(map);

		System.out.println("\n3. [key:present] [value:null] [function:null] [result:update value to 2nd param]");
		map = new LinkedHashMap<>();
		map.put("a", null);
		System.out.println(map);
		map.merge("a", "aaa", (k, v) -> null);
		System.out.println(map);

		System.out.println("\n4. [key:present] [value:null] [function:non-null] [result:update value to 2nd param]");
		map = new LinkedHashMap<>();
		map.put("a", null);
		System.out.println(map);
		map.merge("a", "aaa", (k, v) -> v.toUpperCase());
		System.out.println(map);
		
		System.out.println("\n5. [key:present] [value:non-null] [function:null] [result:remove mapping]");
		map = new LinkedHashMap<>();
		map.put("a", "aa");
		System.out.println(map);
		map.merge("a", "aaa", (k, v) -> null);
		System.out.println(map);

		System.out.println("\n6. [key:present] [value:non-null] [function:non-null] [result:update value to function result]");
		map = new LinkedHashMap<>();
		map.put("a", "aa");
		System.out.println(map);
		map.merge("a", "aaa", (k, v) -> v.toUpperCase());
		System.out.println(map);
	}

	@Test
	public void testMapCompute() {
		System.out.println("1. [key:absent] [value:n/a] [function:null] [result:not executed]");
		Map<String, String> map = new LinkedHashMap<>();
		map.put("a", "aa");
		System.out.println(map);
		map.compute("b", (k, v) -> null);
		System.out.println(map);

		System.out.println("\n2. [key:absent] [value:n/a] [function:non-null] [result:add key and set value to function result]");
		map = new LinkedHashMap<>();
		map.put("a", "aa");
		System.out.println(map);
		map.compute("b", (k, v) -> k.toUpperCase());
		System.out.println(map);

		System.out.println("\n3. [key:present] [value:null] [function:null] [result:remove mapping]");
		map = new LinkedHashMap<>();
		map.put("a", null);
		System.out.println(map);
		map.compute("a", (k, v) -> null);
		System.out.println(map);

		System.out.println("\n4. [key:present] [value:null] [function:non-null] [result:update value to function result]");
		map = new LinkedHashMap<>();
		map.put("a", null);
		System.out.println(map);
		map.compute("a", (k, v) -> k.toUpperCase());
		System.out.println(map);
		
		System.out.println("\n5. [key:present] [value:non-null] [function:null] [result:remove mapping]");
		map = new LinkedHashMap<>();
		map.put("a", "aa");
		System.out.println(map);
		map.compute("a", (k, v) -> null);
		System.out.println(map);

		System.out.println("\n6. [key:present] [value:non-null] [function:non-null] [result:update value to function result]");
		map = new LinkedHashMap<>();
		map.put("a", "aa");
		System.out.println(map);
		map.compute("a", (k, v) -> v.toUpperCase());
		System.out.println(map);
	}

	@Test
	public void testMapComputeIfAbsent() {
		System.out.println("1. [key:absent] [value:n/a] [function:null] [result:not executed]");
		Map<String, String> map = new LinkedHashMap<>();
		map.put("a", "aa");
		System.out.println(map);
		map.computeIfAbsent("b", k -> null);
		System.out.println(map);

		System.out.println("\n2. [key:absent] [value:n/a] [function:non-null] [result:add key and set value to function result]");
		map = new LinkedHashMap<>();
		map.put("a", "aa");
		System.out.println(map);
		map.computeIfAbsent("b", k -> k.toUpperCase());
		System.out.println(map);

		System.out.println("\n3. [key:present] [value:null] [function:null] [result:not executed]");
		map = new LinkedHashMap<>();
		map.put("a", null);
		System.out.println(map);
		map.computeIfAbsent("a", k -> null);
		System.out.println(map);

		System.out.println("\n4. [key:present] [value:null] [function:non-null] [result:update value to function result]");
		map = new LinkedHashMap<>();
		map.put("a", null);
		System.out.println(map);
		map.computeIfAbsent("a", k -> k.toUpperCase());
		System.out.println(map);
		
		System.out.println("\n5. [key:present] [value:non-null] [function:null] [result:not executed]");
		map = new LinkedHashMap<>();
		map.put("a", "aa");
		System.out.println(map);
		map.computeIfAbsent("a", k -> null);
		System.out.println(map);

		System.out.println("\n6. [key:present] [value:non-null] [function:non-null] [result:not executed]");
		map = new LinkedHashMap<>();
		map.put("a", "aa");
		System.out.println(map);
		map.computeIfAbsent("a", k -> k.toUpperCase());
		System.out.println(map);
	}

	@Test
	public void testMapComputeIfPresent() {
		System.out.println("1. [key:absent] [value:n/a] [function:null] [result:not executed]");
		Map<String, String> map = new LinkedHashMap<>();
		map.put("a", "aa");
		System.out.println(map);
		map.computeIfPresent("b", (k, v) -> null);
		System.out.println(map);

		System.out.println("\n2. [key:absent] [value:n/a] [function:non-null] [result:not executed]");
		map = new LinkedHashMap<>();
		map.put("a", "aa");
		System.out.println(map);
		map.computeIfPresent("b", (k, v) -> v.toUpperCase());
		System.out.println(map);

		System.out.println("\n3. [key:present] [value:null] [function:null] [result:not executed]");
		map = new LinkedHashMap<>();
		map.put("a", null);
		System.out.println(map);
		map.computeIfPresent("a", (k, v) -> null);
		System.out.println(map);

		System.out.println("\n4. [key:present] [value:null] [function:non-null] [result:not executed]");
		map = new LinkedHashMap<>();
		map.put("a", null);
		System.out.println(map);
		map.computeIfPresent("a", (k, v) -> v.toUpperCase());
		System.out.println(map);
		
		System.out.println("\n5. [key:present] [value:non-null] [function:null] [result:remove mapping]");
		map = new LinkedHashMap<>();
		map.put("a", "aa");
		System.out.println(map);
		map.computeIfPresent("a", (k, v) -> null);
		System.out.println(map);

		System.out.println("\n6. [key:present] [value:non-null] [function:non-null] [result:update value to function result]");
		map = new LinkedHashMap<>();
		map.put("a", "aa");
		System.out.println(map);
		map.computeIfPresent("a", (k, v) -> v.toUpperCase());
		System.out.println(map);
	}

}
