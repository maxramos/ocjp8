package ph.mramos.ocjp8.datetime.format;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import org.junit.Test;

public class DateTimeFormatterTest {

	@Test
	public void testFormat() {
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
		
		LocalTime localTime = LocalTime.now();
		System.out.println(localTime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)));
		
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)));
		
		System.out.println();
		
		LocalDate localDate1 = LocalDate.now();
		System.out.println(localDate1.format(DateTimeFormatter.ISO_DATE));
		
		LocalTime localTime1 = LocalTime.now();
		System.out.println(localTime1.format(DateTimeFormatter.ISO_TIME));
		
		LocalDateTime localDateTime1 = LocalDateTime.now();
		System.out.println(localDateTime1.format(DateTimeFormatter.ISO_DATE_TIME));
	}
	
}
