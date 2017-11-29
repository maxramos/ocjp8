package ph.mramos.ocjp8.defaultstaticmethod;

public interface ChildC extends ParentA, ParentB {

	@Override
	default void someDefaultMethod() {
		System.out.println("ChildC.someDefaultMethod");
	}

	static void someStaticMethod() {
		System.out.println("ChildC.someStaticMethod");
	}

}
