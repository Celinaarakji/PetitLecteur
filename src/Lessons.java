import javax.swing.*;


public class Lessons extends JFrame {
    Lessons() {// chained constructors
        this(1);
    }

    Lessons(int n) {

        setTitle("Close when done reading");
        setSize(500, 300);


        setLayout(null); // Use absolute positioning
        setLocationRelativeTo(null);

        // Set background image
        ImageIcon ikon;
        ;
        if (n == 1) { // pick what message to display based on what apple
            ikon = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet5/src/lesson1.png");
        } else if (n == 2) {
            ikon = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet5/src/lesson2.png");
        } else if (n == 3) {
            ikon = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet5/src/lesson3.png");
        } else if (n == 4) {
            ikon = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet5/src/lesson4.png");
        } else if (n == 5) {
            ikon = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet5/src/lesson5.png");
        } else {
            ikon = new ImageIcon("/Users/celinaarakji/IdeaProjects/Monopoly/src/chance4.png");
        }


        JLabel backgroundLabel = new JLabel(ikon); // have the message pop up as an label on the frame
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        add(backgroundLabel);
        setVisible(true);

    }
}



