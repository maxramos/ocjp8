package ph.mramos.ocjp8.exception;

public class UncheckedAuto implements AutoCloseable {

	@Override
	public void close() {		
		System.out.println("UncheckedAuto");
	}

}
