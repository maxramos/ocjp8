package ph.mramos.ocjp8.defaultstaticmethod;

import org.junit.Test;

public class DefaultStaticMethodTest {

	@Test
	public void testDefaultStaticMethod() {
		ParentA parentA1 = new ConcreteAClass();
		parentA1.someMethod();
		parentA1.someDefaultMethod();
		ParentA.someStaticMethod();
		
		System.out.println();
		
		ParentB parentB1 = new ConcreteAClass();
		parentB1.someMethod();
		parentB1.someDefaultMethod();
		ParentB.someStaticMethod();
		
		System.out.println();
		
		ChildC childC = new ConcreteAClass();
		childC.someMethod();
		childC.someDefaultMethod();
		ChildC.someStaticMethod();
		
		System.out.println();
		
		ConcreteAClass concreteAClass = new ConcreteAClass();
		concreteAClass.someMethod();
		concreteAClass.someDefaultMethod();
		concreteAClass.someStaticMethod();
		
		System.out.println();
		
		ParentA parentA2 = new ConcreteBClass();
		parentA2.someMethod();
		parentA2.someDefaultMethod();
		ParentA.someStaticMethod();
		
		System.out.println();
		
		ParentB parentB2 = new ConcreteBClass();
		parentB2.someMethod();
		parentB2.someDefaultMethod();
		ParentB.someStaticMethod();
		
		System.out.println();
		
		ConcreteBClass concreteBClass = new ConcreteBClass();
		concreteBClass.someMethod();
		concreteBClass.someDefaultMethod();
		concreteBClass.someStaticMethod();
	}

}
