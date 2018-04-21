package com.steve.kando;

import org.joda.time.LocalDateTime;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class DateUtilsTest {

    @Test
    public void testAgeFromDate() {
        assertEquals("1m", DateUtils.getAgeFromDate(new LocalDateTime()));
        assertEquals("5m", DateUtils.getAgeFromDate(new LocalDateTime().minusMinutes(5)));
        assertEquals("15m", DateUtils.getAgeFromDate(new LocalDateTime().minusMinutes(15)));

        assertEquals("1h", DateUtils.getAgeFromDate(new LocalDateTime().minusMinutes(62)));
        assertEquals("1h", DateUtils.getAgeFromDate(new LocalDateTime().minusMinutes(105)));
        assertEquals("2h", DateUtils.getAgeFromDate(new LocalDateTime().minusMinutes(125)));
        assertEquals("23h", DateUtils.getAgeFromDate(new LocalDateTime().minusHours(23).minusMinutes(59)));

        assertEquals("1d", DateUtils.getAgeFromDate(new LocalDateTime().minusHours(25)));
        assertEquals("6d", DateUtils.getAgeFromDate(new LocalDateTime().minusDays(6)));

        assertEquals("1w", DateUtils.getAgeFromDate(new LocalDateTime().minusDays(8)));
        assertEquals("52w", DateUtils.getAgeFromDate(new LocalDateTime().minusDays(364)));

        assertEquals("1y", DateUtils.getAgeFromDate(new LocalDateTime().minusDays(366)));
    }

}
