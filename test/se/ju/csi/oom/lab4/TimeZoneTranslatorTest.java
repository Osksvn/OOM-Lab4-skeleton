package se.ju.csi.oom.lab4;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class TimeZoneTranslatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testShiftTimeZone() {
		DateTime time = new DateTime(2018, 10, 4, 17, 26, 30); 
		String hardcodedTime = "2018-10-04 10:26:30";
		String calculatedTime = TimeZoneTranslator.shiftTimeZone(time, 1, -6).toString();
		 assertEquals("fail", hardcodedTime, calculatedTime);
		System.out.println(String.format("===Time in Central Europe====\n%s", time.toString()));
		System.out.println(String.format("===Time in Central America====\n%s", TimeZoneTranslator.shiftTimeZone(time, 1, -6).toString()));
		
		DateTime bugDate = new DateTime(2016, 01, 01, 06, 00, 00);
		assertEquals("fail", "2015-12-31 21:00:00", TimeZoneTranslator.shiftTimeZone(bugDate, 1, -8).toString());
		System.out.println(String.format("===bug date test===\n%s", TimeZoneTranslator.shiftTimeZone(bugDate, 1, -8).toString()));
	}

	@Test
	public void testShiftEventTimeZone() {
		DateTime startStudying = new DateTime(2017, 8, 15, 8, 0, 0);
		DateTime stopStudying = new DateTime(2020, 6, 15, 15, 0, 0);
		Person oskar = new Person("Oskar"); 
		Place jonkopingUniversity = new Place("Jonkpoing University", 57.7785672,14.1614833,20.0);
		Event study = new Event("Study time at Jonkoping University", startStudying, stopStudying, new HashSet<>(Arrays.asList(oskar)), jonkopingUniversity);
		Event calculatedTime;
		String studyStartTimeInBangladesh = "2017-08-15 13:00:00";
		String studyEndTimeInBangladesh = "2020-06-15 20:00:00";
		calculatedTime = TimeZoneTranslator.shiftEventTimeZone(study, TimeZone.CENTRAL_EUROPEAN_TIME, TimeZone.BANGLADESH);
		assertEquals("fail", studyStartTimeInBangladesh, calculatedTime.getStartDate().toString());
		assertEquals("faiL", studyEndTimeInBangladesh, calculatedTime.getEndDate().toString());
		System.out.println(String.format("=====Local time during study=====\n%s", study.toString()));
		System.out.println(String.format("=====Time in bangladesh during study=====\n%s", TimeZoneTranslator.shiftEventTimeZone(study, TimeZone.CENTRAL_EUROPEAN_TIME, TimeZone.BANGLADESH).toString()));
	}

}
