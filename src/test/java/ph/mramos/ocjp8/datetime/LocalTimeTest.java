package ph.mramos.ocjp8.datetime;

import java.time.DayOfWeek;
import java.time.Duration;
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

public class LocalTimeTest {

	@Test
	public void testCreation() {
		System.out.println(LocalTime.MIDNIGHT);
		System.out.println(LocalTime.NOON);
		System.out.println(LocalTime.from(LocalDateTime.now()));
		System.out.println(LocalTime.now());
		System.out.println(LocalTime.now(ZoneId.of("US/Mountain")));
		System.out.println(LocalTime.of(23, 59, 59));
		System.out.println(LocalTime.ofNanoOfDay(1));
		System.out.println(LocalTime.ofSecondOfDay(1));
		System.out.println(LocalTime.parse("23:59"));
		System.out.println(LocalTime.parse("23-59-59", DateTimeFormatter.ofPattern("HH-mm-ss")));
		// Big HH is for 24 hours, small hh is for 12 hours
	}
	
	@Test
	public void testAdjustInto() {
		LocalDateTime now = LocalDateTime.now();
		LocalTime time = LocalTime.of(23, 59, 59);
		System.out.println(now);
		System.out.println(time);
		System.out.println(time.adjustInto(now));
	}
	
	@Test
	public void testAtDate() {
		LocalDateTime ldt1 = LocalTime.now().atDate(LocalDate.of(2017, Month.DECEMBER, 25));
		System.out.println(ldt1);
	}
	
	@Test
	public void testAtOffset() {
		OffsetTime ot = LocalTime.now().atOffset(ZoneOffset.of("-07:00"));
		System.out.println(ot);
	}
	
	@Test
	public void testComparison() {
		LocalTime lt1 = LocalTime.of(22, 59, 59);
		LocalTime lt2 = LocalTime.of(23, 59, 59);
		LocalTime lt3 = LocalTime.of(23, 59, 59);
		
		System.out.println(lt1.compareTo(lt2));
		System.out.println(lt2.equals(lt3));
		System.out.println(lt2.isAfter(lt1));
		System.out.println(lt1.isBefore(lt2));
	}
	
	@Test
	public void testFormat() {
		System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("HH-mm-ss")));
	}
	
	@Test
	public void testGet() {
		LocalTime time = LocalTime.now();
		System.out.println("Time: " + time);
		System.out.println("get(ChronoField): " + time.get(ChronoField.HOUR_OF_DAY));
		System.out.println("getHour: " + time.getHour());
		System.out.println("getLong(ChronoField): " + time.getLong(ChronoField.HOUR_OF_DAY));
		System.out.println("getMinute: " + time.getMinute());
		System.out.println("getNano: " + time.getNano());
		System.out.println("getSecond: " + time.getSecond());
	}
	
	@Test
	public void testPredicate() {
		LocalTime time = LocalTime.now();
		System.out.println(time.isSupported(ChronoField.HOUR_OF_DAY));
		System.out.println(time.isSupported(ChronoUnit.HOURS));
	}
	
	@Test
	public void testPlus() {
		LocalTime localTime = LocalTime.of(22, 59, 59);
		System.out.println("LocalTime: " + localTime);
		System.out.println("plusHours: " + localTime.plusHours(1));
		System.out.println("plusMinutes: " + localTime.plusMinutes(1));
		System.out.println("plusSeconds: " + localTime.plusSeconds(1));
		System.out.println("plusNanos: " + localTime.plusNanos(1));
		System.out.println("plus (ChronoUnit.HOURS): " + localTime.plus(1, ChronoUnit.HOURS));
		System.out.println("plus (Duration): " + localTime.plus(Duration.ofHours(1)));
	}
	
	@Test
	public void testMinus() {
		LocalTime localTime = LocalTime.of(23, 59, 59);
		System.out.println("LocalTime: " + localTime);
		System.out.println("minusHours: " + localTime.minusHours(1));
		System.out.println("minusMinutes: " + localTime.minusMinutes(1));
		System.out.println("minusSeconds: " + localTime.minusSeconds(1));
		System.out.println("minusNanos: " + localTime.minusNanos(1));
		System.out.println("minus (ChronoUnit.HOURS): " + localTime.minus(1, ChronoUnit.HOURS));
		System.out.println("minus (Duration): " + localTime.minus(Duration.ofHours(1)));
	}
	
	@Test
	public void testQuery() {
		LocalTime time = LocalTime.now();
		System.out.println(time.query(TemporalQueries.localTime()));
	}
	
	@Test
	public void testRange() {
		LocalTime time = LocalTime.now();
		System.out.println(time.range(ChronoField.HOUR_OF_DAY));
		System.out.println(time.range(ChronoField.HOUR_OF_AMPM));
	}
	
	@Test
	public void testToNanoDay_ToSecondOfDay() {
		System.out.println(LocalTime.now().toNanoOfDay());
		System.out.println(LocalTime.now().toSecondOfDay());
	}
	
	@Test
	public void testTruncatedTo() {
		System.out.println(LocalTime.now().truncatedTo(ChronoUnit.HOURS));
	}
	
	@Test
	public void testUntil() {
		LocalTime start = LocalTime.of(23, 59, 59);
		long length = start.until(LocalTime.now(), ChronoUnit.HOURS);
		System.out.println(length);
	}
	
	@Test
	public void testWith() {
		System.out.println(LocalTime.now().with(LocalTime.NOON));
		System.out.println(LocalTime.now().with(ChronoField.HOUR_OF_DAY, 23));
		System.out.println(LocalTime.now().withHour(23));
		System.out.println(LocalTime.now().withMinute(59));
		System.out.println(LocalTime.now().withSecond(59));
		System.out.println(LocalTime.now().withNano(1));
		System.out.println(LocalTime.now().withHour(23).withMinute(59).withSecond(59).withNano(1));
	}
}
