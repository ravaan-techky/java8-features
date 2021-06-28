package com.example.java8.features;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class LocalDateProgram {
	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		System.out.println("LocalDate Object : " + localDate);
		System.out.println("LocalTime Object : " + localTime);
		localDate = localDate.plusDays(22);
		System.out.println("LocalDate Object After adding 22 Days : " + localDate);
		localDate = localDate.minusDays(23);
		
		System.out.println("LocalDate Object After subtracting 23 Days : " + localDate);
		System.out.println("IsLeapYear check " + LocalDate.parse("2021-06-04").isLeapYear());
		System.out.println("IsLeapYear check " + LocalDate.parse("2008-06-04").isLeapYear());
		System.out.println("IsAFterDate check " + LocalDate.parse("2021-06-04").isAfter(LocalDate.parse("2021-07-05")));
		System.out.println("IsBeforeDate check " + LocalDate.parse("2021-06-04").isBefore(LocalDate.parse("2021-07-05")));
		
		Date oldDateObject = new Date();
		System.out.println("Old Date Class Object " + oldDateObject);
		LocalDate localDateFromDateClass = oldDateObject.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		System.out.println("Local Date Object from Old Date class " + localDateFromDateClass);
		
		Date newDateObject = Date.from(localDateFromDateClass.atStartOfDay(ZoneId.systemDefault()).toInstant());
		System.out.println("New Old Date Object from LocalDate Object " + newDateObject);
		
		
		System.out.println("End Of Application");
		
	}
}
