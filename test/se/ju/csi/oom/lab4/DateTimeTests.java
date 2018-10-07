package se.ju.csi.oom.lab4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DateTimeTests {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testToString() {
		DateTime date = new DateTime(2018, 10,10,10,10, 10);
		assertEquals(date.toString(), "2018-10-10 10:10:10");
	}
	@Test
	public void testDateTimeString() {
		DateTime date = new DateTime("2018-10-10 10:10:10");
		assertEquals(date.toString(), "2018-10-10 10:10:10");
	}

}
