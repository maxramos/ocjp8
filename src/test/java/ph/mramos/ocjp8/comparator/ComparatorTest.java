package ph.mramos.ocjp8.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class ComparatorTest {

	@Test
	public void testComparator() {
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("Toyota", "Vios"));
		cars.add(new Car("Toyota", "Corolla"));
		cars.add(new Car("Hyundai", "Accent"));
		cars.add(new Car("Hyundai", "Elantra"));
				
		cars.sort((c1, c2) -> Comparator.comparing((Car c) -> c.getBrand()).thenComparing(c -> c.getModel()).compare(c1, c2));
		
		System.out.println(cars);
	}
	
}
