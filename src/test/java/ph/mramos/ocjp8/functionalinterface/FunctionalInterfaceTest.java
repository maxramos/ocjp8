package ph.mramos.ocjp8.functionalinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.junit.Test;

public class FunctionalInterfaceTest {

	@Test
	public void testSupplier() {
		Supplier<List<String>> supplier = ArrayList::new;
		List<String> list = supplier.get();
	}

}
