import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JWindow;

public class Screen {
    public static void main(String[] args) {
        Screen self = new Screen();
        Main_Visual main_vis = self.new Main_Visual();

    }

    class Main_Visual extends JWindow {
        public Main_Visual() {
            GraphicsDevice gDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
            Rectangle location = gDevice.getDefaultConfiguration().getBounds();

            setLocation((int)location.getX() + 30, (int)location.getY() + (int)location.getHeight());
            setSize(300,300);
            setVisible(true);

            addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e){
                    if(e.getButton() == MouseEvent.BUTTON3){
                        exitWindow();
                    }
                }
            });
        }

        public void exitWindow(){
            dispose();
            System.exit(1);
        }
    }
}
