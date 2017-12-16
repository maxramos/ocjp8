package ph.mramos.ocjp8.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ComparatorTest {

	private List<Employee> employees;
	
	@Before
	public void init() {
		employees = new ArrayList<>();
		employees.add(new Employee("first" + 3, "last" + 3, 20 + 3, 240 + (12 * 3), 150 + (2 * 3), 50 + (2 * 3), 20_000 * 3, 10_000 * 3));
		employees.add(new Employee("first" + 5, "last" + 5, 20 + 5, 240 + (12 * 5), 150 + (2 * 5), 50 + (2 * 5), 20_000 * 5, 10_000 * 5));
		employees.add(new Employee("first" + 4, "last" + 4, 20 + 4, 240 + (12 * 4), 150 + (2 * 4), 50 + (2 * 4), 20_000 * 4, 10_000 * 4));
		employees.add(new Employee("first" + 1, "last" + 1, 20 + 1, 240 + (12 * 1), 150 + (2 * 1), 50 + (2 * 1), 20_000 * 1, 10_000 * 1));
		employees.add(new Employee("first" + 2, "last" + 2, 20 + 2, 240 + (12 * 2), 150 + (2 * 2), 50 + (2 * 2), 20_000 * 2, 10_000 * 2));
	}
	
	@Test
	public void testComparing() {
		Comparator<Employee> comparator1 = Comparator.comparing(Employee::getFirstName);
		System.out.println(employees);
		employees.sort(comparator1);
		System.out.println(employees);
		
		init();
		System.out.println();
		
		Comparator<Employee> comparator2 = Comparator.comparing(Employee::getLastName, Comparator.reverseOrder());
		System.out.println(employees);
		employees.sort(comparator2);
		System.out.println(employees);
		
		init();
		System.out.println();
		
		Comparator<Employee> comparator3 = Comparator.comparingInt(Employee::getAgeYear);
		System.out.println(employees);
		employees.sort(comparator3);
		System.out.println(employees);
		
		init();
		System.out.println();
		
		Comparator<Employee> comparator4 = Comparator.comparingLong(Employee::getWeightKg);
		System.out.println(employees);
		employees.sort(comparator4);
		System.out.println(employees);
		
		init();
		System.out.println();
		
		Comparator<Employee> comparator5 = Comparator.comparingDouble(Employee::getSalary);
		System.out.println(employees);
		employees.sort(comparator5);
		System.out.println(employees);
	}
	
	@Test
	public void testOrder() {
		Comparator<Employee> comparator1 = Comparator.naturalOrder();
		System.out.println(employees);
		employees.sort(comparator1);
		System.out.println(employees);
		
		init();
		System.out.println();
		
		Comparator<Employee> comparator2 = Comparator.reverseOrder();
		System.out.println(employees);
		employees.sort(comparator2);
		System.out.println(employees);
		
		init();
		System.out.println();
		
		Comparator<Employee> comparator3 = Comparator.nullsFirst(Comparator.naturalOrder()); // should be used when there's a null element
		employees.add(null);
		System.out.println(employees);
		employees.sort(comparator3);
		System.out.println(employees);
		
		init();
		System.out.println();
		
		Comparator<Employee> comparator4 = Comparator.nullsLast(Comparator.naturalOrder()); // should be used when there's a null element
		employees.add(null);
		System.out.println(employees);
		employees.sort(comparator4);
		System.out.println(employees);
		
		init();
		System.out.println();
		
		Comparator<Employee> comparator5 = Comparator.reverseOrder();
		comparator5 = comparator5.reversed();
		System.out.println(employees);
		employees.sort(comparator5);
		System.out.println(employees);
	}
	
	@Test
	public void testThenComparing() {
		Comparator<Employee> comparator1 = Comparator.comparing(Employee::getFirstName).thenComparing(Comparator.reverseOrder());
		System.out.println(employees);
		employees.sort(comparator1);
		System.out.println(employees);
		
		init();
		System.out.println();
		
		Comparator<Employee> comparator2 = Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getLastName);
		System.out.println(employees);
		employees.sort(comparator2);
		System.out.println(employees);
		
		init();
		System.out.println();
		
		Comparator<Employee> comparator3 = Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getLastName, Comparator.reverseOrder());
		System.out.println(employees);
		employees.sort(comparator3);
		System.out.println(employees);
		
		init();
		System.out.println();
		
		Comparator<Employee> comparator4 = Comparator.comparingInt(Employee::getAgeYear).thenComparingInt(Employee::getAgeMonth);
		System.out.println(employees);
		employees.sort(comparator4);
		System.out.println(employees);
		
		init();
		System.out.println();
		
		Comparator<Employee> comparator5 = Comparator.comparingLong(Employee::getWeightKg).thenComparingLong(Employee::getHeightCm);
		System.out.println(employees);
		employees.sort(comparator5);
		System.out.println(employees);
		
		init();
		System.out.println();
		
		Comparator<Employee> comparator6 = Comparator.comparingDouble(Employee::getSalary).thenComparingDouble(Employee::getBonus);
		System.out.println(employees);
		employees.sort(comparator6);
		System.out.println(employees);
	}
	
}
