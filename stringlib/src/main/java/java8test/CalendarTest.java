package java8test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by AiYeSus on 10/26/2017.
 */

public class CalendarTest {

    public static void main(String[] args) {

        Date aDate = null;
        System.out.println("Test Java 8 Date Time:");
        try {
            aDate = new SimpleDateFormat("yyyy-mm-dd").parse("2012-01-15");
            Calendar aCalendar = Calendar.getInstance();
            aCalendar.setTime( aDate );
            System.out.print(aCalendar.get( aCalendar.DAY_OF_MONTH)+","+aCalendar.get( aCalendar.MONTH ));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate locDate = LocalDate.parse("2012-01-15", formatter);
            System.out.print(" "+locDate.getDayOfMonth()+","+locDate.getMonthValue());
        } catch (ParseException pe) {
            System.out.println("ParseException " + pe);
        } catch (DateTimeParseException dtpe) {
            System.out.println("ParseException " + dtpe);
        }
    }
}
