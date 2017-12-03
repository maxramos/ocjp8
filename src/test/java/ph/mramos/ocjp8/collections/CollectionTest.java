package ph.mramos.ocjp8.collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class CollectionTest {

	@Test
	public void testList() {
		String[] array = {"a", "b"};
		List<String> list = Arrays.asList(array);
	}
	
	@Test
	public void testMap() {
		Map<String, String> hashMap = new HashMap<>();
		System.out.println("*** putIfAbsent ***");
		hashMap.put("hasValue", "Put Value");
		hashMap.put("hasNoValue", null);
		hashMap.put("delete", "For Deletion");
		System.out.println("Size: " + hashMap.size());
		System.out.println(hashMap);
		hashMap.putIfAbsent("absent", "Absent Value 1");
		hashMap.putIfAbsent("hasNoValue", "Absent Value 2");
		hashMap.putIfAbsent("hasValue", "Absent Value 3");
		hashMap.putIfAbsent("delete", null);
		System.out.println("Size: " + hashMap.size());
		System.out.println(hashMap);
		System.out.println();
		hashMap.clear();
		
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
