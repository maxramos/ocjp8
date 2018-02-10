package ph.mramos.ocjp8.io;

public class ClassA {

	private String name = "ClassAField";

	{
		name = "ClassAInitBlock";
	}

	public ClassA() {
		name = "ClassAConstructor";
	}

	public String getName() {
		return name;
	}

}
