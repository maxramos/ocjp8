package ph.mramos.ocjp8.defaultstaticmethod;

public class ConcreteBClass implements ParentA, ParentB {

	@Override
	public void someMethod() {
		System.out.println("ConcreteBClass.someMethod");
	}

	@Override
	public void someDefaultMethod() {
		System.out.println("ConcreteBClass.someDefaultMethod");
	}
	
	public static void someStaticMethod() {
		System.out.println("ConcreteBClass.someStaticMethod");
	}
	
//	public void someStaticMethod() {
//		System.out.println("ConcreteBClass.someStaticMethod");
//	}

}
