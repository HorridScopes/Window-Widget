import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
public class Information {
    private static DateTimeFormatter timeFormat;
    private static DateTimeFormatter dateFormatter;

    public static void setTimeFormat(String format_){
        timeFormat = DateTimeFormatter.ofPattern(format_);
    }

    public static void setDateFormat(String format_){
        dateFormatter = DateTimeFormatter.ofPattern(format_);
    }

    public static String getDateAsString(){
        return LocalDateTime.now().format(dateFormatter);
    }

    public static String getTimeAsString(){
        return LocalDateTime.now().format(timeFormat);
    }

    public static String getOffsetTime(){
        return OffsetDateTime.now().format(timeFormat);
    }

    public static String getTimeOfSecond(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("ss"));
    }

    
}
