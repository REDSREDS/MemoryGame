import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;

public class GameDisplay {

    static String word;
    static Random r = new Random(100);
    /**
    Create a display window
     */
    public static JFrame frame = new JFrame("MemoryGame");
    public static JPanel welcome;
    public static JPanel content;
    public static JPanel result;
    public static JLabel challenge;
    public static JLabel resultText;
    /**
     * Configure frame
     */
    public static void drawFrame() {

        frame.setSize(500, 400);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        addComponent();
    }

    /**
     * add component
     */
    public static void addComponent() {
//        Add welcome panel which contains a start button
        welcome = new JPanel();
        welcome.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        welcome.add(new JLabel("Welcome to the MemoryGame!"));
        JButton start = new JButton("start");
        welcome.add(start);
        frame.add(welcome, BorderLayout.NORTH);
        ButtonListener btnListener = new ButtonListener();
        start.addActionListener(btnListener);



//        Create a content panel, on the left how the random generated string, on the right type answer
        content = new JPanel();
        content.setBackground(Color.RED);
        content.setLayout(new GridLayout(1, 2));
        challenge = new JLabel("Ready?");
        challenge.setHorizontalAlignment(JLabel.CENTER);
        Font font = new Font("Serif", Font.BOLD, 40);
        challenge.setFont(font);
        content.add(challenge);
        JTextField yourTurn = new JTextField("Type");
        content.add((yourTurn), BorderLayout.CENTER);
        yourTurn.setHorizontalAlignment(JLabel.CENTER);
        yourTurn.setFont(font);
        frame.add(content, BorderLayout.CENTER);
        TextListener txtListener = new TextListener();
        yourTurn.addActionListener(txtListener);


//        Bottom panel to display the result
        result = new JPanel();
        result.setBackground(new Color(0,255,0));
        resultText = new JLabel("result");
        resultText.setFont(font);
        result.add(resultText);
        frame.add(result, BorderLayout.SOUTH);
        frame.setVisible(true);


    }

    public static void reset() {
        frame.remove(welcome);
        frame.remove(content);
        frame.remove(result);
        frame.repaint();
        addComponent();

    }

    public static void flash() {
        word = RandomString.generateString(r, 3);
        challenge.setText("Go!");
        challenge.repaint();
        FlashSequence f = new FlashSequence();
        f.flash(challenge, word.toCharArray());
    }

    public static void displayResult(boolean correct) {
        if(correct == true) {
            resultText.setText("Awesome!");
        } else {
            resultText.setText("Try again!");
        }
        resultText.repaint();
    }

    public static String getWord() {
        return word;
    }


}
