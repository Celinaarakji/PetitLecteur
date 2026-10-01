import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Outro4 extends JFrame{
    private ImageIcon[] introImages;
    public int moves = 0;
    public Outro4() {
        //initialize variables and lists
        // load images
        introImages = new ImageIcon[8]; // set the images that we will use
        introImages[0] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet4/src/outro0.png"); // Change the paths to your images
        introImages[1] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet4/src/outro1.png");
        introImages[2] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet4/src/outro2.png");
        introImages[3] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet4/src/outro3.png");
        introImages[4] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet4/src/outro4.png");
        introImages[5] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet4/src/outro5.png");
        introImages[6] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet4/src/outro6.png");
        introImages[7] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet1/src/outro6.png");



        setLayout(new BorderLayout());

        // Top panel with buttons
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(getWidth(), 50));
        topPanel.setBackground(Color.WHITE);
        JButton button1 = new JButton("B A C K ");
        JButton button2 = new JButton("N E X T");
        topPanel.setLayout(new BorderLayout());
        topPanel.add(button1, BorderLayout.WEST);
        topPanel.add(button2, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);

        //bottom pannel with images
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
                //very similar to intro, it will just monitor what slide we should be on
                // if back is pressed, then go back on previous image
                moves--;
                if (moves==-1){
                    dispose();
                    Game4 lol = new Game4();
                    lol.setVisible(true);
                }
                else{
                    imageLabel.setIcon(introImages[moves]);
                }


            }
        });

        button2.addActionListener(new ActionListener() {
            // if next is clicked then the next slide should be displayed on the image
            @Override
            public void actionPerformed(ActionEvent e) {
                moves++;
                checker();
                imageLabel.setIcon(introImages[moves]);


            }
        });
    }

    public void checker()
    {
        // when we run out of outro slides, bring back to main menu with fifth planet unlocked
        if (moves >= 7)
        {
            dispose();
            Universe fourthStep = new Universe(1,1,1,1,2);
            fourthStep.setVisible(true);

        }
    }
}
