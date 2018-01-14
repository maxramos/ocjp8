package ph.mramos.ocjp8.exception;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import org.junit.Test;

public class ExceptionTest {

	@Test
	public void testCheckedAuto() {
		try (CheckedAuto ca = new CheckedAuto()) {
			System.out.println("Try");
		} catch (IOException e) {
			System.out.println("Catch");
			e.printStackTrace();
		} finally {
			System.out.println("Finally");
		}
	}
	
	@Test
	public void testUncheckedAuto() {
		try (UncheckedAuto ca = new UncheckedAuto()) {
			System.out.println("Try");
		} finally {
			System.out.println("Finally");
		}
	}
	
	@Test
	public void testThrowCheckedAuto() {
		try (ThrowCheckedAuto ca = new ThrowCheckedAuto()) {
			System.out.println("Try");
		} catch (IOException e) {
			System.out.println("Catch");
			e.printStackTrace();
		} finally {
			System.out.println("Finally");
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void testThrowUncheckedAuto() {
		try (ThrowUncheckedAuto ca = new ThrowUncheckedAuto()) {
			System.out.println("Try");
		} finally {
			System.out.println("Finally");
		}
	}
	
	@Test
	public void testSuppressed() {
		try (ThrowCheckedAuto ca = new ThrowCheckedAuto()) {
			System.out.println("Try");
			throw new ParseException("Error parse.", 0);
		} catch (IOException e) {
			System.out.println("Catch IOException");
			e.printStackTrace();
		} catch (ParseException e) {
			System.out.println("Catch ParseException");
			e.printStackTrace();
			Throwable[] throwables = e.getSuppressed();
			for (Throwable t : throwables) {
				t.printStackTrace();
			}
		} finally {
			System.out.println("Finally");
		}
	}
	
	@Test
	public void testMultiCatch() {
		int test = 3;
		
		try {
			switch (test) {
			case 0:
				throw new FileNotFoundException("Error file not found.");
			case 1:
				throw new IOException("Error io.");
			case 2:
				throw new ParseException("Error parse.", 0);
			case 3:
				throw new SQLException();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException | ParseException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test(expected = Exception.class)
	public void testExceptionDeclaration() throws IOException, ParseException, SQLException {
		int test = 3;
		
		try {
			switch (test) {
			case 0:
				throw new FileNotFoundException("Error file not found.");
			case 1:
				throw new IOException("Error io.");
			case 2:
				throw new ParseException("Error parse.", 0);
			case 3:
				throw new SQLException();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
}
