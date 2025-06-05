import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
        Information.setDateFormat("MM - dd - yyyy");
        Information.setTimeFormat("hh:mm  a");
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

            while(true){
                try { Thread.sleep(100);
                } catch (InterruptedException e1) { }

                repaint();
            }
        }

        public void exitWindow() {
            dispose();
            System.exit(1);
        }

        public void paint(Graphics g) {
            Graphics2D g2d = (Graphics2D)g;
            g2d.setComposite(java.awt.AlphaComposite.Clear);
            g2d.fillRect(0, 0, getWidth(), getHeight());
            g2d.setComposite(java.awt.AlphaComposite.SrcOver);

            BufferedImage bIm = GraphicsController.generateFullGraphics();
            g2d.drawImage(bIm, 0, 0, null);

            g2d.dispose();
        }
    }
}
