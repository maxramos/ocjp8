package ph.mramos.ocjp8.exception;

import java.io.IOException;

public class ThrowCheckedAuto implements AutoCloseable {

	@Override
	public void close() throws IOException {
		throw new IOException("Error checked auto.");
	}

}
