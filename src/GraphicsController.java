import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.time.Month;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;

public class GraphicsController {

    public static BufferedImage backgroundGraphic;
    public static BufferedImage secondaryBufferedGGraphic;

    public static void InstantiateBackground() {
    }

    public static void createBufferedCanvas(Rectangle bounds) {
        secondaryBufferedGGraphic = new BufferedImage(bounds.width, bounds.height, BufferedImage.TYPE_INT_ARGB);
        backgroundGraphic = new BufferedImage(bounds.width, bounds.height, BufferedImage.TYPE_INT_ARGB);
    }

    public static RenderingHints getRenderingHints() {
        RenderingHints hints = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        return hints;
    }

    public static void generateBackgroundGraphic() {
        Graphics2D g2d = backgroundGraphic.createGraphics();
        g2d.setRenderingHints(getRenderingHints());
        Color bodyColor = new Color(0, 0, 0, 35); // Body
        Color transparentColor = new Color(0, 0, 0, 0); // Transparent

        int height = backgroundGraphic.getHeight();

        g2d.setColor(bodyColor);
        g2d.fillRect(0, (int) (height * 0.2), backgroundGraphic.getWidth(), height);

        GradientPaint gp = new GradientPaint(
                0, 0, transparentColor,
                0, (int) (height * 0.2), bodyColor);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, backgroundGraphic.getWidth(), (int) (height * 0.2));

        g2d.dispose();
    }

    public static void generateTimeText(BufferedImage bIm) {
        Graphics2D g2d = bIm.createGraphics();
        g2d.setRenderingHints(getRenderingHints());
        Font font = ResourceHandler.fontCache.get("AlumniSansSC");
        font.deriveFont(Font.BOLD);
        String time = Information.getTimeAsString();
        
        while (font.getSize() < bIm.getHeight() * 0.8) {
            font = font.deriveFont((float) (font.getSize() + 1));
        }
        g2d.setFont(font);
        
        Point timeLocation = Information.getCenteredTextCoordinate(font, time);
        timeLocation.y += (int)(bIm.getHeight() * 0.1);
        timeLocation.x += (int)(bIm.getWidth() * 0.5);

        Rectangle timeBounds = g2d.getFontMetrics().getStringBounds(time, g2d).getBounds();
        timeBounds.setLocation((int)timeLocation.getX(), (int)timeLocation.getY());
        g2d.drawString(time, (int)timeBounds.getX(), (int)timeBounds.getY());
        
        font = ResourceHandler.fontCache.get("AlumniSansSC");
        while(font.getSize() < g2d.getFont().getSize()){
            font = font.deriveFont(font.getSize() + 1f);
        }
        String[] sec = Information.getTimeOfSecond().split("");

        int mainTimeWidth = g2d.getFontMetrics(g2d.getFont()).stringWidth(time.split(" ")[0]);
        mainTimeWidth += 12;
        font = ResourceHandler.fontCache.get("AlumniSansSC");
        while(font.getSize() * 2 < g2d.getFont().getSize() * 0.9){
            font = font.deriveFont(font.getSize() + 1f);
        }
        font = font.deriveFont(Font.BOLD);      
        g2d.setFont(font);
        g2d.drawString(sec[0],mainTimeWidth + (int)timeLocation.getX(), (int)timeLocation.getY() - (int)(g2d.getFont().getSize() * 0.7));
        g2d.drawString(sec[1],mainTimeWidth + (int)timeLocation.getX(), (int)timeLocation.getY());


        font = ResourceHandler.fontCache.get("AlumniSansSC");
        font.deriveFont(1f);
        while(font.getSize() < (bIm.getHeight() - timeLocation.getY()) * 0.6){
            font = font.deriveFont(font.getSize() + 1f);
        }

        String date = Information.getDateAsString();

        g2d.setFont(font);
        g2d.setColor(Color.WHITE); // Set text color as needed

        Point centeredTextCoordinate = Information.getCenteredTextCoordinate(font, date);
        g2d.drawString(date, centeredTextCoordinate.x + (int)(bIm.getWidth() / 2), (int)(bIm.getHeight() * 0.8));

        
        drawSideInformation(g2d, new Dimension(bIm.getWidth(), bIm.getHeight()));
    
        g2d.dispose();
    }

    public static void drawSideInformation(Graphics2D g2d, Dimension size){
        String[] lines = {
            System.getProperty("user.name").toUpperCase(),
            Long.toString(System.currentTimeMillis())
        };

        Font font = ResourceHandler.fontCache.get("AlumniSansSC");
        font = font.deriveFont((float)(size.height * 0.1));
        g2d.setFont(font);
        int step = font.getSize();
        for(int i = 0; i < lines.length; i ++){
            g2d.drawString(lines[i],(int)(size.width * 0.01),((i + 1) * step) + (int)(size.height * 0.1));
        }

    }

    public static BufferedImage generateFullGraphics() {
        Graphics2D g2d = secondaryBufferedGGraphic.createGraphics();
        g2d.setBackground(new Color(0, 0, 0, 0));
        g2d.clearRect(0, 0, secondaryBufferedGGraphic.getWidth(), secondaryBufferedGGraphic.getHeight());
        g2d.drawImage(backgroundGraphic, 0, 0, null); // Draw our background to the overall
        generateTimeText(secondaryBufferedGGraphic);
        g2d.dispose();
        return secondaryBufferedGGraphic;
    }
}
