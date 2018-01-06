package ph.mramos.ocjp8.datetime;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalQueries;

import org.junit.Test;

public class LocalDateTimeTest {

	@Test
	public void testCreation() {
		System.out.println(LocalDateTime.from(LocalDateTime.now()));
		System.out.println(LocalDateTime.now());
		System.out.println(LocalDateTime.now(ZoneId.of("US/Mountain")));
		System.out.println(LocalDateTime.of(2017, Month.DECEMBER, 25, 23, 59, 59));
		System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.now()));
		System.out.println(LocalDateTime.ofEpochSecond(1, 1, ZoneOffset.of("-07:00")));
		System.out.println(LocalDateTime.ofInstant(Instant.now(), ZoneId.of("US/Mountain")));
		System.out.println(LocalDateTime.parse("2017-12-25T23:59:59"));
		System.out.println(LocalDateTime.parse("Dec 25, 2017 23-59-59", DateTimeFormatter.ofPattern("MMM dd, yyyy HH-mm-ss")));
	}
	
	@Test
	public void testAdjustInto() {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime date = LocalDateTime.of(2017, Month.DECEMBER, 25, 23, 59,59);
		System.out.println(now);
		System.out.println(date);
		System.out.println(date.adjustInto(now));
	}
	
	@Test
	public void testAtOffset() {
		OffsetDateTime odt = LocalDateTime.now().atOffset(ZoneOffset.of("-07:00"));
		System.out.println(odt);
	}
	
	@Test
	public void testAtZone() {
		ZonedDateTime zdt = LocalDateTime.now().atZone(ZoneId.of("US/Mountain"));
		System.out.println(zdt);
	}
	
	@Test
	public void testComparison() {
		LocalDateTime ldt1 = LocalDateTime.of(2017, Month.NOVEMBER, 1, 23, 59, 59);
		LocalDateTime ldt2 = LocalDateTime.of(2017, Month.DECEMBER, 1, 23, 59, 59);
		LocalDateTime ldt3 = LocalDateTime.of(2017, Month.DECEMBER, 1, 23, 59, 59);
		
		System.out.println(ldt1.compareTo(ldt2));
		System.out.println(ldt2.equals(ldt3));
		System.out.println(ldt2.isAfter(ldt1));
		System.out.println(ldt1.isBefore(ldt2));
		System.out.println(ldt2.isEqual(ldt3));
	}
	
	@Test
	public void testFormat() {
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy HH-mm-ss")));
	}
	
	@Test
	public void testGet() {
		LocalDateTime dt = LocalDateTime.now();
		System.out.println("DateTime: " + dt);
		System.out.println("get(ChronoField): " + dt.get(ChronoField.MONTH_OF_YEAR));
		System.out.println("getDayOfMonth: " + dt.getDayOfMonth());
		System.out.println("getDayOfWeek: " + dt.getDayOfWeek());
		System.out.println("getDayOfYear: " + dt.getDayOfYear());
		System.out.println("getLong(ChronoField): " + dt.getLong(ChronoField.MONTH_OF_YEAR));
		System.out.println("getMonth: " + dt.getMonth());
		System.out.println("getMonthValue: " + dt.getMonthValue());
		System.out.println("getYear: " + dt.getYear());
		System.out.println("getHour: " + dt.getHour());
		System.out.println("getMinute: " + dt.getMinute());
		System.out.println("getNano: " + dt.getNano());
		System.out.println("getSecond: " + dt.getSecond());
	}
	
	@Test
	public void testPredicate() {
		LocalDateTime dt = LocalDateTime.now();
		System.out.println(dt.isSupported(ChronoField.MONTH_OF_YEAR));
		System.out.println(dt.isSupported(ChronoUnit.MONTHS));
		System.out.println(dt.isSupported(ChronoField.HOUR_OF_DAY));
		System.out.println(dt.isSupported(ChronoUnit.HOURS));
	}
	
	@Test
	public void testPlus() {
		LocalDateTime ldt = LocalDateTime.of(2017, Month.NOVEMBER, 1, 23, 59, 59);
		System.out.println("LocalDate: " + ldt);
		System.out.println("plusYears: " + ldt.plusYears(1));
		System.out.println("plusMonths: " + ldt.plusMonths(1));
		System.out.println("plusWeeks: " + ldt.plusWeeks(1));
		System.out.println("plusDays: " + ldt.plusDays(1));
		System.out.println("plus (ChronoUnit.DAYS): " + ldt.plus(1, ChronoUnit.DAYS));
		System.out.println("plus (Period): " + ldt.plus(Period.ofYears(5)));
		
		System.out.println("plusHours: " + ldt.plusHours(1));
		System.out.println("plusMinutes: " + ldt.plusMinutes(1));
		System.out.println("plusSeconds: " + ldt.plusSeconds(1));
		System.out.println("plusNanos: " + ldt.plusNanos(1));
		System.out.println("plus (ChronoUnit.HOURS): " + ldt.plus(1, ChronoUnit.HOURS));
		System.out.println("plus (Duration): " + ldt.plus(Duration.ofHours(1)));
	}
	
	@Test
	public void testMinus() {
		LocalDateTime ldt = LocalDateTime.of(2017, Month.NOVEMBER, 1, 23, 59,59);
		System.out.println("minusYears: " + ldt.minusYears(1));
		System.out.println("minusMonths: " + ldt.minusMonths(1));
		System.out.println("minusWeeks: " + ldt.minusWeeks(1));
		System.out.println("minusDays: " + ldt.minusDays(1));
		System.out.println("minus (ChronoUnit.DAYS): " + ldt.minus(1, ChronoUnit.DAYS));
		System.out.println("minus (Period): " + ldt.minus(Period.ofYears(5)));
		
		System.out.println("minusHours: " + ldt.minusHours(1));
		System.out.println("minusMinutes: " + ldt.minusMinutes(1));
		System.out.println("minusSeconds: " + ldt.minusSeconds(1));
		System.out.println("minusNanos: " + ldt.minusNanos(1));
		System.out.println("minus (ChronoUnit.HOURS): " + ldt.minus(1, ChronoUnit.HOURS));
		System.out.println("minus (Duration): " + ldt.minus(Duration.ofHours(1)));
	}
	
	@Test
	public void testQuery() {
		LocalDateTime dt = LocalDateTime.now();
		System.out.println(dt.query(TemporalQueries.localDate()));
		System.out.println(dt.query(TemporalQueries.localTime()));
	}
	
	@Test
	public void testRange() {
		LocalDateTime dt = LocalDateTime.now();
		System.out.println(dt.range(ChronoField.MONTH_OF_YEAR));
		System.out.println(dt.range(ChronoField.DAY_OF_WEEK));
		System.out.println(dt.range(ChronoField.HOUR_OF_DAY));
		System.out.println(dt.range(ChronoField.HOUR_OF_AMPM));
	}
	
	@Test
	public void testToLocalDate_ToLocalTime() {
		System.out.println(LocalDateTime.now().toLocalDate());
		System.out.println(LocalDateTime.now().toLocalTime());
	}
	
	@Test
	public void testTruncatedTo() {
		System.out.println(LocalDateTime.now().truncatedTo(ChronoUnit.DAYS));
		System.out.println(LocalDateTime.now().truncatedTo(ChronoUnit.HOURS));
	}
	
	@Test
	public void testUntil() {
		LocalDateTime start = LocalDateTime.of(2017, Month.NOVEMBER, 25, 23, 59, 59);
		long length1 = start.until(LocalDateTime.now(), ChronoUnit.DAYS);
		System.out.println(length1);
		
		long length2 = start.until(LocalDateTime.now(), ChronoUnit.HOURS);
		System.out.println(length2);
	}
	
	@Test
	public void testWith() {
		System.out.println(LocalDateTime.now().with(DayOfWeek.MONDAY));
		System.out.println(LocalDateTime.now().with(ChronoField.MONTH_OF_YEAR, 11));
		System.out.println(LocalDateTime.now().withDayOfMonth(1));
		System.out.println(LocalDateTime.now().withDayOfYear(365));
		System.out.println(LocalDateTime.now().withMonth(11));
		System.out.println(LocalDateTime.now().withYear(2017));
		System.out.println(LocalDateTime.now().withYear(2017).withMonth(12).withDayOfMonth(25));
	
		System.out.println(LocalDateTime.now().with(LocalTime.NOON));
		System.out.println(LocalDateTime.now().with(ChronoField.HOUR_OF_DAY, 23));
		System.out.println(LocalDateTime.now().withHour(23));
		System.out.println(LocalDateTime.now().withMinute(59));
		System.out.println(LocalDateTime.now().withSecond(59));
		System.out.println(LocalDateTime.now().withNano(1));
		System.out.println(LocalDateTime.now().withHour(23).withMinute(59).withSecond(59).withNano(1));
	}
	
}
