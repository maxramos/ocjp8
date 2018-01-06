package ph.mramos.ocjp8.datetime;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalQueries;
import java.time.zone.ZoneRules;

import org.junit.Test;

public class InstantTest {

	@Test
	public void testCreation() {
		System.out.println(Instant.from(ZonedDateTime.now()));
		System.out.println(Instant.now());
		System.out.println(Instant.ofEpochMilli(1));
		System.out.println(Instant.ofEpochSecond(1));
		System.out.println(Instant.ofEpochSecond(1, 1));		
		System.out.println(Instant.parse("2017-12-25T23:59:59.00Z"));
	}
	
	@Test
	public void testAdjustInto() {
		Instant now = Instant.now();
		Instant date = Instant.ofEpochMilli(1);
		System.out.println(now);
		System.out.println(date);
		System.out.println(date.adjustInto(now));
	}
	
	@Test
	public void testAtOffset() {
		OffsetDateTime odt = Instant.now().atOffset(ZoneOffset.of("-07:00"));
		System.out.println(odt);
	}
	
	@Test
	public void testAtZone() {
		ZonedDateTime zdt = Instant.now().atZone(ZoneId.of("US/Mountain"));
		System.out.println(zdt);
	}
	
	@Test
	public void testComparison() {
		Instant inst1 = Instant.parse("2007-12-03T10:15:30.00Z");
		Instant inst2 = Instant.parse("2007-12-04T10:15:30.00Z");
		Instant inst3 = Instant.parse("2007-12-04T10:15:30.00Z");
		
		System.out.println(inst1.compareTo(inst2));
		System.out.println(inst2.equals(inst3));
		System.out.println(inst2.isAfter(inst1));
		System.out.println(inst1.isBefore(inst2));
	}
	
	@Test
	public void testGet() {
		Instant inst = Instant.now();
		System.out.println("Instant: " + inst);
		System.out.println("get(ChronoField): " + inst.get(ChronoField.MILLI_OF_SECOND));
		System.out.println("getEpochSecond: " + inst.getEpochSecond());
		System.out.println("getLong (ChronoField): " + inst.getLong(ChronoField.NANO_OF_SECOND));
		System.out.println("getNano: " + inst.getNano());
	}
	
	@Test
	public void testPredicate() {
		Instant inst = Instant.now();
		System.out.println(inst.isSupported(ChronoField.MILLI_OF_SECOND));
		System.out.println(inst.isSupported(ChronoUnit.DAYS));
		System.out.println(inst.isSupported(ChronoField.NANO_OF_SECOND));
		System.out.println(inst.isSupported(ChronoUnit.HOURS));
	}
	
	@Test
	public void testPlus() {
		Instant inst = Instant.now();
		System.out.println("Instant: " + inst);
		System.out.println("plusSeconds: " + inst.plusSeconds(1));
		System.out.println("plusMillis: " + inst.plusMillis(1));
		System.out.println("plusNanos: " + inst.plusNanos(1));
		System.out.println("plus (ChronoUnit.DAYS): " + inst.plus(1, ChronoUnit.DAYS));
		System.out.println("plus (ChronoUnit.HOURS): " + inst.plus(1, ChronoUnit.HOURS));
		System.out.println("plus (Duration): " + inst.plus(Duration.ofHours(1)));
	}
	
	@Test
	public void testMinus() {
		Instant inst = Instant.now();
		System.out.println("Instant: " + inst);
		System.out.println("minusSeconds: " + inst.minusSeconds(1));
		System.out.println("minusMillis: " + inst.minusMillis(1));
		System.out.println("minusNanos: " + inst.minusNanos(1));
		System.out.println("minus (ChronoUnit.DAYS): " + inst.minus(1, ChronoUnit.DAYS));
		System.out.println("minus (ChronoUnit.HOURS): " + inst.minus(1, ChronoUnit.HOURS));
		System.out.println("minus (Duration): " + inst.minus(Duration.ofHours(1)));
	}
	
	@Test
	public void testQuery() {
		Instant inst = Instant.now();
		System.out.println(inst.query(TemporalQueries.precision()));
	}
	
	@Test
	public void testRange() {
		Instant inst = Instant.now();
		System.out.println(inst.range(ChronoField.MILLI_OF_SECOND));
		System.out.println(inst.range(ChronoField.MICRO_OF_SECOND));
		System.out.println(inst.range(ChronoField.NANO_OF_SECOND));
		System.out.println(inst.range(ChronoField.INSTANT_SECONDS));
	}
	
	@Test
	public void testToEpocMilli() {
		System.out.println(Instant.now().toEpochMilli());
	}
	
	@Test
	public void testTruncatedTo() {
		System.out.println(Instant.now().truncatedTo(ChronoUnit.DAYS));
		System.out.println(Instant.now().truncatedTo(ChronoUnit.HOURS));
	}
	
	@Test
	public void testUntil() {
		Instant start = Instant.ofEpochSecond(1);
		long length1 = start.until(Instant.now(), ChronoUnit.DAYS);
		System.out.println(length1);
		
		long length2 = start.until(Instant.now(), ChronoUnit.HOURS);
		System.out.println(length2);
	}
	
	@Test
	public void testWith() {
		System.out.println(Instant.now().with(Instant.ofEpochSecond(1)));
		System.out.println(Instant.now().with(ChronoField.MILLI_OF_SECOND, 1));
	}
	
}
