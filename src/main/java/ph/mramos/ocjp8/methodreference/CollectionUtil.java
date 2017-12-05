package ph.mramos.ocjp8.methodreference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionUtil {

	public static <T> List<T> newList() {
		return new ArrayList<>();
	}
	
	public static <T> List<T> newList(Collection<T> collection) {
		return new ArrayList<>(collection);
	}
	
}
