package org.example.sample;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeParser {


    public static void main(String[] args) {

        String timeString = "11:00am to noon";
        timeString = timeString.replaceAll("noon", "12:00pm");

        // Define the date format
        DateFormat dateFormat = new SimpleDateFormat("hh:mma");

        try {
            // Parse the start and end times from the string
            String[] times = timeString.split(" to ");
            Date startTime = dateFormat.parse(times[0]);
            Date endTime = dateFormat.parse(times[1]);

            // Calculate the duration in milliseconds
            long durationInMillis = Math.abs(endTime.getTime() - startTime.getTime());

            // Convert the duration to hour
            long durationInMinutes = durationInMillis / (60 * 1000);

            // Print the duration
            System.out.println("Duration: " + durationInMinutes + " mins");
        } catch (ParseException e) {
            System.out.println("Invalid time format: " + timeString);
        }


    }

}
