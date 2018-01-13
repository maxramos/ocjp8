package ph.mramos.ocjp8.datetime;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class GeneralDateTimeTest {

	@Test
	public void testCreation() {
		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("LocalDate: " + localDate);
		System.out.println("LocalTime: " + localTime);
		System.out.println("LocalDateTime: " + localDateTime);
		System.out.println();
		
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		OffsetDateTime offsetDateTime = OffsetDateTime.now();
		OffsetTime offsetTime = OffsetTime.now();
		System.out.println("ZonedDateTime: " + zonedDateTime);
		System.out.println("OffsetDateTime: " + offsetDateTime);
		System.out.println("OffsetTime: " + offsetTime);
		System.out.println();
		
		Instant instant = Instant.now();
		System.out.println("Instant: " + instant);
		System.out.println();
		
		Year year = Year.now();
		YearMonth yearMonth = YearMonth.now();
		MonthDay monthDay = MonthDay.now();
		System.out.println("Year: " + year);
		System.out.println("YearMonth: " + yearMonth);
		System.out.println("MonthDay: " + monthDay);
	}
	
	@Test
	public void testOtherNowCreation() {
		LocalDate localDate = LocalDate.now(ZoneId.of("Asia/Kolkata"));
		LocalTime localTime = LocalTime.now(ZoneId.of("Asia/Kolkata"));
		LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
		System.out.println("LocalDate: " + localDate);
		System.out.println("LocalTime: " + localTime);
		System.out.println("LocalDateTime: " + localDateTime);
		System.out.println();
		
		ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
		OffsetDateTime offsetDateTime = OffsetDateTime.now(ZoneId.of("Asia/Kolkata"));
		OffsetTime offsetTime = OffsetTime.now(ZoneId.of("Asia/Kolkata"));
		System.out.println("ZonedDateTime: " + zonedDateTime);
		System.out.println("OffsetDateTime: " + offsetDateTime);
		System.out.println("OffsetTime: " + offsetTime);
		System.out.println();
		
		Year year = Year.now(ZoneId.of("Asia/Kolkata"));
		YearMonth yearMonth = YearMonth.now(ZoneId.of("Asia/Kolkata"));
		MonthDay monthDay = MonthDay.now(ZoneId.of("Asia/Kolkata"));
		System.out.println("Year: " + year);
		System.out.println("YearMonth: " + yearMonth);
		System.out.println("MonthDay: " + monthDay);
	}
	
	@Test
	public void testOfCreation() {
		LocalDate localDate = LocalDate.of(2017, Month.DECEMBER, 25);
		LocalTime localTime = LocalTime.of(23, 59, 59);
		LocalDateTime localDateTime = LocalDateTime.of(2017, Month.DECEMBER, 25, 23, 59, 59);
		System.out.println("LocalDate: " + localDate);
		System.out.println("LocalTime: " + localTime);
		System.out.println("LocalDateTime: " + localDateTime);
		System.out.println();
		
		ZonedDateTime zonedDateTime = ZonedDateTime.of(2017, 12, 25, 23, 59, 59, 0, ZoneId.of("Asia/Kolkata"));
		OffsetDateTime offsetDateTime = OffsetDateTime.of(2017, 12, 25, 23, 59, 59, 0, ZoneOffset.of("+05:30"));
		OffsetTime offsetTime = OffsetTime.of(23, 59, 59, 0, ZoneOffset.of("+05:30"));
		System.out.println("ZonedDateTime: " + zonedDateTime);
		System.out.println("OffsetDateTime: " + offsetDateTime);
		System.out.println("OffsetTime: " + offsetTime);
		System.out.println();
		
		Duration duration = Duration.of(30_000, ChronoUnit.MILLIS);
		Period period = Period.of(2017, 12, 25);
		System.out.println("Duration: " + duration);
		System.out.println("Period: " + period);
		System.out.println();
		
		Year year = Year.of(2017);
		YearMonth yearMonth = YearMonth.of(2017, Month.DECEMBER);
		MonthDay monthDay = MonthDay.of(Month.DECEMBER, 25);
		System.out.println("Year: " + year);
		System.out.println("YearMonth: " + yearMonth);
		System.out.println("MonthDay: " + monthDay);
	}
	
	@Test
	public void testZoneIdCreation() {
		System.out.println("ZONE ID");
		Set<String> zoneIds = ZoneId.getAvailableZoneIds();
		List<String> sortedZoneIds = zoneIds.stream().sorted().collect(Collectors.toList());
//		sortedZoneIds.forEach(System.out::println);
//		System.out.println("Size: " + sortedZoneIds.size());
		zoneIds.stream().filter(zone -> zone.contains("America")).sorted().collect(Collectors.toList()).forEach(System.out::println);
	}
	
	@Test
	public void testZoneOffsetCreation() {
		System.out.println("ZONE OFFSET");
		ZoneOffset utcZoneOffset = ZoneOffset.UTC;
		System.out.println(utcZoneOffset);
		ZoneOffset minZoneOffset = ZoneOffset.MIN;
		System.out.println(minZoneOffset);
		ZoneOffset maxZoneOffset = ZoneOffset.MAX;
		System.out.println(maxZoneOffset);
	}
	
	@Test
	public void testDateRelatedEnum() {
		System.out.println("MONTHS");
		Stream.of(Month.values()).forEach(System.out::println);
		System.out.println();
		
		System.out.println("DAYS OF WEEK");
		Stream.of(DayOfWeek.values()).forEach(System.out::println);
	}
	
	@Test
	public void testLocalDateManipulation() {
		LocalDate localDate = LocalDate.of(2017, Month.NOVEMBER, 1);
		System.out.println("LocalDate: " + localDate);
		System.out.println("plusYears: " + localDate.plusYears(1));
		System.out.println("plusMonths: " + localDate.plusMonths(1));
		System.out.println("plusWeeks: " + localDate.plusWeeks(1));
		System.out.println("plusDays: " + localDate.plusDays(1));
		System.out.println("plus (ChronoUnit.DAYS): " + localDate.plus(1, ChronoUnit.DAYS));
		System.out.println("plus (Period): " + localDate.plus(Period.ofYears(5)));
		System.out.println("minusYears: " + localDate.minusYears(1));
		System.out.println("minusMonths: " + localDate.minusMonths(1));
		System.out.println("minusWeeks: " + localDate.minusWeeks(1));
		System.out.println("minusDays: " + localDate.minusDays(1));
		System.out.println("minus (ChronoUnit.DAYS): " + localDate.minus(1, ChronoUnit.DAYS));
		System.out.println("minus (Period): " + localDate.minus(Period.ofYears(5)));
	}
	
	@Test
	public void testLocalTimeManipulation() {
		LocalTime localTime = LocalTime.of(1, 1, 1, 1);
		System.out.println("localTime: " + localTime);
		System.out.println("plusHours: " + localTime.plusHours(1));
		System.out.println("plusMinutes: " + localTime.plusMinutes(1));
		System.out.println("plusSeconds: " + localTime.plusSeconds(1));
		System.out.println("plusNanos: " + localTime.plusNanos(1));
		System.out.println("plus (ChronoUnit.HOURS): " + localTime.plus(1, ChronoUnit.HOURS));
		System.out.println("plus (Duration): " + localTime.plus(Duration.ofHours(5)));
		System.out.println("minusHours: " + localTime.minusHours(1));
		System.out.println("minusMinutes: " + localTime.minusMinutes(1));
		System.out.println("minusSeconds: " + localTime.minusSeconds(1));
		System.out.println("minusNanos: " + localTime.minusNanos(1));
		System.out.println("minus (ChronoUnit.HOURS): " + localTime.minus(1, ChronoUnit.HOURS));
		System.out.println("minus (Duration): " + localTime.minus(Duration.ofHours(5)));
	}
	
	@Test
	public void testLocalDateTimeManipulation() {		
		LocalDateTime localDateTime = LocalDateTime.of(2017, Month.NOVEMBER, 1, 1, 1, 1, 1);
		System.out.println("LocalDateTime: " + localDateTime);
		System.out.println("plusYears: " + localDateTime.plusYears(1));
		System.out.println("plusMonths: " + localDateTime.plusMonths(1));
		System.out.println("plusWeeks: " + localDateTime.plusWeeks(1));
		System.out.println("plusDays: " + localDateTime.plusDays(1));
		System.out.println("plus (ChronoUnit.DAYS): " + localDateTime.plus(1, ChronoUnit.DAYS));
		System.out.println("plus (Period): " + localDateTime.plus(Period.ofYears(5)));
		System.out.println("minusYears: " + localDateTime.minusYears(1));
		System.out.println("minusMonths: " + localDateTime.minusMonths(1));
		System.out.println("minusWeeks: " + localDateTime.minusWeeks(1));
		System.out.println("minusDays: " + localDateTime.minusDays(1));
		System.out.println("minus (ChronoUnit.DAYS): " + localDateTime.minus(1, ChronoUnit.DAYS));
		System.out.println("minus (Period): " + localDateTime.minus(Period.ofYears(5)));
		System.out.println("plusHours: " + localDateTime.plusHours(1));
		System.out.println("plusMinutes: " + localDateTime.plusMinutes(1));
		System.out.println("plusSeconds: " + localDateTime.plusSeconds(1));
		System.out.println("plusNanos: " + localDateTime.plusNanos(1));
		System.out.println("plus (ChronoUnit.HOURS): " + localDateTime.plus(1, ChronoUnit.HOURS));
		System.out.println("plus (Duration): " + localDateTime.plus(Duration.ofHours(5)));
		System.out.println("minusHours: " + localDateTime.minusHours(1));
		System.out.println("minusMinutes: " + localDateTime.minusMinutes(1));
		System.out.println("minusSeconds: " + localDateTime.minusSeconds(1));
		System.out.println("minusNanos: " + localDateTime.minusNanos(1));
		System.out.println("minus (ChronoUnit.HOURS): " + localDateTime.minus(1, ChronoUnit.HOURS));
		System.out.println("minus (Duration): " + localDateTime.minus(Duration.ofHours(5)));
	}
	
	@Test
	public void testConvertLocalDateTimetoDate() {
		LocalDateTime localDateTime = LocalDateTime.now();
		ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("Asia/Manila"));
		Instant instant = zonedDateTime.toInstant();
		Date date = Date.from(instant);
		System.out.println("LocalDateTime: " + localDateTime);
		System.out.println("ZonedDateTime: " + zonedDateTime);
		System.out.println("Instant: " + instant);
		System.out.println("Date: " + date);
		
		Date date1 = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
		System.out.println("Date1: " + date1);
	}
	
	@Test
	public void testConvertDateToLocalDateTime() {
		Date date = new Date();
		Instant instant = date.toInstant();
		ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("Asia/Manila"));
		LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();
		System.out.println("Date: " + date);
		System.out.println("Instant: " + instant);
		System.out.println("ZonedDateTime: " + zonedDateTime);
		System.out.println("LocalDateTime: " + localDateTime);
		
		LocalDateTime localDateTime1 = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		System.out.println("LocalDateTime1: " + localDateTime1);
	}
	
	@Test
	public void testDayLightSaving() {
		ZonedDateTime zonedDateTime1 = ZonedDateTime.of(LocalDate.of(2017, Month.MARCH, 12), LocalTime.of(1, 0), ZoneId.of("America/Los_Angeles"));
		System.out.println(zonedDateTime1);
		zonedDateTime1 = zonedDateTime1.plusHours(1);
		System.out.println(zonedDateTime1);
		
		System.out.println();
		
		ZonedDateTime zonedDateTime2 = ZonedDateTime.of(LocalDate.of(2017, Month.NOVEMBER, 5), LocalTime.of(1, 0), ZoneId.of("America/Los_Angeles"));
		System.out.println(zonedDateTime2);
		zonedDateTime2 = zonedDateTime2.plusHours(1);
		System.out.println(zonedDateTime2);
	}
	
	@Test
	public void testManipulationWithTemporalAmount() {
		Period period = Period.of(1, 1, 1);
		Duration duration = Duration.ofDays(1);
		System.out.println("LocalDate.plus(Period): " + LocalDate.now().plus(period));
//		System.out.println("LocalDate.plus(Duration): " + LocalDate.now().plus(duration)); // Throws exception
//		System.out.println("LocalTime.plus(Period): " + LocalTime.now().plus(period)); // Throws exception
		System.out.println("LocalTime.plus(Duration): " + LocalTime.now().plus(duration));
		System.out.println("LocalDateTime.plus(Period): " + LocalDateTime.now().plus(period));
		System.out.println("LocalDateTime.plus(Duration): " + LocalDateTime.now().plus(duration));
		System.out.println("ZonedDateTime.plus(Period): " + ZonedDateTime.now().plus(period));
		System.out.println("ZonedDateTime.plus(Duration): " + ZonedDateTime.now().plus(duration));
//		System.out.println("Instant.plus(Period): " + Instant.now().plus(period)); // Throws exception
		System.out.println("Instant.plus(Duration): " + Instant.now().plus(duration));
	}
	
	@Test
	public void testConversion() {
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		LocalDateTime ldt = LocalDateTime.now();
		ZonedDateTime zdt = ZonedDateTime.now();
		Instant inst = Instant.now();
		ZoneId zone = ZoneId.of("Asia/Kolkata");
		ZoneOffset offset = ZoneOffset.of("+05:30");
		System.out.println("LocalDate: " + date);
		System.out.println("LocalTime: " + time);
		System.out.println("LocalDateTime: " + ldt);
		System.out.println("ZonedDateTime: " + zdt);
		System.out.println("Instant: " + inst);
		System.out.println("ZoneId: " + zone);
		System.out.println("ZoneOffset: " + offset);
		System.out.println();
		
		LocalDateTime ldt1 = date.atTime(time);
		LocalDateTime ldt2 = date.atStartOfDay();
		System.out.println("LocalDate TO LocalDateTime");
		System.out.println("date.atTime(time): " + ldt1);
		System.out.println("date.atStartOfDay(): " + ldt2);
		System.out.println();
		
		ZonedDateTime zdt1 = date.atStartOfDay(zone);
		System.out.println("LocalDate TO ZonedDateTime");
		System.out.println("date.atStartOfDay(zone): " + zdt1);
		System.out.println();
		
		LocalDateTime ldt3 = time.atDate(date);
		System.out.println("LocalTime TO LocalDateTime");
		System.out.println("time.atDate(date): " + ldt3);
		System.out.println();
		
		LocalDate date1 = ldt.toLocalDate();
		System.out.println("LocalDateTime TO LocalDate");
		System.out.println("ldt.toLocalDate(): " + date1);
		System.out.println();
		
		LocalTime time1 = ldt.toLocalTime();
		System.out.println("LocalDateTime TO LocalTime");
		System.out.println("ldt.toLocalTime(): " + time1);
		System.out.println();
		
		ZonedDateTime zdt2 = ldt.atZone(zone);
		System.out.println("LocalDateTime TO ZonedDateTime");
		System.out.println("ldt.atZone(zone): " + zdt2);
		System.out.println();
		
		Instant inst1 = ldt.toInstant(offset);
		System.out.println("LocalDateTime TO Instant");
		System.out.println("ldt.toInstant(offset): " + inst1);
		System.out.println();
		
		LocalDate date2 = zdt.toLocalDate();
		System.out.println("ZonedDateTime TO LocalDate");
		System.out.println("zdt.toLocalDate(): " + date2);
		System.out.println();
		
		LocalTime time2 = zdt.toLocalTime();
		System.out.println("ZonedDateTime TO LocalTime");
		System.out.println("zdt.toLocalTime(): " + time2);
		System.out.println();
		
		LocalDateTime ldt4 = zdt.toLocalDateTime();
		System.out.println("ZonedDateTime TO LocalDateTime");
		System.out.println("zdt.toLocalDateTime(): " + ldt4);
		System.out.println();
		
		Instant inst2 = zdt.toInstant();
		System.out.println("ZonedDateTime TO Instant");
		System.out.println("zdt.toInstant(): " + inst2);
		System.out.println();
		
		ZonedDateTime zdt3 = inst.atZone(zone);
		System.out.println("Instant TO ZonedDateTime");
		System.out.println("inst.atZone(zone): " + zdt3);
		System.out.println();
	}
	
}
