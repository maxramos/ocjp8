package ph.mramos.ocjp8.methodreference;

import java.util.Collection;
import java.util.List;

public interface ListSupplierWithParam<T> {

	List<T> get(Collection<T> collection);
	
}
