package ph.mramos.ocjp8.defaultstaticmethod;

public interface ParentC {

	void someMethod();

	default void someDefaultMethod3() {
		System.out.println("ParentC.someDefaultMethod");
	}

	static void someStaticMethod() {
		System.out.println("ParentC.someStaticMethod");
	}
	
}
