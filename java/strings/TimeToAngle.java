package strings;

import java.util.Map;

// Given a time, calculate the angle between the hour and minute hands

public class TimeToAngle {
    public static void main(String args[]) {
        var testCases = Map.of("18:00", 180, "18:15", 90, "18:30", 0, "18:45", 90);

        testCases.forEach((time, expected) -> {
            final int angle = getAngle(time);
            final String testResult = angle == expected ? "PASSED" : "FAILED";
            System.out.printf("[%s] input: %s, expected: %s, got: %s\n", testResult, time, expected, angle);
        });
    }

    private static int getAngle(String time) throws IllegalArgumentException {
        int hour;
        int minutes;

        try {
            hour = Integer.valueOf(time.substring(0, 2));
            minutes = Integer.valueOf(time.substring(3, 5));
        } catch (Exception e) {
            throw new IllegalArgumentException("time format should be HH:MM");
        }

        if (hour > 23) {
            throw new IllegalArgumentException("invalid hour");
        }

        if (minutes > 60) {
            throw new IllegalArgumentException("invalid minutes");
        }

        if (hour > 11) {
            hour -= 12;
        }

        // convert hour to angle
        final int hourAngle = (hour * 360) / 12;
        final int minutesAngle = (minutes * 360) / 60;

        return Math.abs(hourAngle - minutesAngle);
    }
}