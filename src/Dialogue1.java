import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dialogue1 extends JFrame{

    //initializing variables and lists
    private ImageIcon[] KFAImages;
    private ImageIcon[] KSAImages;
    private ImageIcon[] PFQImages;
    private ImageIcon[] PSQImages;
    public int moves=0;
    public Dialogue1(){

        // K stands for king, F first, A answers
        // this represents the answers for the first list of questions
        setLayout(new BorderLayout());
        KFAImages= new ImageIcon[6]; // set the images that we will use
        KFAImages[0] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet1/src/KFA0.png");
        KFAImages[1] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet1/src/KFA1.png");
        KFAImages[2] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet1/src/KFA2.png");
        KFAImages[3] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet1/src/KFA3.png");
        KFAImages[4] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet1/src/KFA4.png");
        KFAImages[5] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet1/src/KFA4.png");


        // K stands for king, S second , A answers
        // this represents the answers for the second list of questions
        KSAImages= new ImageIcon[6]; // set the images that we will use
        KSAImages[0] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet1/src/KSA0.png");
        KSAImages[1] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet1/src/KSA1.png");
        KSAImages[2] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet1/src/KSA2.png");
        KSAImages[3] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet1/src/KSA3.png");
        KSAImages[4] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet1/src/KSA4.png");
        KSAImages[5] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet1/src/KSA4.png");


        // P stands for prince, F first, Q for questions
        // this represents the images for the first list of questions
        PFQImages= new ImageIcon[5]; // set the images that we will use
        PFQImages[0] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet1/src/PFQ0.png");
        PFQImages[1] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet1/src/PFQ1.png");
        PFQImages[2] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet1/src/PFQ2.png");
        PFQImages[3] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet1/src/PFQ3.png");
        PFQImages[4] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet1/src/PFQ3.png");


        // P stands for prince, S for second , Q for questions
        // this represents the images for the second list of questions
        PSQImages= new ImageIcon[5]; // set the images that we will use
        PSQImages[0] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet1/src/PSQ0.png");
        PSQImages[1] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet1/src/PSQ1.png");
        PSQImages[2] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet1/src/PSQ2.png");
        PSQImages[3] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet1/src/PSQ3.png");
        PSQImages[4] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet1/src/PSQ3.png");

        //first list of questions
        String [] PFQ= new String [5];
        PFQ[0]="Who are you?";
        PFQ[1]="What do you rule over?";
        PFQ[2]="Then make the sun set..";
        PFQ[3]="I gotta go!";
        PFQ[4]="I gotta go!";

        //second list of questions
        String [] PSQ= new String [5];
        PSQ[0]="Do you know me? I'm not your subject?";
        PSQ[1]="So how many subjects do you have then?";
        PSQ[2]="How do you make everyone obey you?";
        PSQ[3]="Goodbye!";
        PSQ[4]="Goodbye!";




        // Top panel with image
        JPanel topPanel = new JPanel();
        JLabel imageLabel = new JLabel(KFAImages[0]);
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
                imageLabel.setIcon(PFQImages[moves]);
                Timer t = new Timer(1000 * 2, new ActionListener() { // wait before changing back
                    public void actionPerformed(ActionEvent e) {
                        moves++;
                        // after displaying for a bit it will then display the answer of the king
                        // it will also update the buttons, each with its own list of question
                        imageLabel.setIcon(KFAImages[moves]);
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
                // very similar to the first list the question instead it will just do the same for the second list
                imageLabel.setIcon(PSQImages[moves]);
                Timer t = new Timer(1000 * 2, new ActionListener() { // wait before changing back
                    public void actionPerformed(ActionEvent e)
                    {
                        moves++;
                        imageLabel.setIcon(KSAImages[moves]);
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
        System.out.println(moves);
        if (moves>=3){
            //method that makes sure to check moves at each button click
            // when we run out of questions, display the outroduction
            Timer t = new Timer(1000 * 2, new ActionListener() { // wait before deleting this gui
                public void actionPerformed(ActionEvent e)
                {
                    dispose();

                }
            });
            t.start();
            Outro1 lols = new Outro1();
            lols.setVisible(true);

        }
    }
}
