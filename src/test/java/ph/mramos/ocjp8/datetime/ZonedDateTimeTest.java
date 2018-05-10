package ph.mramos.ocjp8.datetime;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalQueries;

import org.junit.Test;

public class ZonedDateTimeTest {

	@Test
	public void testCreation() {
		System.out.println(ZonedDateTime.from(ZonedDateTime.now()));
		System.out.println(ZonedDateTime.now());
		System.out.println(ZonedDateTime.now(ZoneId.of("US/Mountain")));

		// No constructor with Month parameter, use the integer counterpart of month
		System.out.println(ZonedDateTime.of(2017, 12, 25, 23, 59, 59, 0, ZoneId.of("US/Mountain")));
		System.out.println(ZonedDateTime.of(LocalDate.now(), LocalTime.now(), ZoneId.of("US/Mountain")));
		System.out.println(ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("US/Mountain")));
		System.out.println(ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("US/Mountain")));
		System.out.println(ZonedDateTime.parse("2017-12-25T23:59:59-07:00[US/Mountain]"));
		System.out.println(ZonedDateTime.parse("Dec 25, 2017 23-59-59 -07:00 [US/Mountain]", DateTimeFormatter.ofPattern("MMM dd, yyyy HH-mm-ss ZZZZZ '['VV']'")));
	}

	@Test
	public void testComparison() {
		ZonedDateTime ldt1 = ZonedDateTime.of(2017, 11, 1, 23, 59, 59, 0, ZoneId.of("US/Mountain"));
		ZonedDateTime ldt2 = ZonedDateTime.of(2017, 12, 1, 23, 59, 59, 0, ZoneId.of("US/Mountain"));
		ZonedDateTime ldt3 = ZonedDateTime.of(2017, 12, 1, 23, 59, 59, 0, ZoneId.of("US/Mountain"));

		System.out.println(ldt1.compareTo(ldt2));
		System.out.println(ldt2.equals(ldt3));
		System.out.println(ldt2.isAfter(ldt1));
		System.out.println(ldt1.isBefore(ldt2));
		System.out.println(ldt2.isEqual(ldt3));
	}

	@Test
	public void testFormat() {
		System.out.println(ZonedDateTime.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy HH-mm-ss ZZZZZ '['VV']'")));
	}

	@Test
	public void testGet() {
		ZonedDateTime zdt = ZonedDateTime.now();
		System.out.println("DateTime: " + zdt);
		System.out.println("get(ChronoField): " + zdt.get(ChronoField.MONTH_OF_YEAR));
		System.out.println("getDayOfMonth: " + zdt.getDayOfMonth());
		System.out.println("getDayOfWeek: " + zdt.getDayOfWeek());
		System.out.println("getDayOfYear: " + zdt.getDayOfYear());
		System.out.println("getLong(ChronoField): " + zdt.getLong(ChronoField.MONTH_OF_YEAR));
		System.out.println("getMonth: " + zdt.getMonth());
		System.out.println("getMonthValue: " + zdt.getMonthValue());
		System.out.println("getYear: " + zdt.getYear());
		System.out.println("getHour: " + zdt.getHour());
		System.out.println("getMinute: " + zdt.getMinute());
		System.out.println("getNano: " + zdt.getNano());
		System.out.println("getSecond: " + zdt.getSecond());
		System.out.println("Offset: " + zdt.getOffset());
		System.out.println("Zone: " + zdt.getZone());
	}

	@Test
	public void testPredicate() {
		ZonedDateTime zdt = ZonedDateTime.now();
		System.out.println(zdt.isSupported(ChronoField.MONTH_OF_YEAR));
		System.out.println(zdt.isSupported(ChronoUnit.MONTHS));
		System.out.println(zdt.isSupported(ChronoField.HOUR_OF_DAY));
		System.out.println(zdt.isSupported(ChronoUnit.HOURS));
	}

	@Test
	public void testPlus() {
		ZonedDateTime zdt = ZonedDateTime.of(2017, 11, 1, 23, 59, 59, 0, ZoneId.of("US/Mountain"));
		System.out.println("LocalDate: " + zdt);
		System.out.println("plusYears: " + zdt.plusYears(1));
		System.out.println("plusMonths: " + zdt.plusMonths(1));
		System.out.println("plusWeeks: " + zdt.plusWeeks(1));
		System.out.println("plusDays: " + zdt.plusDays(1));
		System.out.println("plus (ChronoUnit.DAYS): " + zdt.plus(1, ChronoUnit.DAYS));
		System.out.println("plus (Period): " + zdt.plus(Period.ofYears(5)));

		System.out.println("plusHours: " + zdt.plusHours(1));
		System.out.println("plusMinutes: " + zdt.plusMinutes(1));
		System.out.println("plusSeconds: " + zdt.plusSeconds(1));
		System.out.println("plusNanos: " + zdt.plusNanos(1));
		System.out.println("plus (ChronoUnit.HOURS): " + zdt.plus(1, ChronoUnit.HOURS));
		System.out.println("plus (Duration): " + zdt.plus(Duration.ofHours(1)));
	}

	@Test
	public void testMinus() {
		ZonedDateTime zdt = ZonedDateTime.of(2017, 11, 1, 23, 59, 59, 0, ZoneId.of("US/Mountain"));
		System.out.println("minusYears: " + zdt.minusYears(1));
		System.out.println("minusMonths: " + zdt.minusMonths(1));
		System.out.println("minusWeeks: " + zdt.minusWeeks(1));
		System.out.println("minusDays: " + zdt.minusDays(1));
		System.out.println("minus (ChronoUnit.DAYS): " + zdt.minus(1, ChronoUnit.DAYS));
		System.out.println("minus (Period): " + zdt.minus(Period.ofYears(5)));

		System.out.println("minusHours: " + zdt.minusHours(1));
		System.out.println("minusMinutes: " + zdt.minusMinutes(1));
		System.out.println("minusSeconds: " + zdt.minusSeconds(1));
		System.out.println("minusNanos: " + zdt.minusNanos(1));
		System.out.println("minus (ChronoUnit.HOURS): " + zdt.minus(1, ChronoUnit.HOURS));
		System.out.println("minus (Duration): " + zdt.minus(Duration.ofHours(1)));
	}

	@Test
	public void testQuery() {
		ZonedDateTime zdt = ZonedDateTime.now();
		System.out.println(zdt.query(TemporalQueries.localDate()));
		System.out.println(zdt.query(TemporalQueries.localTime()));
		System.out.println(zdt.query(TemporalQueries.zoneId()));
		System.out.println(zdt.query(TemporalQueries.offset()));
	}

	@Test
	public void testRange() {
		ZonedDateTime zdt = ZonedDateTime.now();
		System.out.println(zdt.range(ChronoField.MONTH_OF_YEAR));
		System.out.println(zdt.range(ChronoField.DAY_OF_WEEK));
		System.out.println(zdt.range(ChronoField.HOUR_OF_DAY));
		System.out.println(zdt.range(ChronoField.HOUR_OF_AMPM));
	}

	@Test
	public void testToObj() {
		System.out.println(ZonedDateTime.now().toLocalDate());
		System.out.println(ZonedDateTime.now().toLocalTime());
		System.out.println(ZonedDateTime.now().toLocalDateTime());
		System.out.println(ZonedDateTime.now().toOffsetDateTime());
		System.out.println(ZonedDateTime.now().toInstant());
	}

	@Test
	public void testTruncatedTo() {
		System.out.println(ZonedDateTime.now().truncatedTo(ChronoUnit.DAYS));
		System.out.println(ZonedDateTime.now().truncatedTo(ChronoUnit.HOURS));
	}

	@Test
	public void testUntil() {
		ZonedDateTime start = ZonedDateTime.of(2017, 11, 25, 23, 59, 59, 0, ZoneId.of("US/Mountain"));
		long length1 = start.until(ZonedDateTime.now(), ChronoUnit.DAYS);
		System.out.println(length1);

		long length2 = start.until(ZonedDateTime.now(), ChronoUnit.HOURS);
		System.out.println(length2);
	}

	@Test
	public void testWith() {
		System.out.println(ZonedDateTime.now().with(DayOfWeek.MONDAY));
		System.out.println(ZonedDateTime.now().with(ChronoField.MONTH_OF_YEAR, 11));
		System.out.println(ZonedDateTime.now().withDayOfMonth(1));
		System.out.println(ZonedDateTime.now().withDayOfYear(365));
		System.out.println(ZonedDateTime.now().withMonth(11));
		System.out.println(ZonedDateTime.now().withYear(2017));
		System.out.println(ZonedDateTime.now().withYear(2017).withMonth(12).withDayOfMonth(25));

		System.out.println(ZonedDateTime.now().with(LocalTime.NOON));
		System.out.println(ZonedDateTime.now().with(ChronoField.HOUR_OF_DAY, 23));
		System.out.println(ZonedDateTime.now().withHour(23));
		System.out.println(ZonedDateTime.now().withMinute(59));
		System.out.println(ZonedDateTime.now().withSecond(59));
		System.out.println(ZonedDateTime.now().withNano(1));
		System.out.println(ZonedDateTime.now().withHour(23).withMinute(59).withSecond(59).withNano(1));
		System.out.println(ZonedDateTime.now().withZoneSameInstant(ZoneId.of("US/Mountain")));
		System.out.println(ZonedDateTime.now().withZoneSameLocal(ZoneId.of("US/Mountain")));
	}

	@Test
	public void testDayLightSavingComputation() {
		LocalDateTime ldt1 = LocalDateTime.of(2015, Month.NOVEMBER, 1, 2, 0);
		System.out.println(ldt1);

		ZonedDateTime zdt1 = ZonedDateTime.of(ldt1, ZoneId.of("US/Eastern"));
		System.out.println(zdt1);

		LocalDateTime ldt2 = LocalDateTime.of(2015, Month.NOVEMBER, 1, 1, 0);
		System.out.println(ldt2);

		ZonedDateTime zdt2 = ZonedDateTime.of(ldt2, ZoneId.of("US/Eastern"));
		System.out.println(zdt2);

		long x = ChronoUnit.HOURS.between(zdt1, zdt2);
		System.out.println(x);
	}

}
