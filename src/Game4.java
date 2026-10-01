import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.*;
import java.io.*;

public class Game4 extends JFrame {

    //initialize variables
    //our goal is to get sleep, thirst and boredom to 0
    private ImageIcon[] images;
    public int sleep=2;
    public int thirst=4;
    public int boredom=4;



    public Game4() {
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Load images
        images = new ImageIcon[4]; // set the images that we will use
        images[0] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet4/src/default.png");
        images[1] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet4/src/sleep.png");
        images[2] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Planet4/src/water.png");
        images[3] = new ImageIcon("/Users/celinaarakji/IdeaProjects/Pet/src/play.png");

        // Create top panel with labels
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        setLocationRelativeTo(null);  // Center the frame on the screen
        JLabel label1 = new JLabel("Sleep: " + (20*sleep) +"%"); // convert our variables to a percentage
        JLabel label2 = new JLabel("Thirst: " + (20* thirst)+"%");
        JLabel label3 = new JLabel("Boredom: " +(20* boredom)+"%");
        label1.setForeground(Color.WHITE); // Set label text color
        label2.setForeground(Color.WHITE);
        label3.setForeground(Color.WHITE);
        label1.setBackground(Color.PINK); // Set label background color
        label2.setBackground(Color.pink);
        label3.setBackground(Color.PINK);
        label1.setOpaque(true); // Enable background color
        label2.setOpaque(true);
        label3.setOpaque(true);
        topPanel.add(label1);
        topPanel.add(label2);
        topPanel.add(label3);

        // Create panel for the image
        JPanel imagePanel = new JPanel(new BorderLayout());
        JLabel imageLabel = new JLabel(images[0]); // Initial image
        imagePanel.add(imageLabel, BorderLayout.CENTER);

        // Create panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton button1 = new JButton("Sleep");
        JButton button2 = new JButton("Thirst");
        JButton button3 = new JButton("Talk");
        button1.setBackground(Color.PINK); // Set button background color
        button2.setBackground(Color.PINK);
        button3.setBackground(Color.PINK);
        button1.setForeground(Color.BLACK); // Set button text color
        button2.setForeground(Color.BLACK);
        button3.setForeground(Color.BLACK);
        button1.setOpaque(true); // Enable background color
        button2.setOpaque(true);
        button3.setOpaque(true);
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);

        // Add action listeners to buttons
        button1.addActionListener(new ActionListener() { // when sleep is clicked
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sleep>0) {
                    // Change image to image1
                    imageLabel.setIcon(images[1]);
                    sleep--;
                    // Update label numbers
                    label1.setText("Sleep: " + (20*sleep)+"%");
                    Timer t = new Timer(1000 * 4, new ActionListener() { // wait before changing back
                        public void actionPerformed(ActionEvent e) {
                            //set default image
                            imageLabel.setIcon(images[0]);
                            ((Timer)e.getSource()).stop();
                        }
                    });
                    t.start();

                }
                checker();
            }
        });


        button2.addActionListener(new ActionListener() { //when thirst is clicked
            @Override
            public void actionPerformed(ActionEvent e) {
                if (thirst>0) {
                    // Change image to image2
                    imageLabel.setIcon(images[2]);
                    thirst--;
                    // Update label numbers
                    label2.setText("Thirst: " + (20* thirst)+"%");



                    Timer t = new Timer(1000 * 2, new ActionListener() { // wait before changing back
                        public void actionPerformed(ActionEvent e) {
                            //set default back
                            imageLabel.setIcon(images[0]);
                            ((Timer)e.getSource()).stop();
                        }
                    });
                    t.start();
                }
                checker();
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (boredom>0) {
                    boredom--;
                    // Update label numbers
                    label3.setText("Boredom: " + (20* boredom)+"%");
                    playSound(); //use sound method

                }
                checker();


            }
        });




        // Add panels to the main frame
        topPanel.setBackground(Color.WHITE);
        buttonPanel.setBackground(Color.WHITE);
        add(topPanel, BorderLayout.NORTH);
        add(imagePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void playSound() {
        try { // import sound files and add their paths in a list
            String fileNum[]= {"/Users/celinaarakji/IdeaProjects/Planet4/src/sound1.wav", "/Users/celinaarakji/IdeaProjects/Planet4/src/sound2.wav", "/Users/celinaarakji/IdeaProjects/Planet4/src/sound3.wav"};
            int randomNumber = (int) (Math.random() * 3); // chose a random path
            File soundFile = new File(fileNum[randomNumber]); //play that path chosen
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }

    public void checker(){
        //after each button is pressed make sure that our variables are still not equal to 0
        // if they are, end game
        if (sleep==0 && boredom==0 && thirst==0){
            Timer t = new Timer(1000 * 2, new ActionListener() { // wait before changing back
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    Outro4 outro= new Outro4();
                    outro.setVisible(true);
                    ((Timer)e.getSource()).stop();
                }
            });
            t.start();

        }
    }


}

