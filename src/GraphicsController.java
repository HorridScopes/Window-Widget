import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.GradientPaint;

public class GraphicsController {
    public static BufferedImage createBufferedCanvas(Rectangle bounds) {
        return new BufferedImage(bounds.width, bounds.height, BufferedImage.TYPE_INT_ARGB);
    }

    public static void generateBackgroundGraphic(BufferedImage bIm) {
        Graphics2D g2d = bIm.createGraphics();

        
        Color bodyColor = new Color(0,0,0, 35); // Body
        Color transparentColor = new Color(0,0,0, 0); // Transparent

        int height = bIm.getHeight();

        g2d.setColor(bodyColor);
        g2d.fillRect(0,(int)(height * 0.1),bIm.getWidth(), height);
        
        GradientPaint gp = new GradientPaint(
            0, 0, transparentColor,
            0, (int)(height * 0.1), bodyColor
        );
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, bIm.getWidth(), (int)(height * 0.1));

    g2d.dispose();
    }
}
