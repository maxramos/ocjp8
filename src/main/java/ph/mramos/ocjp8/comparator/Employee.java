package ph.mramos.ocjp8.comparator;

public class Employee implements Comparable<Employee> {

	private String firstName;
	private String lastName;
	private int ageYear;
	private int ageMonth;
	private long heightCm;
	private long weightKg;
	private double salary;
	private double bonus;
	
	public Employee(String firstName, String lastName, int ageYear, int ageMonth, long heightCm, long weightKg, double salary, double bonus) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ageYear = ageYear;
		this.ageMonth = ageMonth;
		this.heightCm = heightCm;
		this.weightKg = weightKg;
		this.salary = salary;
		this.bonus = bonus;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAgeYear() {
		return ageYear;
	}

	public void setAgeYear(int ageYear) {
		this.ageYear = ageYear;
	}

	public int getAgeMonth() {
		return ageMonth;
	}

	public void setAgeMonth(int ageMonth) {
		this.ageMonth = ageMonth;
	}

	public long getHeightCm() {
		return heightCm;
	}

	public void setHeightCm(long heightCm) {
		this.heightCm = heightCm;
	}

	public long getWeightKg() {
		return weightKg;
	}

	public void setWeightKg(long weightKg) {
		this.weightKg = weightKg;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return String.format("Emp [%s, %s, %s, %s, %s, %s, %s, %s]", firstName, lastName, ageYear, ageMonth, heightCm, weightKg, salary, bonus);
	}

	@Override
	public int compareTo(Employee o) {
		if (firstName == null && o.firstName == null) {
			return 0;
		}
		
		if (firstName == null) {
			return -1;
		}
		
		if (o.firstName == null) {
			return 1;
		}
		
		return firstName.compareTo(o.firstName);
	}
	
	

}
