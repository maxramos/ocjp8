package ph.mramos.ocjp8.exception;

public class ThrowCheckOrUncheckAuto implements AutoCloseable {

	private String message;

	public ThrowCheckOrUncheckAuto(String message) {
		this.message = message;
	}

	@Override
	public void close() {
		throw new RuntimeException(message);
	}

}
