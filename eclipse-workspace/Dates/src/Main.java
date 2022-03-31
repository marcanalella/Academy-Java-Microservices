import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		System.out.println("now: " + now);
		
		LocalDateTime nowAtNoon = now.withHour(12);
		System.out.println("nowAtNoon: " + nowAtNoon);
		
		LocalDateTime nowIn100Hours = now.plusHours(100);
		System.out.println("nowIn100Hours: " + nowIn100Hours);
		
		LocalDateTime start = LocalDateTime.of(2019, 1, 28, 9, 0);
		LocalDate startDate = start.toLocalDate();
		LocalTime startTime = start.toLocalTime();
		System.out.println("startDate: " + startDate);
		System.out.println("startTime: " + startTime);
		
		Duration fiveDays = Duration.ofDays(5);
		System.out.println("fiveDays: " + fiveDays);
		
		Duration fiveMinutes = Duration.ofMinutes(5);
		System.out.println("fiveMinutes: " + fiveMinutes);
		
		Duration delta = Duration.between(start, now);
		System.out.println("delta: " + delta);
		
		LocalDateTime altStart = LocalDateTime.of(2018, 10, 15, 9, 0);
		Temporal temporal = delta.addTo(altStart);
		System.out.println("temporal: " + temporal);
		LocalDateTime ldt2 = LocalDateTime.from(temporal);
		System.out.println("ldt2:     " + ldt2);
		
		Duration delta4 = delta.multipliedBy(4);
		System.out.println("delta4: " + delta4);
		
		Period period = Period.ofDays(28);
		Temporal next = period.addTo(startDate);
		System.out.println("next: " + next);
		Period p2 = Period.between(startDate, now.toLocalDate());
		System.out.println("p2: " + p2);
		
		////////////////////////////////////////////////////////
		
		Date date = new Date(2019, 2, 1);
		System.out.println("date: " + date);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2019);
		calendar.set(Calendar.MONTH, Calendar.FEBRUARY);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Date date2 = calendar.getTime();
		System.out.println("date2: " + date2);
		
		////////////////////////////////////////////////////////
		
		ZoneId cet = ZoneId.of("Europe/Rome");
		LocalDateTime ldt = LocalDateTime.of(2019, 2, 4, 9, 24);
		ZonedDateTime ldtRome = ldt.atZone(cet);
		System.out.println("In Rome: " + ldtRome);
		
		LocalDateTime ldt3 = LocalDateTime.of(2019, 3, 31, 9, 24);
		ZonedDateTime ldt3Rome = ldt3.atZone(cet);
		System.out.println("In Rome: " + ldt3Rome);
		
		////////////////////////////////////////////////////////
		DateTimeFormatter fmt = DateTimeFormatter
				.ofPattern("d MMMM yyyy HH:mm:ss", Locale.ITALIAN);
		String s1 = fmt.format(ldt3);
		System.out.println("Formatted: " + s1);
				
		DateTimeFormatter fmt2 = DateTimeFormatter
				.ofLocalizedDateTime(FormatStyle.MEDIUM);
		String s2 = fmt2.format(ldt3);
		System.out.println("Formatted: " + s2);
		
		String s3 = "13 giugno 2019 11:45:00";
		TemporalAccessor ta = fmt.parse(s3);
		System.out.println("TA: " + ta);
		LocalDateTime ldt4 = LocalDateTime.from(ta);
		System.out.println("ldt4: " + ldt4);
		
		LocalDateTime ldt5 = LocalDateTime.parse(s3, fmt);
		System.out.println("ldt5: " + ldt5);
		
		
	}

}
