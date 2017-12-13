package ph.mramos.ocjp8.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class ComparatorTest {

	@Test
	public void testComparator1() {
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("Toyota", "Vios"));
		cars.add(new Car("Toyota", "Corolla"));
		cars.add(new Car("Hyundai", "Accent"));
		cars.add(new Car("Hyundai", "Elantra"));
				
		Comparator<Car> comparator = Comparator.comparing(Car::getBrand).thenComparing(Car::getModel);
		cars.sort(comparator);
		System.out.println(cars);
	}
	
	@Test
	public void testComparator2() {
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("Toyota", "Vios"));
		cars.add(new Car("Toyota", "Corolla"));
		cars.add(new Car("Hyundai", "Accent"));
		cars.add(new Car("Hyundai", "Elantra"));
		
		Comparator<Car> comparator = Comparator.comparing(Car::getBrand, (x, y) -> x.length() - y.length());
		cars.sort(comparator);
		System.out.println(cars);
	}
	
}
