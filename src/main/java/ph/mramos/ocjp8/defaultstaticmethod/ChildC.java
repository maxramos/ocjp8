package ph.mramos.ocjp8.defaultstaticmethod;

public interface ChildC extends ParentA, ParentB {

	@Override
	default void someDefaultMethod() {
		System.out.println("ChildC.someDefaultMethod");
	}
	
	default void someDefaultMethodA() {
		ParentA.super.someDefaultMethod();
	}
	
	default void someDefaultMethodB() {
		ParentB.super.someDefaultMethod();
	}

	static void someStaticMethod() {
		System.out.println("ChildC.someStaticMethod");
	}

}
