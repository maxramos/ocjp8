package ph.mramos.ocjp8.defaultstaticmethod;

public interface ParentA {

	void someMethod();

	default void someDefaultMethod() {
		System.out.println("ParentA.someDefaultMethod");
	}

	static void someStaticMethod() {
		System.out.println("ParentA.someStaticMethod");
	}

}
