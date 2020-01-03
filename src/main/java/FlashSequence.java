import javax.swing.*;
import java.awt.event.*;

public class FlashSequence {
    JLabel label;
    char[] test;
    Timer timer;
    int n = 0;
    public void flash(JLabel label, char[] arr) {
        this.label = label;
        test = arr;
        timer = new Timer(1000, new TimerListener());
        timer.start();

    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            label.repaint();
            label.setText(String.valueOf(test[n]));
            n++;
            if(n >= test.length) {
                timer.stop();
            }
        }
    }
}
