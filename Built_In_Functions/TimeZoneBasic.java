package Built_In_Functions;

import java.time.ZonedDateTime;
import java.time.ZoneId;

public class TimeZoneBasic {
    public static void main(String[] args) {
        // Get current time in GMT
        ZonedDateTime gmtTime = ZonedDateTime.now(ZoneId.of("GMT"));
        System.out.println("Current Time in GMT: " + gmtTime);

        // Get current time in IST (India)
        ZonedDateTime istTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("Current Time in IST: " + istTime);

        // Get current time in PST (USA)
        ZonedDateTime pstTime = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        System.out.println("Current Time in PST: " + pstTime);
    }
}

// Problem 1: Time Zones and ZonedDateTime Write a program that displays the
// current
// time in different time zones:
// ➢ GMT (Greenwich Mean Time)
// ➢ IST (Indian Standard Time)
// ➢ PST (Pacific Standard Time)
// Hint: Use ZonedDateTime and ZoneId to work with different time zones.
