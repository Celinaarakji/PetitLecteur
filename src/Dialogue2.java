import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dialogue2   extends JFrame{
    //initializing variables and lists
    private ImageIcon[] BFAImages;
    private ImageIcon[] BSAImages;
    private ImageIcon[] PBFQImages;
    private ImageIcon[] PBSQImages;
    public int moves=0;
    public Dialogue2(){

        setLayout(new BorderLayout());

        // B stands for business (business man) , F first, A answers
        // this represents the answers for the first list of questions
        BFAImages= new ImageIcon[6]; // set the images that we will use
        BFAImages[0] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet 2/src/BFA0.png");
        BFAImages[1] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet 2/src/BFA1.png");
        BFAImages[2] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet 2/src/BFA2.png");
        BFAImages[3] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet 2/src/BFA3.png");
        BFAImages[4] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet1/src/KFA4.png");
        BFAImages[5] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet1/src/KFA4.png");

        //S second , A answers
        // this represents the answers for the second list of questions
        BSAImages= new ImageIcon[6]; // set the images that we will use
        BSAImages[0] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet 2/src/BFA0.png");
        BSAImages[1] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet 2/src/BSA1.png");
        BSAImages[2] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet 2/src/BSA2.png");
        BSAImages[3] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet 2/src/BSA3.png");
        BSAImages[4] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet1/src/KSA4.png");
        BSAImages[5] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet1/src/KSA4.png");

        // P stands for prince, B for business,  F first, Q for questions
        // this represents the images for the first list of questions
        PBFQImages= new ImageIcon[5]; // set the images that we will use
        PBFQImages[0] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet 2/src/PBFQ0.png");
        PBFQImages[1] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet 2/src/PBFQ1.png");
        PBFQImages[2] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet 2/src/PBFQ2.png");
        PBFQImages[3] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet 2/src/PBFQ3.png");
        PBFQImages[4] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet1/src/PFQ3.png");


        // P stands for prince,B for business, S for second , Q for questions
        // this represents the images for the second list of questions
        PBSQImages= new ImageIcon[5]; // set the images that we will use
        PBSQImages[0] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet 2/src/PBSQ0.png");
        PBSQImages[1] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet 2/src/PBSQ1.png");
        PBSQImages[2] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet 2/src/PBSQ2.png");
        PBSQImages[3] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet 2/src/PBSQ3.png");
        PBSQImages[4] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet1/src/PSQ3.png");

        //first list of questions
        String [] PFQ= new String [5];
        PFQ[0]="Millions of what?";
        PFQ[1]="Why count them?";
        PFQ[2]="How can you own them?";
        PFQ[3]="Weird... bye";
        PFQ[4]="I gotta go!";

        //second list of questions
        String [] PSQ= new String [5];
        PSQ[0]="What's your name?";
        PSQ[1]="What do you do with the stars?";
        PSQ[2]="You can't even touch them...";
        PSQ[3]="Nice! Goodbye!";
        PSQ[4]="Goodbye!";






        // Top panel with image
        JPanel topPanel = new JPanel();
        JLabel imageLabel = new JLabel(BFAImages[0]);
        topPanel.add(imageLabel);
        add(topPanel, BorderLayout.CENTER);

        // Bottom panel with buttons
        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(getWidth(), 80)); // Set preferred height
        JButton button1 = new JButton(PFQ[moves]);
        JButton button2 = new JButton(PSQ[moves]);
        bottomPanel.setBackground(Color.WHITE);
        button1.setPreferredSize(new Dimension(275, 50)); // Set preferred size for buttons
        button2.setPreferredSize(new Dimension(275, 50));
        bottomPanel.add(button1);
        bottomPanel.add(button2);
        add(bottomPanel, BorderLayout.SOUTH);

        setSize(600, 400); // Set the size of the frame
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // moves monitors what set of slides we should be on
                // if the first button is pressed then the image will display the prince's question
                imageLabel.setIcon(PBFQImages[moves]);
                Timer t = new Timer(1000 * 2, new ActionListener() { // wait before changing back
                    public void actionPerformed(ActionEvent e) {
                        // after displaying for a bit it will then display the answer of the man
                        // it will also update the buttons, each with its own list of question
                        moves++;
                        imageLabel.setIcon(BFAImages[moves]);
                        button1.setText(PFQ[moves]);
                        button2.setText(PSQ[moves]);
                        ((Timer) e.getSource()).stop();
                    }
                });
                t.start();
                checker();



            }
        });


        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                imageLabel.setIcon(PBSQImages[moves]);
                // very similar to the first list the question instead it will just do the same for the second list
                Timer t = new Timer(1000 * 2, new ActionListener() { // wait before changing back
                    public void actionPerformed(ActionEvent e)
                    {
                        moves++;
                        imageLabel.setIcon(BSAImages[moves]);
                        button1.setText(PFQ[moves]);
                        button2.setText(PSQ[moves]);
                        ((Timer) e.getSource()).stop();

                    }
                });
                t.start();
                checker();



            }
        });
        checker();
    }

    public void checker (){
        if (moves>=3){
            //method that makes sure to check moves at each button click
            // when we run out of questions, display the outroduction
            Timer t = new Timer(1000 * 2, new ActionListener() { // wait before deleting gui
                public void actionPerformed(ActionEvent e)
                {
                    dispose();

                }
            });
            t.start();
            Outro2 lol= new Outro2();
            lol.setVisible(true);

        }
    }
}
