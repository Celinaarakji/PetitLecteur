import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Mazegui extends JFrame {

    //initialize variables and lists
    private JLabel centerLabel;


    public int win=-1;
    public String[] quest;


    public int[] ans;


    private ImageIcon[] walking;


    private ImageIcon[] images;


    public int move=0;
    public String winner="none";






    public Mazegui() {

        // set questions that will be used
        quest = new String[8];
        quest[0]= "The King was abusing his power";
        quest[1]= "The Drunkard shows us how people care more about value than beauty";
        quest [2]="Sadness is the cause of the Drunkard's cycle";
        quest[3]= "If you spend time on something, its value will increase";
        quest [4]= "When you wake up, you should tell your family you love them";
        quest[5]="The important things in life are seen with your heart";
        quest[6]="Judge others by their words";
        quest[7]="Take care of your rose. ";


        // the answers indexes correspond to the questions 1 represents true and 2 false
        // if quest [0]= false then ans[0]= 2
        ans = new int[8];
        ans[0]=2;
        ans[1]=2;
        ans[2]=2;
        ans[3]=1;
        ans[4]=2;
        ans[5]=1;
        ans[6]=2;
        ans[7]=1;



        walking = new ImageIcon[6]; // set the images that we will use
        walking[0] = new ImageIcon("/Users/celinaarakji/IdeaProjects/untitled18/src/first.png");
        walking[1] = new ImageIcon("/Users/celinaarakji/IdeaProjects/untitled18/src/second.png");
        walking[2] = new ImageIcon("/Users/celinaarakji/IdeaProjects/untitled18/src/third.png");
        walking[3] = new ImageIcon("/Users/celinaarakji/IdeaProjects/untitled18/src/fourth.png");
        walking[4] = new ImageIcon("/Users/celinaarakji/IdeaProjects/untitled18/src/fifth.png");
        walking[5] = new ImageIcon("/Users/celinaarakji/IdeaProjects/untitled18/src/fifth.png");


        images = new ImageIcon[5]; // set the images that we will use
        images[0] = new ImageIcon("/Users/celinaarakji/IdeaProjects/untitled18/src/board.png");
        images[1] = new ImageIcon("/Users/celinaarakji/IdeaProjects/untitled18/src/true.png");
        images[2] = new ImageIcon("/Users/celinaarakji/IdeaProjects/untitled18/src/wrong.png");
        images[3] = new ImageIcon("/Users/celinaarakji/IdeaProjects/untitled18/src/winner.png");
        images[4] = new ImageIcon("/Users/celinaarakji/IdeaProjects/untitled18/src/loser.png");



        setSize(700, 800);
        setTitle("MAZE");
        setLocationRelativeTo(null); // Center the frame on the screen
        getContentPane().setBackground(Color.WHITE);


        // Create the main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);
        setContentPane(mainPanel);


        // Create the top panel with FlowLayout
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label1 = new JLabel("Moves needed to win: " +(4-win)+"               ");
        JLabel label2 = new JLabel("Tries left: " + (8 - move)+ "                   ");
        JButton helpButton = new JButton("Help");
        label1.setFont(new Font("Calibri", Font.BOLD, 20)); // Change the font size
        label2.setFont(new Font("Calibri", Font.BOLD, 20)); // Change the font size
        helpButton.setFont(new Font("Calibri", Font.PLAIN, 16)); // Change the font size
        helpButton.setBackground(Color.MAGENTA);
        helpButton.setOpaque(true);
        topPanel.add(label1);
        topPanel.add(label2);
        topPanel.add(helpButton);
        mainPanel.add(topPanel, BorderLayout.NORTH);
        topPanel.setBackground(Color.WHITE);


        // Create the middle panel for displaying images
        JPanel middlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centerLabel = new JLabel(images[0]);
        middlePanel.add(centerLabel,  BorderLayout.CENTER);
        mainPanel.add(middlePanel, BorderLayout.CENTER);


        // Create the bottom panel with the label and buttons
        JPanel bottomPanel = new JPanel(new BorderLayout());
        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel bottomLabel = new JLabel(quest[move]);
        bottomLabel.setFont(new Font("Calibri", Font.PLAIN, 20)); // Change the font size as needed
        bottomPanel.setBackground(Color.WHITE);
        labelPanel.setBackground(Color.WHITE);
        labelPanel.add(bottomLabel);
        bottomPanel.add(labelPanel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton firstButton = new JButton("TRUE");
        JButton secondButton = new JButton("FALSE");
        firstButton.setBackground(Color.GREEN);
        secondButton.setBackground(Color.RED);
        firstButton.setOpaque(true); // Enable background color
        secondButton.setOpaque(true);
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(firstButton);
        buttonPanel.add(secondButton);
        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);




        firstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                determine(1); // pass 1 (represents true) as the parameter to determine
                bottomLabel.setText(quest[move]);
                label1.setText("Moves needed to win: " +(4-win)+"               ");
                label2.setText("Tries left: " + (8 - move)+ "                   ");
            }
        });


        secondButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                determine(2); // pass 2 (represents false) as the parameter to determine
                bottomLabel.setText(quest[move]);
                label1.setText("Moves needed to win: " +(4-win)+"               ");
                label2.setText("Tries left: " + (8 - move)+ "                   ");
            }
        });

        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HelpGui n = new HelpGui(); // help image will pop up

            }
        });


    }






    public void determine(int n){
        if(n==ans[move]){ // if the parameter num ber correspinds wuth the right answer of specifc index being used
            win();        // 1 is true and 2 is false
        }
        else{
            lose();
        }
        move++;
        checkloss();
    }


    public void win(){
        win++;
        centerLabel.setIcon(images[1]); //photo that will declare that its true
        Timer t = new Timer(1000 * 2, new ActionListener() { // wait before changing back
            public void actionPerformed(ActionEvent e) {
                centerLabel.setIcon(walking[win]); //change to next walking path
                ((Timer) e.getSource()).stop();
            }
        });
        t.start();


    }


    public void lose(){
        centerLabel.setIcon(images[2]);
        Timer t = new Timer(1000 * 2, new ActionListener() { // wait before changing back
            public void actionPerformed(ActionEvent e) {
                if (win==-1){ // if we are still on first question and it's wrong
                    centerLabel.setIcon(images[0]);


                }
                else { // change to corresponding path
                    centerLabel.setIcon(walking[win]);
                }
                ((Timer) e.getSource()).stop();
            }
        });
        t.start();


    }


    public void checkloss(){
        if (win==4){ // if we have reached the end goal
            Timer t = new Timer(1000 * 3, new ActionListener() { // wait before changing back
                public void actionPerformed(ActionEvent e) {
                    centerLabel.setIcon(images[3]); //announce win
                    Timer t = new Timer(1000 * 5, new ActionListener() { // wait before changing back
                        public void actionPerformed(ActionEvent e) {
                            dispose();
                            Outro6 l = new Outro6();
                            l.setVisible(true);
                            ((Timer) e.getSource()).stop();
                        }
                    });
                    t.start();
                    ((Timer) e.getSource()).stop();
                }
            });
            t.start();
        }
        else if (move>=8){
            Timer t = new Timer(1000 * 3, new ActionListener() { // wait before changing back
                public void actionPerformed(ActionEvent e) {
                    centerLabel.setIcon(images[4]); //declare lose
                    Timer t = new Timer(1000 * 5, new ActionListener() { // wait before changing back
                        public void actionPerformed(ActionEvent e) {
                            dispose();
                            Mazegui playAgain = new Mazegui();
                            playAgain.setVisible(true);
                            ((Timer) e.getSource()).stop();
                        }
                    });
                    t.start();
                    ((Timer) e.getSource()).stop();
                }
            });
            t.start();
        }

    }


}
