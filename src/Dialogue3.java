import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dialogue3   extends JFrame{

    //initializing variables and lists
    private ImageIcon[] DFAImages;
    private ImageIcon[] DSAImages;
    private ImageIcon[] PDFQImages;
    private ImageIcon[] PDSQImages;
    public int moves=0;
    public Dialogue3(){

        setLayout(new BorderLayout());

        //D stands for Drunkard , F first, A answers
        // this represents the answers for the first list of questions
        DFAImages= new ImageIcon[6]; // set the images that we will use
        DFAImages[0] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet3/src/DFA0.png");
        DFAImages[1] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet3/src/DFA1.png");
        DFAImages[2] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet3/src/DFA2.png");
        DFAImages[3] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet3/out/production/Planet3/DFA3.png");
        DFAImages[4] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet1/src/KFA4.png");
        DFAImages[5] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet1/src/KFA4.png");

        //S second , A answers
        // this represents the answers for the second list of questions
        DSAImages= new ImageIcon[6]; // set the images that we will use
        DSAImages[0] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet3/src/DSA0.png");
        DSAImages[1] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet3/src/DSA1.png");
        DSAImages[2] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet3/src/DSA2.png");
        DSAImages[3] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet3/src/DSA3.png");
        DSAImages[4] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet1/src/KSA4.png");
        DSAImages[5] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet1/src/KSA4.png");

        // P stands for prince, D for Drunkard,  F first, Q for questions
        // this represents the images for the first list of questions
        PDFQImages= new ImageIcon[5]; // set the images that we will use
        PDFQImages[0] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet3/src/PDFQ0.png");
        PDFQImages[1] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet3/src/PDFQ1.png");
        PDFQImages[2] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet3/src/PDFQ2.png");
        PDFQImages[3] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet 2/src/PBFQ3.png");
        PDFQImages[4] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet1/src/PFQ3.png");


        //S for second , Q for questions
        //  this represents the images for the second list of questions
        PDSQImages= new ImageIcon[5]; // set the images that we will use
        PDSQImages[0] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet3/src/PDSQ0.png");
        PDSQImages[1] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet3/src/PDSQ1.png");
        PDSQImages[2] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet3/src/PDSQ2.png");
        PDSQImages[3] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet 2/src/PBSQ3.png");
        PDSQImages[4] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet1/src/PSQ3.png");

        //first list of questions
        String [] PFQ= new String [5];
        PFQ[0]="What's your name?";
        PFQ[1]="Why are you drinking?";
        PFQ[2]="What do you mean?";
        PFQ[3]="Damn that's tuff";
        PFQ[4]="I gotta go!";

        //second list of questions
        String [] PSQ= new String [5];
        PSQ[0]="What are you doing?";
        PSQ[1]="You think drinking solves problems?";
        PSQ[2]="What are you ashamed of?";
        PSQ[3]="Get help man, bye";
        PSQ[4]="Goodbye!";





        // Top panel with image
        JPanel topPanel = new JPanel();
        JLabel imageLabel = new JLabel(DFAImages[0]);
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
                imageLabel.setIcon(PDFQImages[moves]);
                // moves monitors what set of slides we should be on
                // if the first button is pressed then the image will display the prince's question
                Timer t = new Timer(1000 * 2, new ActionListener() { // wait before changing back
                    public void actionPerformed(ActionEvent e) {
                        // after displaying for a bit it will then display the answer of the man
                        // it will also update the buttons, each with its own list of question
                        moves++;
                        imageLabel.setIcon(DFAImages[moves]);
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
                imageLabel.setIcon(PDSQImages[moves]);
                Timer t = new Timer(1000 * 2, new ActionListener() { // wait before changing back
                    public void actionPerformed(ActionEvent e)
                    {
                        moves++;
                        imageLabel.setIcon(DSAImages[moves]);
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
        //method that makes sure to check moves at each button click
        // when we run out of questions, display the outroduction

        if (moves>=3){
            Timer t = new Timer(1000 * 2, new ActionListener() { // wait before changing back
                public void actionPerformed(ActionEvent e)
                {
                    dispose();

                }
            });
            t.start();
            Outro3 lol= new Outro3();
            lol.setVisible(true);

        }
    }
}
