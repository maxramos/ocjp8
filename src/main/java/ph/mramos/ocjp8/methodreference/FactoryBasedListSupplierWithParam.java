package ph.mramos.ocjp8.methodreference;

import java.util.Collection;
import java.util.List;

public interface FactoryBasedListSupplierWithParam<T> {
	
	List<T> get(CollectionFactory<T> factory, Collection<T> collection);

}
