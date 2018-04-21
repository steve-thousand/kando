package com.steve.kando;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Interval;
import org.joda.time.LocalDateTime;

public class DateUtils {

    public static String getAgeFromDate(LocalDateTime localDateTime) {
        DateTime now = DateTime.now();
        Interval interval = new Interval(localDateTime.toDateTime(), now);
        Duration duration = interval.toDuration();
        long minutes = duration.getStandardMinutes();

        if(minutes < 1) {
            return "1m";
        }else if(minutes < 60) {
            return minutes + "m";
        }

        long hours = minutes/60;
        if(hours < 24) {
            return hours + "h";
        }

        long days = hours/24;
        if(days < 7) {
            return days + "d";
        }

        long weeks = days/7;
        if(weeks < 52 || days < 365) {
            return weeks + "w";
        }

        long years = weeks/52;
        return years + "y";
    }

}
