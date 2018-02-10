package ph.mramos.ocjp8.io;

public class ClassB extends ClassA {

	private String name = "ClassBField"; // Order 1, executed first

	{
		name = "ClassBInitBlock"; // Order 2, executed second
	}

	public ClassB() {
		name = "ClassBConstructor"; // Order 3, executed third
	}

	@Override
	public String getName() {
		return name;
	}

}
