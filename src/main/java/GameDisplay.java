import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.ArrayList;

public class GameDisplay {

    private static String word;
    private static Random r = new Random();
    private static int wordLength = 0;
    /**
    Create a display window
     */
    public static JFrame frame = new JFrame("MemoryGame");
    public static JPanel top;
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

//        Add top panel which include welcome, start and select difficulties
        top = new JPanel(new BorderLayout());

//        Add welcome panel which contains a start button
        JPanel welcome = new JPanel();
        welcome.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        welcome.add(new JLabel("Type in letters flashed on the left in sequence"));
        JButton start = new JButton("start");
        welcome.add(start);
        top.add(welcome, BorderLayout.NORTH);
        ButtonListener btnListener = new ButtonListener();
        start.addActionListener(btnListener);

//        Add a panel to select difficulties

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(1, 5));
        ArrayList<JButton> selectDifficulties = new ArrayList<JButton>();

        selectDifficulties.add(new JButton("super easy"));
        selectDifficulties.add(new JButton("easy"));
        selectDifficulties.add(new JButton("normal"));
        selectDifficulties.add(new JButton("hard"));
        selectDifficulties.add(new JButton("super hard"));

        DifficultyListener difListener = new DifficultyListener();

        for(int i = 0; i < selectDifficulties.size(); i++) {
            buttons.add(selectDifficulties.get(i));
            selectDifficulties.get(i).addActionListener(difListener);
        }
        top.add(buttons, BorderLayout.CENTER);

        frame.add(top, BorderLayout.NORTH);



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
        resultText = new JLabel("Result");
        resultText.setFont(font);
        result.add(resultText);
        frame.add(result, BorderLayout.SOUTH);
        frame.setVisible(true);


    }

    public static void reset() {
        frame.remove(top);
        frame.remove(content);
        frame.remove(result);
        frame.repaint();
        addComponent();

    }

    public static void flash() {
        word = RandomString.generateString(r, wordLength);
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

    public static void setWordLength(int length) {
        wordLength = length;
    }

    public static void reminder() {
            resultText.setText("Choose Difficulty!!");
            resultText.repaint();
    }

    public static int getWordLength() {
        return wordLength;
    }


}
