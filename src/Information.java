import java.awt.Font;
import java.awt.Point;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
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

    public static String getDay(){
        return LocalDateTime.now().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.US);
    }

    public static String getMonth(){
        return LocalDateTime.now().getMonth().getDisplayName(TextStyle.FULL, Locale.US);
    }

    public static Point getCenteredTextCoordinate(Font font, String text){
        java.awt.image.BufferedImage img = new java.awt.image.BufferedImage(1, 1, java.awt.image.BufferedImage.TYPE_INT_ARGB);
        java.awt.Graphics2D g2d = img.createGraphics();
        java.awt.FontMetrics metrics = g2d.getFontMetrics(font);
        int textWidth = metrics.stringWidth(text);
        int textHeight = metrics.getHeight();
        g2d.dispose();
        return new Point(-textWidth / 2, textHeight / 2);
    }
}
