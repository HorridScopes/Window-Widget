import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JWindow;

public class Screen {
    public static void main(String[] args) {
        Screen self = new Screen();
        ResourceHandler.handleAllResources();
        Information.setDateFormat("dd");
        Information.setTimeFormat("hh:mma");
        Main_Visual main_vis = self.new Main_Visual();
    }

    class Main_Visual extends JWindow {
        public Main_Visual() {
            GraphicsDevice gDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
            Rectangle location = gDevice.getDefaultConfiguration().getBounds();

            setBackground(new Color(0, 0, 0, 0));
            setSize(
                (int) location.getWidth(),
                200
            );

            setLocation(
                (int) location.getX(),
                (int) location.getY() + (int) location.getHeight() - getHeight()
            );


            addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == MouseEvent.BUTTON3) {
                        exitWindow();
                    }
                }
            });
            GraphicsController.createBufferedCanvas(getBounds());
            GraphicsController.generateBackgroundGraphic();

            setVisible(true);
            repaint();
        }

        public void exitWindow() {
            dispose();
            System.exit(1);
        }

        public void paint(Graphics g) {
            BufferedImage bIm = GraphicsController.generateFullGraphics();
            g.drawImage(bIm, 0, 0, null);
        }
    }
}
