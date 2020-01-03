import java.awt.event.*;

public class ButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        if(GameDisplay.getWordLength() == 0)
            GameDisplay.reminder();
        else {
            GameDisplay.reset();
            GameDisplay.flash();
        }
    }

}
