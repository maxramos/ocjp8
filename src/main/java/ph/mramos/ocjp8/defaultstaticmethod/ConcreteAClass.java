package ph.mramos.ocjp8.defaultstaticmethod;

public class ConcreteAClass extends AbstractChild implements ParentC {

	@Override
	public void someMethod() {
		System.out.println("ConcreteAClass.someMethod");
	}
	
	@Override
	public void someDefaultMethod2() {
		super.someDefaultMethod2();
	}
	
	@Override
	public void someDefaultMethod3() {
		ParentC.super.someDefaultMethod3();
	}

}
