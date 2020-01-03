import java.awt.event.*;

public class DifficultyListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("super easy")) {
            GameDisplay.setWordLength(3);
        } else if (e.getActionCommand().equals("easy")) {
            GameDisplay.setWordLength(5);
        } else if (e.getActionCommand().equals("normal")) {
            GameDisplay.setWordLength(7);
        } else if (e.getActionCommand().equals("hard")) {
            GameDisplay.setWordLength(10);
        } else if (e.getActionCommand().equals("super hard")) {
            GameDisplay.setWordLength(20);
        }
    }
}
