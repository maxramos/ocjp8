package ph.mramos.ocjp8.exception;

import java.io.IOException;

public class CheckedAuto implements AutoCloseable {

	@Override
	public void close() throws IOException {
		System.out.println("CheckedAuto");
	}

}
