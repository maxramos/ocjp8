package ph.mramos.ocjp8.methodreference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionFactory<T> {

	public List<T> newList() {
		return new ArrayList<>();
	}
	
	public List<T> newList(Collection<T> collection) {
		return new ArrayList<>(collection);
	}
	
}
