package ph.mramos.ocjp8.exception;

public class ThrowUncheckedAuto implements AutoCloseable {

	@Override
	public void close() {
		throw new RuntimeException("Error checked auto.");
	}

}
