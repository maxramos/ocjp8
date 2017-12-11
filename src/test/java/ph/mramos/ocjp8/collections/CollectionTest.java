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
		System.out.println("1. Will be executed, (k)ey not in map and function result is null; add (k)ey and set 2nd param as (v)alue");
		Map<String, String> map = new LinkedHashMap<>();
		map.put("a", "aa");
		System.out.println(map);
		map.merge("b", "bb", (k, v) -> null);
		System.out.println(map);

		System.out.println("\n2. Will be executed, (k)ey not in map and function result is NOT null; add (k)ey and 2nd param as (v)alue");
		map = new LinkedHashMap<>();
		map.put("a", "aa");
		System.out.println(map);
		map.merge("b", "bb", (k, v) -> v.toUpperCase());
		System.out.println(map);

		System.out.println("\n3. Will be executed, (k)ey exists and has (v)alue; remove mapping cause function result is null");
		map = new LinkedHashMap<>();
		map.put("a", "aa");
		System.out.println(map);
		map.merge("a", "aaa", (k, v) -> null);
		System.out.println(map);

		System.out.println("\n4. Will be executed, (k)ey exists and has (v)alue; update (v)alue to function result");
		map = new LinkedHashMap<>();
		map.put("a", "aa");
		System.out.println(map);
		map.merge("a", "aaa", (k, v) -> v.toUpperCase());
		System.out.println(map);

		System.out.println("\n5. Will be executed, (k)ey exists and has null (v)alue; update (v)alue to 2nd param");
		map = new LinkedHashMap<>();
		map.put("a", null);
		System.out.println(map);
		map.merge("a", "aaa", (k, v) -> null);
		System.out.println(map);

		System.out.println("\n6. Will be executed, (k)ey exists and has null (v)alue; update (v)alue to 2nd param");
		map = new LinkedHashMap<>();
		map.put("a", null);
		System.out.println(map);
		map.merge("a", "aaa", (k, v) -> v.toUpperCase());
		System.out.println(map);
	}

	@Test
	public void testMapCompute() {
		System.out.println("1. Will NOT be executed, (k)ey not in map and function result is null");
		Map<String, String> map = new LinkedHashMap<>();
		map.put("a", "aa");
		System.out.println(map);
		map.compute("b", (k, v) -> null);
		System.out.println(map);

		System.out.println("\n2. Will be executed, (k)ey not in map; add (k)ey and set (v)alue to function result");
		map = new LinkedHashMap<>();
		map.put("a", "aa");
		System.out.println(map);
		map.compute("b", (k, v) -> k.toUpperCase());
		System.out.println(map);

		System.out.println("\n3. Will be executed, (k)ey exists and has (v)alue; remove mapping cause function result is null");
		map = new LinkedHashMap<>();
		map.put("a", "aa");
		System.out.println(map);
		map.compute("a", (k, v) -> null);
		System.out.println(map);

		System.out.println("\n4. Will be executed, (k)ey exists and has (v)alue; update (v)alue to function result");
		map = new LinkedHashMap<>();
		map.put("a", "aa");
		System.out.println(map);
		map.compute("a", (k, v) -> v.toUpperCase());
		System.out.println(map);

		System.out.println("\n5. Will be executed, (k)ey exists and null (v)alue; remove mapping cause function result is null");
		map = new LinkedHashMap<>();
		map.put("a", null);
		System.out.println(map);
		map.compute("a", (k, v) -> null);
		System.out.println(map);

		System.out.println("\n6. Will be executed, (k)ey exists and null (v)alue; update (v)alue to function result");
		map = new LinkedHashMap<>();
		map.put("a", null);
		System.out.println(map);
		map.compute("a", (k, v) -> k.toUpperCase());
		System.out.println(map);
	}

	@Test
	public void testMapComputeIfAbsent() {
		System.out.println("1. Will NOT be executed, though (k)ey not in map but function result is null");
		Map<String, String> map = new LinkedHashMap<>();
		map.put("a", "aa");
		System.out.println(map);
		map.computeIfAbsent("b", k -> null);
		System.out.println(map);

		System.out.println("\n2. Will be executed, (k)ey not in map; add (k)ey and set (v)alue to function result");
		map = new LinkedHashMap<>();
		map.put("a", "aa");
		System.out.println(map);
		map.computeIfAbsent("b", k -> k.toUpperCase());
		System.out.println(map);

		System.out.println("\n3. Will NOT be executed, (k)ey exists and has (v)alue");
		map = new LinkedHashMap<>();
		map.put("a", "aa");
		System.out.println(map);
		map.computeIfAbsent("a", k -> null);
		System.out.println(map);

		System.out.println("\n4. Will NOT be executed, (k)ey exists and has (v)alue");
		map = new LinkedHashMap<>();
		map.put("a", "aa");
		System.out.println(map);
		map.computeIfAbsent("a", k -> k.toUpperCase());
		System.out.println(map);

		System.out.println("\n5. Will NOT be executed, though null (v)alue but function result is null");
		map = new LinkedHashMap<>();
		map.put("a", null);
		System.out.println(map);
		map.computeIfAbsent("a", k -> null);
		System.out.println(map);

		System.out.println("\n6. Will be executed, null (v)alue; update (v)alue to function result");
		map = new LinkedHashMap<>();
		map.put("a", null);
		System.out.println(map);
		map.computeIfAbsent("a", k -> k.toUpperCase());
		System.out.println(map);
	}

	@Test
	public void testMapComputeIfPresent() {
		System.out.println("1. Will NOT be executed, (k)ey not in map");
		Map<String, String> map = new LinkedHashMap<>();
		map.put("a", "aa");
		System.out.println(map);
		map.computeIfPresent("b", (k, v) -> null);
		System.out.println(map);

		System.out.println("\n2. Will NOT be executed, (k)ey not in map");
		map = new LinkedHashMap<>();
		map.put("a", "aa");
		System.out.println(map);
		map.computeIfPresent("b", (k, v) -> v.toUpperCase());
		System.out.println(map);

		System.out.println("\n3. Will be executed, (k)ey exists and has (v)alue; remove mapping cause function result is null");
		map = new LinkedHashMap<>();
		map.put("a", "aa");
		System.out.println(map);
		map.computeIfPresent("a", (k, v) -> null);
		System.out.println(map);

		System.out.println("\n4. Will be executed, (k)ey exists and has (v)alue; update (v)alue to function result");
		map = new LinkedHashMap<>();
		map.put("a", "aa");
		System.out.println(map);
		map.computeIfPresent("a", (k, v) -> v.toUpperCase());
		System.out.println(map);

		System.out.println("\n5. Will NOT be executed, null (v)alue");
		map = new LinkedHashMap<>();
		map.put("a", null);
		System.out.println(map);
		map.computeIfPresent("a", (k, v) -> null);
		System.out.println(map);

		System.out.println("\n6. will NOT be executed, null (v)alue");
		map = new LinkedHashMap<>();
		map.put("a", null);
		System.out.println(map);
		map.computeIfPresent("a", (k, v) -> v.toUpperCase());
		System.out.println(map);
	}

}
