import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        GameDisplay.displayResult(e.getActionCommand().equals(GameDisplay.getWord())) ;
        System.out.println(e.getActionCommand());
        System.out.println(GameDisplay.getWord());
    }

}
