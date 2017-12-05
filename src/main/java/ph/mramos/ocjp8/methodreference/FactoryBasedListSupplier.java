package ph.mramos.ocjp8.methodreference;

import java.util.List;

public interface FactoryBasedListSupplier<T> {

	List<T> get(CollectionFactory<T> factory);
	
}
