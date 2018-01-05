package ph.mramos.ocjp8.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalQueries;

import org.junit.Test;

public class LocalDateTest {

	@Test
	public void testCreation() {
		System.out.println(LocalDate.from(LocalDateTime.now()));
		System.out.println(LocalDate.now());
		System.out.println(LocalDate.now(ZoneId.of("US/Mountain")));
		System.out.println(LocalDate.of(2017, Month.DECEMBER, 25));
		System.out.println(LocalDate.ofEpochDay(1));
		System.out.println(LocalDate.ofYearDay(2017, 365));
		System.out.println(LocalDate.parse("2017-12-25"));
		System.out.println(LocalDate.parse("Dec 25, 2017", DateTimeFormatter.ofPattern("MMM dd, yyyy")));
	}
	
	@Test
	public void testAdjustInto() {
		LocalDateTime now = LocalDateTime.now();
		LocalDate date = LocalDate.of(2017, Month.DECEMBER, 25);
		System.out.println(now);
		System.out.println(date);
		System.out.println(date.adjustInto(now));
	}
	
	@Test
	public void testAtStartOfDay() {
		LocalDateTime ldt = LocalDate.now().atStartOfDay();
		ZonedDateTime zdt = LocalDate.now().atStartOfDay(ZoneId.of("US/Mountain"));
		System.out.println(ldt);
		System.out.println(zdt);
	}
	
	@Test
	public void testAtTime() {
		LocalDateTime ldt1 = LocalDate.now().atTime(1, 1, 1);
		LocalDateTime ldt2 = LocalDate.now().atTime(LocalTime.now());
		OffsetDateTime odt = LocalDate.now().atTime(OffsetTime.now());
		System.out.println(ldt1);
		System.out.println(ldt2);
		System.out.println(odt);
	}
	
	@Test
	public void testComparison() {
		LocalDate ldt1 = LocalDate.of(2017, Month.NOVEMBER, 1);
		LocalDate ldt2 = LocalDate.of(2017, Month.DECEMBER, 1);
		LocalDate ldt3 = LocalDate.of(2017, Month.DECEMBER, 1);
		
		System.out.println(ldt1.compareTo(ldt2));
		System.out.println(ldt2.equals(ldt3));
		System.out.println(ldt2.isAfter(ldt1));
		System.out.println(ldt1.isBefore(ldt2));
		System.out.println(ldt2.isEqual(ldt3));
	}
	
	@Test
	public void testFormat() {
		System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy")));
	}
	
	@Test
	public void testGet() {
		LocalDate date = LocalDate.now();
		System.out.println("Date: " + date);
		System.out.println("get(ChronoField): " + date.get(ChronoField.MONTH_OF_YEAR));
		System.out.println("getDayOfMonth: " + date.getDayOfMonth());
		System.out.println("getDayOfWeek: " + date.getDayOfWeek());
		System.out.println("getDayOfYear: " + date.getDayOfYear());
		System.out.println("getEra: " + date.getEra());
		System.out.println("getLong(ChronoField): " + date.getLong(ChronoField.MONTH_OF_YEAR));
		System.out.println("getMonth: " + date.getMonth());
		System.out.println("getMonthValue: " + date.getMonthValue());
		System.out.println("getYear: " + date.getYear());
	}
	
	@Test
	public void testPredicate() {
		LocalDate date = LocalDate.now();
		System.out.println(date.isLeapYear());
		System.out.println(date.isSupported(ChronoField.MONTH_OF_YEAR));
		System.out.println(date.isSupported(ChronoUnit.MONTHS));
	}
	
	@Test
	public void testLength() {
		System.out.println(LocalDate.now().lengthOfMonth());
		System.out.println(LocalDate.now().lengthOfYear());
	}
	
	@Test
	public void testPlus() {
		LocalDate localDate = LocalDate.of(2017, Month.NOVEMBER, 1);
		System.out.println("LocalDate: " + localDate);
		System.out.println("plusYears: " + localDate.plusYears(1));
		System.out.println("plusMonths: " + localDate.plusMonths(1));
		System.out.println("plusWeeks: " + localDate.plusWeeks(1));
		System.out.println("plusDays: " + localDate.plusDays(1));
		System.out.println("plus (ChronoUnit.DAYS): " + localDate.plus(1, ChronoUnit.DAYS));
		System.out.println("plus (Period): " + localDate.plus(Period.ofYears(5)));
	}
	
	@Test
	public void testMinus() {
		LocalDate localDate = LocalDate.of(2017, Month.NOVEMBER, 1);
		System.out.println("minusYears: " + localDate.minusYears(1));
		System.out.println("minusMonths: " + localDate.minusMonths(1));
		System.out.println("minusWeeks: " + localDate.minusWeeks(1));
		System.out.println("minusDays: " + localDate.minusDays(1));
		System.out.println("minus (ChronoUnit.DAYS): " + localDate.minus(1, ChronoUnit.DAYS));
		System.out.println("minus (Period): " + localDate.minus(Period.ofYears(5)));
	}
	
	@Test
	public void testQuery() {
		LocalDate date = LocalDate.now();
		System.out.println(date.query(TemporalQueries.localDate()));
	}
	
	@Test
	public void testRange() {
		LocalDate date = LocalDate.now();
		System.out.println(date.range(ChronoField.MONTH_OF_YEAR));
		System.out.println(date.range(ChronoField.DAY_OF_WEEK));
	}
	
	@Test
	public void testToEpochDay() {
		System.out.println(LocalDate.now().toEpochDay());
	}
	
	@Test
	public void testUntil() {
		LocalDate start = LocalDate.of(2017, Month.NOVEMBER, 25);
		Period period = start.until(LocalDate.now());
		long length = start.until(LocalDate.now(), ChronoUnit.DAYS);
		System.out.println(period);
		System.out.println(length);
	}
	
	@Test
	public void testWith() {
		System.out.println(LocalDate.now().with(DayOfWeek.MONDAY));
		System.out.println(LocalDate.now().with(ChronoField.MONTH_OF_YEAR, 11));
		System.out.println(LocalDate.now().withDayOfMonth(1));
		System.out.println(LocalDate.now().withDayOfYear(365));
		System.out.println(LocalDate.now().withMonth(11));
		System.out.println(LocalDate.now().withYear(2017));
		System.out.println(LocalDate.now().withYear(2017).withMonth(12).withDayOfMonth(25));
	}
	
}
