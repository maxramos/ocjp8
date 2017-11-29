package ph.mramos.ocjp8.defaultstaticmethod;

public interface ParentB {

	void someMethod();

	default void someDefaultMethod() {
		System.out.println("ParentB.someDefaultMethod");
	}

	static void someStaticMethod() {
		System.out.println("ParentB.someStaticMethod");
	}

}
