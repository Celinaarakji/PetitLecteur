import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Outro2 extends JFrame{

    //initialize varibles and lists
    private ImageIcon[] outroImages;
    public int moves = 0;
    public Outro2() {
        // load images
        outroImages = new ImageIcon[8]; // set the images that we will use
        outroImages[0] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet 2/src/Outro0.png"); // Change the paths to your images
        outroImages[1] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet 2/src/Outro1.png");
        outroImages[2] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet 2/src/Outro2.png");
        outroImages[3] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet 2/src/Outro3.png");
        outroImages[4] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet 2/src/Outro4.png");
        outroImages[5] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet 2/src/Outro5.png");
        outroImages[6] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet 2/src/Outro6.png");
        outroImages[7] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet 2/src/Outro6.png");



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
        JLabel imageLabel = new JLabel(outroImages[0]);
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
                    Dialogue2 lol = new Dialogue2();
                    lol.setVisible(true);
                }
                else{
                    imageLabel.setIcon(outroImages[moves]);
                }


            }
        });

        button2.addActionListener(new ActionListener() {
            // if next is clicked then the next slide should be displayed on the image
            @Override
            public void actionPerformed(ActionEvent e) {
                moves++;
                checker();
                imageLabel.setIcon(outroImages[moves]);


            }
        });
    }

    public void checker()
    // when we run out of outro slides, bring back to main menu with third planet unlocked
    {
        if (moves >= 7)
        {
            dispose();
            Universe stepTwo= new Universe(1,1,2,2,2);
            stepTwo.setVisible(true);

        }
    }
}
