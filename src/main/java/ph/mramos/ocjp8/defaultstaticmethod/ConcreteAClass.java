package ph.mramos.ocjp8.defaultstaticmethod;

public class ConcreteAClass implements ChildC {

	@Override
	public void someMethod() {
		System.out.println("ConcreteAClass.someMethod");
	}

	public static void someStaticMethod() {
		System.out.println("ConcreteAClass.someStaticMethod");
	}

}
