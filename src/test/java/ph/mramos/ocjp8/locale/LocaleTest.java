package ph.mramos.ocjp8.locale;

import java.util.Locale;

import org.junit.Test;

public class LocaleTest {

	@Test
	public void testCreation() {
		Locale locale = Locale.getDefault();
		System.out.println(locale);
	}
	
}
