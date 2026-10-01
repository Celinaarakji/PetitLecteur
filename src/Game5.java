import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Game5 extends JFrame {
    public int applesLeft = 5;

    public Game5() {

        setTitle("");
        setSize(600, 400);

        setLayout(null); // Use absolute positioning
        setLocationRelativeTo(null);

        // Set background image
        ImageIcon backgroundIcon = new ImageIcon("/Users/celinaarakji/IdeaProjects/ex/src/home.png");
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        add(backgroundLabel);

        // Create buttons
        ImageIcon buttonIcon1 = new ImageIcon("/Users/celinaarakji/IdeaProjects/ex/src/apple1.png");
        JButton button1 = new JButton(buttonIcon1);
        button1.setBounds(100, 100, 15, 20);
        backgroundLabel.add(button1);

        ImageIcon buttonIcon2 = new ImageIcon("/Users/celinaarakji/IdeaProjects/ex/src/apple2.png");
        JButton button2 = new JButton(buttonIcon2);
        button2.setBounds(400, 130, 50, 50);
        backgroundLabel.add(button2);

        ImageIcon buttonIcon3 = new ImageIcon("/Users/celinaarakji/IdeaProjects/ex/src/apple3.png");
        JButton button3 = new JButton(buttonIcon3);
        button3.setBounds(250, 300, 35, 35);
        backgroundLabel.add(button3);

        ImageIcon buttonIcon4 = new ImageIcon("/Users/celinaarakji/IdeaProjects/ex/src/apple4.png");
        JButton button4 = new JButton(buttonIcon4);
        button4.setBounds(450, 300, 50, 65);
        backgroundLabel.add(button4);

        ImageIcon buttonIcon5 = new ImageIcon("/Users/celinaarakji/IdeaProjects/ex/src/apple5.png");
        JButton button5 = new JButton(buttonIcon4);
        button5.setBounds(90, 250, 50, 55);
        backgroundLabel.add(button5);

        JLabel label6 = new JLabel("  Apples left: " + applesLeft);
        label6.setBounds(450, 20, 100, 30);
        label6.setOpaque(true); // Make the background visible
        label6.setBackground(Color.lightGray); // Set the background color to white
        backgroundLabel.add(label6);

        ImageIcon clickedIcon = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet5/src/clicked.png");


        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //when an apple is picked display its message by calling lesson gui
                // reduce the nb of apples left
                applesLeft--;
                Lessons gui = new Lessons(1);
                button1.setIcon(clickedIcon);
                label6.setText("  Apples left: " + applesLeft);
                checker();
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //when an apple is picked display its message by calling lesson gui
                // reduce the nb of apples left
                applesLeft--;
                Lessons gui = new Lessons(2);
                button2.setIcon(clickedIcon);
                label6.setText("  Apples left: " + applesLeft);
                checker();
            }
        });

        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //when an apple is picked display its message by calling lesson gui
                // reduce the nb of apples left
                applesLeft--;
                Lessons gui = new Lessons(3);
                button3.setIcon(clickedIcon);
                label6.setText("  Apples left: " + applesLeft);
                checker();

            }
        });

        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //when an apple is picked display its message by calling lesson gui
                // reduce the nb of apples left
                applesLeft--;
                Lessons gui = new Lessons(4);
                button4.setIcon(clickedIcon);
                label6.setText("  Apples left: " + applesLeft);
                checker();
            }
        });

        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //when an apple is picked display its message by calling lesson gui
                // reduce the nb of apples left
                applesLeft--;
                Lessons gui = new Lessons(5);
                button5.setIcon(clickedIcon);
                label6.setText("  Apples left: " + applesLeft);
                checker();
            }
        });
    }

    public void checker() {
        if (applesLeft <= 0) {// method that checks if all the apples were picked, if they are then go back menu

            Timer t = new Timer(1000 * 3, new ActionListener() { // wait before changing back
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    Universe fifthStep = new Universe(1,1,1,1,1);
                    fifthStep.setVisible(true);
                    ((Timer) e.getSource()).stop();
                }
            });
            t.start();

        }

    }
}



