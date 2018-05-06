package ph.mramos.ocjp8.datetime;

import java.time.Duration;
import java.time.Period;

import org.junit.Test;

public class PeriodDurationTest {

	@Test
	public void testPeriodPrinting() {
		System.out.println(Period.ofDays(32));
		System.out.println(Period.ofMonths(13));
		System.out.println(Period.ofYears(2018));
	}

	@Test
	public void testDurationPrinting() {
		System.out.println(Duration.ofSeconds(61));
		System.out.println(Duration.ofMinutes(61));
		System.out.println(Duration.ofHours(25));
	}

}
