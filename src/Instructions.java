
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Instructions extends JFrame {
    private ImageIcon[] introImages;
    public int moves=0;
    public Instructions() {
        // load images
        introImages = new ImageIcon[4]; // set the images that we will use
        introImages[0] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Intro/src/intro0.png"); // Change the paths to your images
        introImages[1] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Intro/src/intro1.png");
        introImages[2] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Intro/src/intro2.png");
        introImages[3] = new ImageIcon("/Users/celinaarakji/IdeaProjects/brouillon/src/trial4.png");



        setLayout(new BorderLayout());

        // Top panel with buttons back and next
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(getWidth(), 50));
        topPanel.setBackground(Color.WHITE);
        JButton button1 = new JButton("B A C K ");
        JButton button2 = new JButton("N E X T");
        topPanel.setLayout(new BorderLayout());
        topPanel.add(button1, BorderLayout.WEST);
        topPanel.add(button2, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);

        //second panel with the image
        JPanel secondPanel = new JPanel();
        secondPanel.setLayout(new BorderLayout());
        JLabel imageLabel = new JLabel(introImages[0]);
        secondPanel.add(imageLabel, BorderLayout.CENTER);
        add(secondPanel, BorderLayout.CENTER);

        setSize(600, 400); // Set the size of the frame
        setLocationRelativeTo(null); // Center the frame on the screen

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //moves monitors what slide we should be on, so if back is pressed
                // then the previous slide should be displayed on the image
                moves--;

                if (moves==-1){// in case they want to go back from first time, take to menu
                    dispose();

                }

                imageLabel.setIcon(introImages[moves]);



            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // if next is clicked then the next slide should be displayed on the image
                moves++;
                checker();
                imageLabel.setIcon(introImages[moves]);



            }
        });
    }
    public void checker(){
        if (moves>=3){
            // when we run out of introdution slides, go back to menu
            dispose();
        }
    }


}
