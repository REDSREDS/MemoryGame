import java.awt.event.*;

public class ButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        GameDisplay.reset();
        GameDisplay.flash();

    }

}
