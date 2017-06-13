package com.smart.home.model;

import static org.joda.time.DateTimeZone.UTC;
import static org.joda.time.format.DateTimeFormat.forPattern;
import static org.junit.Assert.assertEquals;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

public class UserTest {

	@Test
	public void the_lastSignIn_must_be_immutable() {
		final String date = "2017-06-12T07:37:25.765Z";
		DateTime now = toDateTime(date);

		User user = new User(1, "Rafael", "rafael@email.com", now);

		assertEquals(toDateTime(date), user.getLastSignIn());

		now.hourOfDay().setCopy(3);

		assertEquals(toDateTime(date), user.getLastSignIn());

		user.getLastSignIn().hourOfDay().setCopy(3);
		user.getLastSignIn().hourOfDay();

		assertEquals(toDateTime(date), user.getLastSignIn());
	}

	@Test
	public void printTimeZone() {
		final String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
		final String date = "2017-06-12T07:37:25.765Z";

		DateTimeFormatter formatter = forPattern(pattern);
		DateTimeFormatter formatterUTC = formatter.withZoneUTC();

		DateTime first = formatter.parseDateTime(date);
		DateTime second = formatterUTC.parseDateTime(date);

		DateTime convertedFirst = first.withZone(UTC);
		DateTime sameSecond = second.withZone(UTC);

		System.out.println(convertedFirst.toString(pattern));
		System.out.println(sameSecond.toString(pattern));
		System.out.println(first.toString(pattern));
	}

	private DateTime toDateTime(String date) {
		return DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").withZoneUTC().parseDateTime(date);
	}
}
